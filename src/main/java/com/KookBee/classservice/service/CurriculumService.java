package com.KookBee.classservice.service;

import com.KookBee.classservice.client.User;
import com.KookBee.classservice.client.UserServiceClient;
import com.KookBee.classservice.domain.entity.Bootcamp;
import com.KookBee.classservice.domain.entity.Curriculum;
import com.KookBee.classservice.domain.request.CurriculumEditRequest;
import com.KookBee.classservice.domain.request.CurriculumInsertRequest;
import com.KookBee.classservice.repository.BootcampRepository;
import com.KookBee.classservice.repository.CurriculumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CurriculumService {
    private final CurriculumRepository curriculumRepository;
    private final BootcampRepository bootcampRepository;
    private final UserServiceClient userServiceClient;

    public List<Curriculum> insertCurriculum (List<CurriculumInsertRequest> request) {
       List<Curriculum> curriculumList =  request.stream().map(el-> {
            Bootcamp bootcamp = new Bootcamp(el.getBootcampId());
            User user = userServiceClient.getUserByEmail(el.getTeacherEmail());
            Curriculum curriculum = new Curriculum(el, bootcamp, user.getId());
            return curriculumRepository.save(curriculum);
        }).collect(Collectors.toList());
       return curriculumList;
    }

    public Curriculum updateCurriculum (CurriculumEditRequest request){
        Curriculum findById = curriculumRepository.findById(request.getId()).orElse(null);
        assert findById != null;
        findById.updateCurriculum(request);
        return curriculumRepository.save(findById);
    }

    public List<Curriculum> getCurriculumByBootcampId(Long bootcampId) {
        Bootcamp bootcamp = new Bootcamp(bootcampId);
        List<Curriculum> curriculum = curriculumRepository.findByBootcamp(bootcamp);
        return curriculum;
    }
}
