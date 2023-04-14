package com.KookBee.classservice.controller;

import com.KookBee.classservice.domain.entity.Vacation;
import com.KookBee.classservice.domain.request.VacationApplyRequest;
import com.KookBee.classservice.service.VacationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vacation")
@RequiredArgsConstructor
public class VacationController {
    private final VacationService vacationService;
    @PostMapping("/{className}/{curriculumId}")
    public Vacation vacationApply(@PathVariable("curriculumId") Long curriculumId,
                                  @RequestBody VacationApplyRequest request){
        return vacationService.vacationApply(request, curriculumId);
    }
}
