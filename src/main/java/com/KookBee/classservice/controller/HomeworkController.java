package com.KookBee.classservice.controller;

import com.KookBee.classservice.domain.entity.HomeworkQuestions;
import com.KookBee.classservice.domain.request.HomeworkQuestionRequest;
import com.KookBee.classservice.service.HomeworkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/homework")
@RequiredArgsConstructor
public class HomeworkController {
    private final HomeworkService homeworkService;

    @PostMapping
    public HomeworkQuestions createHomework(@RequestBody HomeworkQuestionRequest request){
        return homeworkService.createHomework(request);
    }
}
