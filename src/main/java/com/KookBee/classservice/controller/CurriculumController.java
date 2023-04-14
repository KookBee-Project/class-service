package com.KookBee.classservice.controller;

import com.KookBee.classservice.domain.entity.Curriculum;
import com.KookBee.classservice.domain.request.CurriculumInsertRequest;
import com.KookBee.classservice.service.CurriculumService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("curriculum")
@RequiredArgsConstructor
public class CurriculumController {
    private final CurriculumService curriculumService;
    @PostMapping()
    public Curriculum insertCurriculum(@RequestBody CurriculumInsertRequest request) {
        return curriculumService.insertCurriculum(request);
    }
}
