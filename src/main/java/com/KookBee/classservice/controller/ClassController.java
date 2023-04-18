package com.KookBee.classservice.controller;


import com.KookBee.classservice.domain.entity.Classes;
import com.KookBee.classservice.domain.request.ClassEditRequest;
import com.KookBee.classservice.domain.request.ClassInsertRequest;
import com.KookBee.classservice.domain.request.ClassStatusChangeRequest;
import com.KookBee.classservice.service.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/status")
    public String updateClassStatus(@RequestBody ClassStatusChangeRequest request) {
        return classService.updateClassStatus(request);
    }
    @PutMapping()
    public Classes updateClass(@RequestBody ClassEditRequest request){
        return classService.updateClass(request);
    }
    @GetMapping("/teacher")
    public List<Classes> getClassByTeacherId(){
        return classService.getClassesByTeacherId();
    }

}
