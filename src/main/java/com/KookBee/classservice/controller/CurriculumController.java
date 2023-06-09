package com.KookBee.classservice.controller;

import com.KookBee.classservice.domain.entity.Curriculum;
import com.KookBee.classservice.domain.entity.SkillSet;
import com.KookBee.classservice.domain.request.CurriculumEditRequest;
import com.KookBee.classservice.domain.request.CurriculumInsertRequest;
import com.KookBee.classservice.domain.response.CurriculumCalendarResponse;
import com.KookBee.classservice.domain.response.ManagerCurriculumListResponse;
import com.KookBee.classservice.domain.response.TeacherAndStudentCurriculumListResponse;
import com.KookBee.classservice.service.CurriculumService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/class/curriculum")
@RequiredArgsConstructor
public class CurriculumController {
    private final CurriculumService curriculumService;
    @PostMapping
    public List<Curriculum> insertCurriculum(@RequestBody List<CurriculumInsertRequest> request) {
        return curriculumService.insertCurriculum(request);
    }

    @PutMapping
    public List<Curriculum> updateCurriculum(@RequestBody List<CurriculumEditRequest> request){
        return curriculumService.updateCurriculum(request);
    }

    @GetMapping("/{bootcampId}")
    public List<ManagerCurriculumListResponse> getCurriculumByBootcampId(@PathVariable("bootcampId") Long bootcampId){
        return curriculumService.getCurriculumByBootcampId(bootcampId);
    }

    @GetMapping("/teacher/{bootcampId}")
    public List<TeacherAndStudentCurriculumListResponse> getCurriculumList(@PathVariable("bootcampId") Long bootcampId){
        return curriculumService.getTeacherCurriculumByBootcampId(bootcampId);
    }

    @DeleteMapping
    public List<Curriculum> deleteCurriculum(@RequestBody List<Long> curriculumIds){

        return curriculumService.deleteCurriculum(curriculumIds);
    }

    @GetMapping("/curriculumList/{userId}")
    public List<TeacherAndStudentCurriculumListResponse> getCurriculumByUserId(@PathVariable("userId") Long userId) {
        return curriculumService.getCurriculum(userId);
    }
    @GetMapping("/list/{curriculumId}")
    public Curriculum getCurriculumByCurriculumId(@PathVariable Long curriculumId) {
        return curriculumService.getCurriculumByCurriculumId(curriculumId);
    }
    @GetMapping("/student/{bootcampId}")
    public List<CurriculumCalendarResponse> getCurriculumForCalendar(@PathVariable("bootcampId") Long bootcampId){
        return curriculumService.getCurriculumForCalendar(bootcampId);
    }
}
