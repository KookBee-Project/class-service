package com.KookBee.classservice.service;

import com.KookBee.classservice.domain.dto.DayOffApplyDTO;
import com.KookBee.classservice.domain.entity.Bootcamp;
import com.KookBee.classservice.domain.entity.Curriculum;
import com.KookBee.classservice.domain.entity.DayOff;
import com.KookBee.classservice.domain.entity.StudentBootcamp;
import com.KookBee.classservice.domain.request.DayOffApplyRequest;
import com.KookBee.classservice.domain.response.StudentDayOffBootcampListResponse;
import com.KookBee.classservice.domain.response.StudentDayOffListResponse;
import com.KookBee.classservice.exception.DayOffDateCheckException;
import com.KookBee.classservice.exception.DayOffUseDaysCheckException;
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

    public DayOff dayOffApply(DayOffApplyRequest request) throws DayOffDateCheckException, DayOffUseDaysCheckException {
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

        // 두 개의 커리큘럼이 다르면 다시 신청하도록 에러 반환
        if (startCurriculumId != endCurriculumId){
            throw new DayOffDateCheckException();
        }
        DayOffApplyDTO dto = new DayOffApplyDTO(request,userId,startCurriculumId);
        if (request.getRemainingDayOff() >= dto.getDays()){
            return dayOffRepository.save(new DayOff(dto));
        } else {
           throw new DayOffUseDaysCheckException();
        }
    }

    public List<StudentDayOffBootcampListResponse> getBootcampList(){
        // 토큰에서 userId가져오기
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        // userId로 부트캠프 목록 가져오기
        List<StudentBootcamp> bootcampListByStudentId = studentBootcampRepository.findByStudentId(userId);
        // 가져온 정보들을 response로 만들어주기
        List<StudentDayOffBootcampListResponse> studentDayOffBootcampListResponses
                = bootcampListByStudentId.stream().map(el->{
            // 먼저 부트캠프Id로 커리큘럼List를 가져옵니다.
            List<Curriculum> byBootcamp = curriculumRepository.findByBootcamp(el.getBootcamp());
            // 그 후 커리큘럼의 Id를 통해 휴가들의 총합을 가져옵니다.
            Integer bootcampSumOfDays = byBootcamp.stream().mapToInt(cu->
                dayOffRepository.findSumOfDaysByUserId(userId,cu.getId()).orElse(0)).sum();

            StudentDayOffBootcampListResponse response
                    = new StudentDayOffBootcampListResponse(el.getBootcamp(),bootcampSumOfDays);
            return response;
        }).collect(Collectors.toList());
        return  studentDayOffBootcampListResponses;
    }

    public List<StudentDayOffListResponse> getDayOffList(Long bootcampId){
        // userId 가져오기
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        List<DayOff> byUserIdAndBootcampId = dayOffRepository.findByUserIdAndBootcampId(userId, bootcampId);
        List<StudentDayOffListResponse> responses =
                byUserIdAndBootcampId.stream().map(StudentDayOffListResponse::new)
                        .collect(Collectors.toList());
        return responses;
    }
}
