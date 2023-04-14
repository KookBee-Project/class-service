package com.KookBee.classservice.controller;


import com.KookBee.classservice.domain.entity.Classes;
import com.KookBee.classservice.domain.request.ClassInsertRequest;
import com.KookBee.classservice.service.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("classes")
@RequiredArgsConstructor
public class ClassController {
    //class 가
    // 강사가 등록되어 있는 지  확인은 여기서 하는거 아님
    private final ClassService classService;
    @PostMapping()
    public Classes createClass(@RequestBody ClassInsertRequest request) {
        return classService.createClass(request);
    }

}
