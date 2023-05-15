package com.KookBee.classservice.controller;

import com.KookBee.classservice.domain.response.MyPageHomeworkListResponse;
import com.KookBee.classservice.domain.response.MyPageQnAListResponse;
import com.KookBee.classservice.service.MyPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/class/my")
@RequiredArgsConstructor
public class MyPageController {
    private final MyPageService myPageService;

    @GetMapping("/remainday")
    public Long getRemainDayOfBootcamp(){
        return myPageService.getRemainDay();
    }

    @GetMapping("/homework")
    public List<MyPageHomeworkListResponse> getMyHomeworkList(){
        return myPageService.getHomeworkList();
    }

    @GetMapping("/qna")
    public List<MyPageQnAListResponse> getMyQnAList(){
        return myPageService.getQnAList();
    }

    @GetMapping("/skillset")
    public List<String> getMySkillsetNameList(){
        return myPageService.getSkillsetNameList();
    }
}
