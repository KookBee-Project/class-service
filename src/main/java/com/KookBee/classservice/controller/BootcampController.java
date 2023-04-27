package com.KookBee.classservice.controller;


import com.KookBee.classservice.domain.entity.Bootcamp;
import com.KookBee.classservice.domain.entity.StudentBootcamp;
import com.KookBee.classservice.domain.request.BootcampCodeRequest;
import com.KookBee.classservice.domain.request.BootcampEditRequest;
import com.KookBee.classservice.domain.request.BootcampInsertRequest;
import com.KookBee.classservice.domain.request.BootcampStatusChangeRequest;
import com.KookBee.classservice.domain.response.BootcampNameListResponse;
import com.KookBee.classservice.domain.response.ManagerBootcampListResponse;
import com.KookBee.classservice.domain.response.StudentBootcampListResponse;
import com.KookBee.classservice.domain.response.TeacherBootcampListResponse;
import com.KookBee.classservice.exception.BootcampCodeCheckException;
import com.KookBee.classservice.exception.BootcampUserCheckException;
import com.KookBee.classservice.service.BootcampService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class/bootcamp")
@RequiredArgsConstructor
public class BootcampController {
    //class 가
    // 강사가 등록되어 있는 지  확인은 여기서 하는거 아님
    private final BootcampService bootcampService;
    @PostMapping
    public Bootcamp createBootcamp(@RequestBody BootcampInsertRequest request) {
        return bootcampService.createClass(request);
    }

    @PostMapping("/student")
    public StudentBootcamp addBootcamp(@RequestBody BootcampCodeRequest bootcampCode) throws BootcampCodeCheckException, BootcampUserCheckException {
        return bootcampService.addBootcamp(bootcampCode);
    }

    @DeleteMapping("/{bootcampId}")
    public String deleteBootcamp(@PathVariable("bootcampId") Long bootcampId) {
        return bootcampService.updateBootcampStatus(bootcampId);
    }
    @PutMapping
    public Bootcamp updateBootcamp(@RequestBody BootcampEditRequest request){
        return bootcampService.updateBootcamp(request);
    }


    @GetMapping("/{bootcampId}")
    public Bootcamp getBootCampDetail(@PathVariable("bootcampId") Long bootcampId){
        return bootcampService.getBootcampById(bootcampId);
    }
    @GetMapping("/student")
    public List<StudentBootcampListResponse> getBootcampByStudent(){
        return bootcampService.getBootcampByStudentId();
    }
    @GetMapping("/manager")
    public List<ManagerBootcampListResponse> getBootcampByManagerId() {
        return bootcampService.getBootcampByManagerId();
    }

    @GetMapping("/teacher")
    public List<TeacherBootcampListResponse> getBootcampListByTeacherId(){
        return bootcampService.getBootcampByTeacherId();
    }

    @GetMapping("/namelist")
    public List<BootcampNameListResponse> getBootcampNameList(){
        return bootcampService.getBootcampNameList();
    }

}

