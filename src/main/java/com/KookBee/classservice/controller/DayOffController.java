package com.KookBee.classservice.controller;

import com.KookBee.classservice.domain.entity.DayOff;
import com.KookBee.classservice.domain.request.DayOffApplyRequest;
import com.KookBee.classservice.exception.DayOffDateCheckException;
import com.KookBee.classservice.service.DayOffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dayoff")
@RequiredArgsConstructor
public class DayOffController {
    private final DayOffService dayOffService;
    @PostMapping("/apply")
    @ResponseStatus(HttpStatus.CREATED)
    public DayOff dayOffApply(@RequestBody DayOffApplyRequest request) throws DayOffDateCheckException {
        return dayOffService.vacationApply(request);
    }
}
