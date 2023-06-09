package com.KookBee.classservice.service;

import com.KookBee.classservice.client.Campus;
import com.KookBee.classservice.client.User;
import com.KookBee.classservice.client.UserServiceClient;
import com.KookBee.classservice.domain.dto.*;
import com.KookBee.classservice.domain.entity.Bootcamp;
import com.KookBee.classservice.domain.entity.Curriculum;
import com.KookBee.classservice.domain.entity.DayOff;
import com.KookBee.classservice.domain.entity.StudentBootcamp;
import com.KookBee.classservice.domain.request.DayOffApplyRequest;
import com.KookBee.classservice.domain.request.DayOffStatusModifyRequest;

import com.KookBee.classservice.domain.response.dayoff.*;

import com.KookBee.classservice.domain.response.*;

import com.KookBee.classservice.exception.DayOffDateCheckException;
import com.KookBee.classservice.exception.DayOffNoneCurriculumException;
import com.KookBee.classservice.exception.DayOffUseDaysCheckException;
import com.KookBee.classservice.repository.BootcampRepository;
import com.KookBee.classservice.repository.CurriculumRepository;
import com.KookBee.classservice.repository.DayOffRepository;
import com.KookBee.classservice.repository.StudentBootcampRepository;
import com.KookBee.classservice.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
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
    private final BootcampRepository bootcampRepository;
    private final UserServiceClient userServiceClient;

    public void dayOffApply(DayOffApplyRequest request, Long bootcampId)
            throws DayOffDateCheckException, DayOffUseDaysCheckException, DayOffNoneCurriculumException {
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        // request의 시작일과 종료일을 LocalDate타입으로 변경
        LocalDate dayOffStartDate = LocalDate.parse(request.getDayOffStartDate(),
                DateTimeFormatter.ISO_DATE);
        LocalDate dayOffEndDate = LocalDate.parse(request.getDayOffEndDate(),
                DateTimeFormatter.ISO_DATE);

        // 날짜를 통해 커리큘럼Id를 획득
        Long startCurriculumId = curriculumRepository
                .findCIdByBootcampIdAndDate(
                        bootcampId, dayOffStartDate).orElseThrow(DayOffNoneCurriculumException::new);
        Long endCurriculumId = curriculumRepository
                .findCIdByBootcampIdAndDate(
                        bootcampId, dayOffEndDate).orElseThrow(DayOffNoneCurriculumException::new);

        // 두 개의 커리큘럼이 다르면 다시 신청하도록 에러 반환
        if (startCurriculumId != endCurriculumId){
            throw new DayOffDateCheckException();
        }

        // 남은 휴가일수와 신청 휴가일수 비교
        Integer remainingDayOff = getRemainingDayOff(bootcampId, userId);
        DayOffApplyDTO dto = new DayOffApplyDTO(request,userId,startCurriculumId);
        if (remainingDayOff >= dto.getDays()){
            dayOffRepository.save(new DayOff(dto));
        } else {
           throw new DayOffUseDaysCheckException();
        }

    }

    // 남은 휴가일수 구하기---------------------------------
    private Integer getRemainingDayOff(Long bootcampId, Long userId) {
        Bootcamp bootcamp = bootcampRepository.findById(bootcampId).get();
        LocalDate bootcampStartDateLD = LocalDate.parse(
                bootcamp.getBootcampStartDate(), DateTimeFormatter.ISO_DATE);
        Integer bootcampSumOfDays = bootcamp.getCurriculumList().stream().mapToInt(cu->
                dayOffRepository.findSumOfDaysByUserId(userId,cu.getId()).orElse(0)).sum();
        Integer remainingDayOff =
                Math.toIntExact(ChronoUnit.DAYS.between(bootcampStartDateLD, LocalDate.now()))
                        / 30 - bootcampSumOfDays;
        return remainingDayOff;
    }
    // -------------------------------------------------

    public StudentDayOffResponse getDayOff(Long bootcampId){
        // 토큰에서 userId가져오기
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        // 부트캠프 정보 가져오기
        Bootcamp bootcamp = bootcampRepository.findById(bootcampId).orElse(null);
        Integer remainingDayOff = getRemainingDayOff(bootcampId, userId);
        List<StudentDayOffListResponse> dayOffList = dayOffRepository.findByUserIdAndBootcampId(userId, bootcampId).stream().map(el->{
            return new StudentDayOffListResponse(el,bootcamp.getBootcampTitle());
        }).toList();
        return new StudentDayOffResponse(bootcamp, remainingDayOff, dayOffList);
    }
