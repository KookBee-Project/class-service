package com.KookBee.classservice.service;

import com.KookBee.classservice.domain.dto.DayOffApplyDTO;
import com.KookBee.classservice.domain.entity.Bootcamp;
import com.KookBee.classservice.domain.entity.Curriculum;
import com.KookBee.classservice.domain.entity.DayOff;
import com.KookBee.classservice.domain.entity.StudentBootcamp;
import com.KookBee.classservice.domain.request.DayOffApplyRequest;
import com.KookBee.classservice.domain.response.StudentDayOffBootcampListResponse;
import com.KookBee.classservice.exception.DayOffDateCheckException;
import com.KookBee.classservice.repository.BootcampRepository;
import com.KookBee.classservice.repository.CurriculumRepository;
import com.KookBee.classservice.repository.DayOffRepository;
import com.KookBee.classservice.repository.StudentBootcampRepository;
import com.KookBee.classservice.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DayOffService {
    private final DayOffRepository dayOffRepository;
    private final CurriculumRepository curriculumRepository;
    private final JwtService jwtService;
    private final StudentBootcampRepository studentBootcampRepository;

    public DayOff vacationApply(DayOffApplyRequest request) throws DayOffDateCheckException {
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        // request의 시작일과 종료일을 LocalDate타입으로 변경
        LocalDate dayOffStartDate = LocalDate.parse(request.getDayOffStartDate(),
                DateTimeFormatter.ISO_DATE);
        LocalDate dayOffEndDate = LocalDate.parse(request.getDayOffEndDate(),
                DateTimeFormatter.ISO_DATE);

        // 날짜를 통해 커리큘럼Id를 획득
        Long startCurriculumId = curriculumRepository
                .findCIdByBootcampIdAndDate(
                        request.getBootcampId(), dayOffStartDate).orElse(null);
        Long endCurriculumId = curriculumRepository
                .findCIdByBootcampIdAndDate(
                        request.getBootcampId(), dayOffEndDate).orElse(null);

        System.out.println("start : " + startCurriculumId);
        System.out.println("end : " + endCurriculumId);
        // 두 개의 커리큘럼이 다르면 다시 신청하도록 에러 반환
        if (startCurriculumId != endCurriculumId){
            throw new DayOffDateCheckException();
        }
        DayOffApplyDTO dto = new DayOffApplyDTO(request,userId,startCurriculumId);
        return dayOffRepository.save(new DayOff(dto));
    }

    public List<StudentDayOffBootcampListResponse> getBootcampList(){
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        List<StudentBootcamp> bootcampListByStudentId = studentBootcampRepository.findByStudentId(userId);
        Optional<Integer> sumOfDays = dayOffRepository.findSumOfDaysByUserId(userId);
        List<StudentDayOffBootcampListResponse> studentDayOffBootcampListResponses
                = bootcampListByStudentId.stream().map(el->{
            StudentDayOffBootcampListResponse response
                    = new StudentDayOffBootcampListResponse(el.getBootcamp(),sumOfDays.orElse(0));
            return response;
        }).collect(Collectors.toList());
        return  studentDayOffBootcampListResponses;
    }
}
