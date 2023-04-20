package com.KookBee.classservice.controller;

import com.KookBee.classservice.domain.entity.Curriculum;
import com.KookBee.classservice.domain.request.CurriculumEditRequest;
import com.KookBee.classservice.domain.request.CurriculumInsertRequest;
import com.KookBee.classservice.service.CurriculumService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curriculum")
@RequiredArgsConstructor
public class CurriculumController {
    private final CurriculumService curriculumService;
    @PostMapping
    public List<Curriculum> insertCurriculum(@RequestBody List<CurriculumInsertRequest> request) {
        return curriculumService.insertCurriculum(request);
    }

    @PutMapping
    public Curriculum updateCurriculum(@RequestBody CurriculumEditRequest request){
        return curriculumService.updateCurriculum(request);
    }

    @GetMapping("/{bootcampId}")
    public List<Curriculum> getCurriculumByBootcampId(@PathVariable("bootcampId") Long bootcampId){
        return curriculumService.getCurriculumByBootcampId(bootcampId);
    }
}