//    public List<StudentDayOffResponse> getBootcampList(){
//        // 토큰에서 userId가져오기
//        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
//        // userId로 부트캠프 목록 가져오기
//        List<StudentBootcamp> bootcampListByStudentId = studentBootcampRepository.findListByStudentId(userId);
//        // 가져온 정보들을 response로 만들어주기
//        List<StudentDayOffResponse> studentDayOffListResponse
//                = bootcampListByStudentId.stream().map(el->{
//            // 먼저 부트캠프Id로 커리큘럼List를 가져옵니다.
//            List<Curriculum> byBootcamp = curriculumRepository.findByBootcamp(el.getBootcamp());
//            // 그 후 커리큘럼의 Id를 통해 휴가들의 총합을 가져옵니다.
//            Integer bootcampSumOfDays = byBootcamp.stream().mapToInt(cu->
//                dayOffRepository.findSumOfDaysByUserId(userId,cu.getId()).orElse(0)).sum();
//
//            StudentDayOffResponse response
//                    = new StudentDayOffResponse(el.getBootcamp(),bootcampSumOfDays);
//            return response;
//        }).collect(Collectors.toList());
//        return studentDayOffListResponse;
//    }

    public List<StudentDayOffListResponse> getDayOffList(Long bootcampId){
        // userId 가져오기
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        Optional<Bootcamp> bootcampById = bootcampRepository.findById(bootcampId);
        List<DayOff> byUserIdAndBootcampId = dayOffRepository.findByUserIdAndBootcampId(userId, bootcampId);
        List<StudentDayOffListResponse> responses =
                byUserIdAndBootcampId.stream().map(el->
                                new StudentDayOffListResponse(el, bootcampById.get().getBootcampTitle()))
                        .collect(Collectors.toList());
        return responses;
    }

    public List<DayOffListForManagerResponse> getDayOffListForManager(){
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        // 일단 휴가를 찾아오자
        List<DayOff> dayOffList = dayOffRepository.findByManagerId(userId);
        List<DayOffListForManagerResponse> responses = dayOffList.stream().map(el->{
            User user = userServiceClient.getUserById(el.getUserId());
            Bootcamp bootcamp = el.getCurriculum().getBootcamp();
            Long campusId = bootcamp.getCampusId();
            Campus campus = userServiceClient.getCampusById(campusId);
            ManagerDayOffListDTO dto = new ManagerDayOffListDTO(user, campus, bootcamp, el);
            return new DayOffListForManagerResponse(dto);
        }).toList();
        return responses;
    }

    public List<DayOffListForTeacherResponse> getDayOffListForTeacher(){
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        // 일단 휴가를 찾아오자
        List<DayOff> dayOffList = dayOffRepository.findByTeacherId(userId);
        List<DayOffListForTeacherResponse> responses = dayOffList.stream().map(el->{
            User user = userServiceClient.getUserById(el.getUserId());
            Bootcamp bootcamp = el.getCurriculum().getBootcamp();
            Long campusId = bootcamp.getCampusId();
            Campus campus = userServiceClient.getCampusById(campusId);
            TeacherDayOffListDTO dto = new TeacherDayOffListDTO(user, campus, bootcamp, el);
            return new DayOffListForTeacherResponse(dto);
        }).toList();
        return responses;
    }

    public DayOffDetailResponse getDayOffDetail(Long dayOffId){
        DayOff dayOff = dayOffRepository.findById(dayOffId).get();

        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        User admin = userServiceClient.getUserById(userId);
        User student = userServiceClient.getUserById(dayOff.getUserId());
        Bootcamp bootcamp = dayOff.getCurriculum().getBootcamp();
        Long campusId = bootcamp.getCampusId();
        Campus campus = userServiceClient.getCampusById(campusId);
        DayOffDetailDTO dto = new DayOffDetailDTO(dayOff, admin, student, campus, bootcamp);
        return new DayOffDetailResponse(dto);
    }

    public void putDayOffStatus(Long dayOffId, DayOffStatusModifyRequest request){
        DayOffStatusModifyDTO dto = new DayOffStatusModifyDTO(dayOffId, request);
        DayOff dayOff = dayOffRepository.findById(dayOffId).get();
        dayOff.updateDayOffStatus(dto);
        dayOffRepository.save(dayOff);
    }
}
