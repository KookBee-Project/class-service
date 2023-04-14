package com.KookBee.classservice.service;

import com.KookBee.classservice.domain.dto.ClassDTO;
import com.KookBee.classservice.domain.entity.Classes;
import com.KookBee.classservice.domain.request.ClassEditRequest;
import com.KookBee.classservice.domain.request.ClassInsertRequest;
import com.KookBee.classservice.domain.request.ClassStatusChangeRequest;
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

    public String updateClassStatus(ClassStatusChangeRequest request) {
        // 바꿔줘야 하는 아이
        Classes classes = classRepository.findById(request.getClassId()).orElse(null);
        classRepository.save(classes.updateStatus(request.getEStatus()));
        return request.getEStatus().name() + "변경됨";
    }

    public Classes updateClass(ClassEditRequest request) {
        Classes classes = classRepository.findById(request.getClassId()).orElse(null);
        classRepository.save(classes.updateClasses(request));
        return classes;

    }
}
