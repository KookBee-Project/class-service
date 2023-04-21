package com.KookBee.classservice.controller;

import com.KookBee.classservice.domain.entity.HomeworkQuestions;
import com.KookBee.classservice.domain.request.HomeworkQuestionRequest;
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
    public HomeworkQuestions createHomework(@RequestBody HomeworkQuestionRequest request){
        return homeworkService.createHomework(request);
    }

    @GetMapping("/{bootcampId}")
    public List<HomeworkQuestions> getTeacherHomeworkList(@PathVariable("bootcampId") Long bootcampId) {
        return homeworkService.getHomeworkList(bootcampId);
    }
}
