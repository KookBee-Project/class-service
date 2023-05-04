package com.KookBee.classservice.service;

import com.KookBee.classservice.client.User;
import com.KookBee.classservice.client.UserServiceClient;
import com.KookBee.classservice.domain.entity.Bootcamp;
import com.KookBee.classservice.domain.entity.Curriculum;
import com.KookBee.classservice.domain.entity.SkillSet;
import com.KookBee.classservice.domain.entity.StudentBootcamp;
import com.KookBee.classservice.domain.enums.EStatus;
import com.KookBee.classservice.domain.request.CurriculumEditRequest;
import com.KookBee.classservice.domain.request.CurriculumInsertRequest;
import com.KookBee.classservice.domain.response.ManagerBootcampListResponse;
import com.KookBee.classservice.domain.response.ManagerCurriculumListResponse;
import com.KookBee.classservice.domain.response.TeacherCurriculumListResponse;
import com.KookBee.classservice.repository.BootcampRepository;
import com.KookBee.classservice.repository.CurriculumRepository;
import com.KookBee.classservice.repository.StudentBootcampRepository;
import com.KookBee.classservice.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CurriculumService {
    private final CurriculumRepository curriculumRepository;
    private final BootcampRepository bootcampRepository;
    private final UserServiceClient userServiceClient;
    private final StudentBootcampRepository studentBootcampRepository;
    private final JwtService jwtService;

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
        return curriculum.stream().map(el -> {
            User teacher = userServiceClient.getTeacherByTeacherId(el.getTeacherId());
            if(el.getCurriculumStatus().equals(EStatus.PROCEEDING))
                return new ManagerCurriculumListResponse(el, teacher.getUserEmail());
            return null;
        }).toList().stream().filter(Objects::nonNull).collect(Collectors.toList());
    }

    public List<Curriculum> deleteCurriculum(List<Long> curriculumIds) {
        try{
            List<Curriculum> delCurriculumList = curriculumIds.stream().map(el -> {
                Optional<Curriculum> findById = curriculumRepository.findById(el);
                Curriculum curriculum = findById.orElseThrow(NullPointerException::new);
                curriculum.delCurriculum(EStatus.DELETED);
                return curriculumRepository.save(curriculum);
            }).collect(Collectors.toList());
            return delCurriculumList;
        }catch (Exception e){
            return null;
        }
    }

    public List<TeacherCurriculumListResponse> getTeacherCurriculumByBootcampId(Long bootcampId) {
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        List<Curriculum> curriculumList = curriculumRepository.findAllByTeacherIdAndBootcampId(userId, bootcampId);
        List<TeacherCurriculumListResponse> responses = curriculumList.stream().map(TeacherCurriculumListResponse::new).collect(Collectors.toList());
        return responses;
    }

    public List<Curriculum> getCurriculum (Long userId) {
//        List<StudentBootcamp> studentBootcamps = studentBootcampRepository.findListByStudentId(userId);
//        List<Curriculum> curriculumList = new ArrayList<>();
//        studentBootcamps.stream().map(e ->
//                curriculumList.addAll(e.getBootcamp().getCurriculumList())
//                );
//        curriculumRepository.get(userId);
        return curriculumRepository.get(userId);
    }
    public Curriculum getCurriculumByCurriculumId(Long curriculumId) {
        return curriculumRepository.findById(curriculumId).orElse(null);

    }
}
