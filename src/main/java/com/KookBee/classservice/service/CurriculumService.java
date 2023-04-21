package com.KookBee.classservice.service;

import com.KookBee.classservice.client.User;
import com.KookBee.classservice.client.UserServiceClient;
import com.KookBee.classservice.domain.entity.Bootcamp;
import com.KookBee.classservice.domain.entity.Curriculum;
import com.KookBee.classservice.domain.entity.SkillSet;
import com.KookBee.classservice.domain.request.CurriculumEditRequest;
import com.KookBee.classservice.domain.request.CurriculumInsertRequest;
import com.KookBee.classservice.domain.response.ManagerBootcampListResponse;
import com.KookBee.classservice.domain.response.ManagerCurriculumListResponse;
import com.KookBee.classservice.repository.BootcampRepository;
import com.KookBee.classservice.repository.CurriculumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
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
            SkillSet skillSet = new SkillSet(el.getSkillSetId());
            Curriculum curriculum = new Curriculum(el, bootcamp, user.getId(), skillSet);
            return curriculumRepository.save(curriculum);
        }).collect(Collectors.toList());
       return curriculumList;
    }

    public List<Curriculum> updateCurriculum (List<CurriculumEditRequest> request){
        List<CurriculumInsertRequest> requests = new ArrayList<>();
        List<Curriculum> response = request.stream().map(el -> {
            if(el.getId() == 0){
                requests.add(new CurriculumInsertRequest(el));
                return null;
            } else {
                Curriculum findById = curriculumRepository.findById(el.getId()).orElse(null);
                assert findById != null;
                User user = userServiceClient.getUserByEmail(el.getTeacherEmail());
                SkillSet skillSet = new SkillSet(el.getSkillSetId());
                findById.updateCurriculum(el, skillSet, user.getId());
                return curriculumRepository.save(findById);
            }
        }).collect(Collectors.toList());
        insertCurriculum(requests);
        return response;
    }

    public List<ManagerCurriculumListResponse> getCurriculumByBootcampId(Long bootcampId) {
        Bootcamp bootcamp = new Bootcamp(bootcampId);
        List<Curriculum> curriculum = curriculumRepository.findByBootcamp(bootcamp);
        List<ManagerCurriculumListResponse> managerCurriculumListResponses = curriculum.stream().map(el -> {
            User teacher = userServiceClient.getTeacherByTeacherId(el.getTeacherId());
            return new ManagerCurriculumListResponse(el, teacher.getUserEmail());
        }).collect(Collectors.toList());
        return managerCurriculumListResponses;
    }
}
