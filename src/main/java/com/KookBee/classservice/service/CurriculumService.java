package com.KookBee.classservice.service;

import com.KookBee.classservice.domain.entity.Classes;
import com.KookBee.classservice.domain.entity.Curriculum;
import com.KookBee.classservice.domain.request.CurriculumInsertRequest;
import com.KookBee.classservice.repository.ClassRepository;
import com.KookBee.classservice.repository.CurriculumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CurriculumService {
    private final CurriculumRepository curriculumRepository;
    private final ClassRepository classRepository;

    public Curriculum insertCurriculum (CurriculumInsertRequest request) {
        Classes classes = classRepository.findById(request.getId()).orElse(null);
        Curriculum curriculum = new Curriculum(request,classes);
        return curriculumRepository.save(curriculum);
    }
}
