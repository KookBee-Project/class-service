package com.KookBee.classservice.service;

import com.KookBee.classservice.domain.dto.ClassDTO;
import com.KookBee.classservice.domain.entity.Classes;
import com.KookBee.classservice.domain.entity.Curriculum;
import com.KookBee.classservice.domain.request.ClassEditRequest;
import com.KookBee.classservice.domain.request.ClassInsertRequest;
import com.KookBee.classservice.domain.request.ClassStatusChangeRequest;
import com.KookBee.classservice.repository.ClassRepository;
import com.KookBee.classservice.repository.CurriculumRepository;
import com.KookBee.classservice.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassService {
    private final ClassRepository classRepository;
    private final CurriculumRepository curriculumRepository;
    private final JwtService jwtService;

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

    public List<Classes> getClassesByTeacherId() {
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        if(jwtService.isValidTokens()){
            try{
                List<Curriculum> findByTeacherId = curriculumRepository.findAllByTeacherId(userId);
                Map<Long, Classes> map = new HashMap<>();
                List<Classes> classesList = findByTeacherId.stream().map(curriculum -> {
                    Classes orDefault = map.getOrDefault(curriculum.getClasses(), null);
                    if(orDefault==null) {
                        orDefault = curriculum.getClasses();
                        map.put(curriculum.getClasses().getId(),orDefault);
                    }
                    return new Classes(orDefault);
                }).toList();
                return classesList;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
