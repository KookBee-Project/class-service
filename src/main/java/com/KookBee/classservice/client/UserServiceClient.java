package com.KookBee.classservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "USER-SERVICE")
public interface UserServiceClient {
    @GetMapping("/user/{userId}")
    User getUserById(@PathVariable("userId") Long userId);
    @GetMapping("/admin/teacher/{email}")
    User getUserByEmail(@PathVariable("email") String email);

    @GetMapping("/campus/bootcamp/{campusId}")
    Campus getCampusById(@PathVariable("campusId") Long campusId);

    @GetMapping("/admin/manager/teacher/{teacherId}")
    User getTeacherByTeacherId(@PathVariable("teacherId") Long teacherId);

}
