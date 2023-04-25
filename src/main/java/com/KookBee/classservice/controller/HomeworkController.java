package com.KookBee.classservice.controller;

import com.KookBee.classservice.domain.entity.Curriculum;
import com.KookBee.classservice.domain.entity.HomeworkQuestion;
import com.KookBee.classservice.domain.response.ManagerCurriculumListResponse;
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
    private final CurriculumService curriculumService;

//    @PostMapping
//    public HomeworkQuestions createHomework(@RequestBody HomeworkQuestionRequest request){
//        return homeworkService.createHomework(request);
//    }

    @GetMapping("/curriculum/{bootcampId}")
    public List<Curriculum> getCurriculumList(@PathVariable("bootcampId") Long bootcampId){
        return curriculumService.getTeacherCurriculumByBootcampId(bootcampId);
    }

    @GetMapping("/list/{curriculumId}")
    public List<HomeworkQuestion> getTeacherHomeworkList(@PathVariable("curriculumId") Long curriculumId) {
        return homeworkService.getHomeworkList(curriculumId);
    }

    @GetMapping("/detail/{homeworkId}")
    public TeacherHomeworkListResponse getHomeworkDetail(@PathVariable("homeworkId") Long homeworkId){
        return homeworkService.getHomeworkDetail(homeworkId);
    }
}
