package com.KookBee.classservice.controller;

import com.KookBee.classservice.domain.entity.Curriculum;
import com.KookBee.classservice.domain.entity.HomeworkAnswer;
import com.KookBee.classservice.domain.entity.HomeworkQuestion;
import com.KookBee.classservice.domain.request.HomeworkAnswerCommentRequest;
import com.KookBee.classservice.domain.request.HomeworkAnswerEditRequest;
import com.KookBee.classservice.domain.request.HomeworkAnswerRequest;
import com.KookBee.classservice.domain.request.HomeworkQuestionRequest;
import com.KookBee.classservice.domain.response.*;
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

    @PostMapping("/answer")
    public HomeworkAnswer createHomeworkAnswer(@RequestBody HomeworkAnswerRequest request){
        return homeworkService.createHomeworkAnswer(request);
    }

    @PostMapping("/comment")
    public HomeworkAnswer createHomeworkAnswerComment(@RequestBody HomeworkAnswerCommentRequest request){
        return homeworkService.createHomeworkAnswerComment(request);
    }
    @GetMapping("/list/{curriculumId}")
    public List<TeacherHomeworkListResponse> getTeacherHomeworkList(@PathVariable("curriculumId") Long curriculumId) {
        return homeworkService.getHomeworkList(curriculumId);
    }

    @GetMapping("/detail/{homeworkId}")
    public TeacherHomeworkDetailResponse getHomeworkDetail(@PathVariable("homeworkId") Long homeworkId){
        return homeworkService.getHomeworkDetail(homeworkId);
    }

    @GetMapping("/teacher/answer/detail/{homeworkAnswerId}")
    public TeacherHomeworkAnswerDetailResponse getTeacherHomeworkAnswerDetail(@PathVariable("homeworkAnswerId") Long homeworkAnswerId){
        return homeworkService.getTeacherHomeworkAnswerDetail(homeworkAnswerId);
    }

    @GetMapping("/student/list/{bootcampId}")
    public List<StudentHomeworkListResponse> getStudentHomeworkList(@PathVariable("bootcampId") Long bootcampId){
        return homeworkService.getStudentHomeworkList(bootcampId);
    }

    @GetMapping("/student/detail/{homeworkId}")
    public StudentHomeworkDetailResponse getStudentHomeworkDetail(@PathVariable("homeworkId") Long homeworkId){
        return homeworkService.getStudentHomeworkDetail(homeworkId);
    }

    @GetMapping("/answer/detail/{homeworkAnswerId}")
    public StudentHomeworkAnswerDetailResponse getStudentHomeworkAnswerDetail(@PathVariable("homeworkAnswerId") Long homeworkAnswerId){
        return homeworkService.getStudentHomeworkAnswerDetail(homeworkAnswerId);
    }

    @GetMapping("/answer/list/{homeworkQuestionId}")
    public List<TeacherHomeworkAnswerListResponse> getTeacherHomeworkAnswerList(@PathVariable("homeworkQuestionId") Long homeworkQuestionId){
        return homeworkService.getTeacherHomeworkAnswerList(homeworkQuestionId);
    }

    @PutMapping("/answer/edit")
    public HomeworkAnswer updateHomeworkAnswer(@RequestBody HomeworkAnswerEditRequest request){
        return homeworkService.updateHomeworkAnswer(request);
    }

}
