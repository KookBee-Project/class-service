package com.KookBee.classservice.service;

import com.KookBee.classservice.domain.entity.Bootcamp;
import com.KookBee.classservice.domain.entity.Curriculum;
import com.KookBee.classservice.domain.request.CurriculumEditRequest;
import com.KookBee.classservice.domain.request.CurriculumInsertRequest;
import com.KookBee.classservice.repository.BootcampRepository;
import com.KookBee.classservice.repository.CurriculumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CurriculumService {
    private final CurriculumRepository curriculumRepository;
    private final BootcampRepository bootcampRepository;

    public Curriculum insertCurriculum (CurriculumInsertRequest request) {
        Bootcamp bootcamp = bootcampRepository.findById(request.getBootcampId()).orElse(null);
        Curriculum curriculum = new Curriculum(request, bootcamp);
        return curriculumRepository.save(curriculum);
    }

    public Curriculum updateCurriculum (CurriculumEditRequest request){
        Curriculum findById = curriculumRepository.findById(request.getId()).orElse(null);
        assert findById != null;
        findById.updateCurriculum(request);
        return curriculumRepository.save(findById);
    }
}
