package com.KookBee.classservice.controller;

import com.KookBee.classservice.domain.entity.Curriculum;
import com.KookBee.classservice.domain.entity.HomeworkQuestion;
import com.KookBee.classservice.domain.request.HomeworkQuestionRequest;
import com.KookBee.classservice.domain.response.TeacherHomeworkDetailResponse;
import com.KookBee.classservice.domain.response.TeacherHomeworkListResponse;
import com.KookBee.classservice.service.CurriculumService;
import com.KookBee.classservice.service.HomeworkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class/homework")
@RequiredArgsConstructor
public class HomeworkController {
    private final HomeworkService homeworkService;

    @PostMapping
    public HomeworkQuestion createHomework(@RequestBody HomeworkQuestionRequest request){
        return homeworkService.createHomework(request);
    }

    @GetMapping("/list/{curriculumId}")
    public List<TeacherHomeworkListResponse> getTeacherHomeworkList(@PathVariable("curriculumId") Long curriculumId) {
        return homeworkService.getHomeworkList(curriculumId);
    }

    @GetMapping("/detail/{homeworkId}")
    public TeacherHomeworkDetailResponse getHomeworkDetail(@PathVariable("homeworkId") Long homeworkId){
        return homeworkService.getHomeworkDetail(homeworkId);
    }
}
