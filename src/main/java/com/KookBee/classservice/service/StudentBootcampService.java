package com.KookBee.classservice.service;

import com.KookBee.classservice.domain.entity.StudentBootcamp;
import com.KookBee.classservice.repository.StudentBootcampRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentBootcampService {
    private final StudentBootcampRepository repository;

    public StudentBootcamp findByStudentId(Long id) {
        StudentBootcamp studentBootcamp = repository.findByStudentId(id);
        return studentBootcamp;
    }
}
