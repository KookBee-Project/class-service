package com.KookBee.classservice.controller;

import com.KookBee.classservice.domain.entity.DayOff;
import com.KookBee.classservice.domain.request.DayOffApplyRequest;
import com.KookBee.classservice.domain.response.StudentDayOffBootcampListResponse;
import com.KookBee.classservice.domain.response.StudentDayOffListResponse;
import com.KookBee.classservice.exception.DayOffDateCheckException;
import com.KookBee.classservice.exception.DayOffNoneCurriculumException;
import com.KookBee.classservice.exception.DayOffUseDaysCheckException;
import com.KookBee.classservice.service.DayOffService;
import lombok.RequiredArgsConstructor;
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
    public DayOff dayOffApply(@PathVariable Long bootcampId,@RequestBody DayOffApplyRequest request)
            throws DayOffDateCheckException, DayOffUseDaysCheckException, DayOffNoneCurriculumException {
        return dayOffService.dayOffApply(request, bootcampId);
    }

    @GetMapping("/bootcamplist")
    public List<StudentDayOffBootcampListResponse> getBootcampList(){
        return dayOffService.getBootcampList();
    }

    @GetMapping("/{bootcampId}")
    public  List<StudentDayOffListResponse> getDayOffList(@PathVariable("bootcampId") Long bootcampId) {
        return dayOffService.getDayOffList(bootcampId);
    }
}
