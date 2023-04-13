package com.KookBee.classservice.service;

import com.KookBee.classservice.domain.dto.ClassDTO;
import com.KookBee.classservice.domain.entity.Classes;
import com.KookBee.classservice.domain.request.ClassInsertRequest;
import com.KookBee.classservice.repository.ClassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClassService {
    private final ClassRepository classRepository;

    public Classes createClass(ClassInsertRequest request) {
        ClassDTO dto = new ClassDTO(request);
        Classes classes = new Classes(dto);
        return classRepository.save(classes);

    }
}
