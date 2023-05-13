package com.KookBee.classservice.controller;

import com.KookBee.classservice.domain.request.DayOffApplyRequest;
import com.KookBee.classservice.domain.request.DayOffStatusModifyRequest;
import com.KookBee.classservice.domain.response.dayoff.*;
import com.KookBee.classservice.exception.DayOffDateCheckException;
import com.KookBee.classservice.exception.DayOffNoneCurriculumException;
import com.KookBee.classservice.exception.DayOffUseDaysCheckException;
import com.KookBee.classservice.service.DayOffService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class/dayoff")
@RequiredArgsConstructor
public class DayOffController {
    private final DayOffService dayOffService;
    @PostMapping("/{bootcampId}/apply")
    @ResponseStatus(HttpStatus.CREATED)
    public void dayOffApply(@PathVariable Long bootcampId,@RequestBody DayOffApplyRequest request)
            throws DayOffDateCheckException, DayOffUseDaysCheckException, DayOffNoneCurriculumException {
            dayOffService.dayOffApply(request, bootcampId);
    }

    @GetMapping("/{bootcampId}")
    public StudentDayOffResponse getBootcampList(@PathVariable("bootcampId") Long bootcampId){
        return dayOffService.getDayOff(bootcampId);
    }

//    @GetMapping("/{bootcampId}")
//    public  List<StudentDayOffListResponse> getDayOffList(@PathVariable("bootcampId") Long bootcampId) {
//        return dayOffService.getDayOffList(bootcampId);
//    }

    @GetMapping("/admin/manager")
    public List<DayOffListForManagerResponse> getDayOffListForManager(){
        return dayOffService.getDayOffListForManager();
    }

    @GetMapping("/admin/teacher")
    public List<DayOffListForTeacherResponse> getDayOffListForTeacher(){
        return dayOffService.getDayOffListForTeacher();
    }

    @GetMapping("/admin/{dayOffId}")
    public DayOffDetailResponse getDayOffDetail(@PathVariable Long dayOffId){
        return dayOffService.getDayOffDetail(dayOffId);
    }

    @PutMapping("/admin/{dayOffId}")
    public void putDayOffStatusModify(@PathVariable Long dayOffId, @RequestBody DayOffStatusModifyRequest request){
        dayOffService.putDayOffStatus(dayOffId, request);
    }
}
