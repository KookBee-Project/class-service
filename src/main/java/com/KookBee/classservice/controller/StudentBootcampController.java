package com.KookBee.classservice.controller;

import com.KookBee.classservice.domain.entity.StudentBootcamp;
import com.KookBee.classservice.service.StudentBootcampService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/studentBootcamp")
public class StudentBootcampController {
    private final StudentBootcampService studentBootcampService;

    @GetMapping("/{id}")
    public StudentBootcamp findByStudentId (@PathVariable Long id) {
        return studentBootcampService.findByStudentId(id);
    }

}
