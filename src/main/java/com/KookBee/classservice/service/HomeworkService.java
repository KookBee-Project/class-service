package com.KookBee.classservice.service;

import com.KookBee.classservice.domain.entity.Bootcamp;
import com.KookBee.classservice.domain.entity.HomeworkQuestions;
import com.KookBee.classservice.domain.entity.SkillSet;
import com.KookBee.classservice.domain.request.HomeworkQuestionRequest;
import com.KookBee.classservice.repository.BootcampRepository;
import com.KookBee.classservice.repository.HomeworkQuestionRepository;
import com.KookBee.classservice.repository.SkillSetRepository;
import com.KookBee.classservice.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HomeworkService {

    private final HomeworkQuestionRepository homeworkQuestionRepository;
    private final BootcampRepository bootcampRepository;
    private final SkillSetRepository skillSetRepository;
    private final JwtService jwtService;

    public HomeworkQuestions createHomework(HomeworkQuestionRequest request) {
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
//        User user = userServiceClient.getUserById(userId);
//        if(jwtService.isValidTokens() && user.getUserType() == "TEACHER"){
            try {
                Optional<Bootcamp> findClassesById = bootcampRepository.findById(request.getClassesId());
                Bootcamp bootcamp = findClassesById.orElseThrow(NullPointerException::new);
                List<SkillSet> skillSetList = request.getSkillSetIdList().stream().map(el -> skillSetRepository.findById(el).get()).collect(Collectors.toList());
                HomeworkQuestions homeworkQuestions = new HomeworkQuestions(request, userId, bootcamp, skillSetList);
                return homeworkQuestionRepository.save(homeworkQuestions);
            }catch (Exception e){
                return null;
            }
//        }
//        return null;
    }

    public List<HomeworkQuestions> getHomeworkList(Long bootcampId) {
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
//        User user = userServiceClient.getUserById(userId);
//        if(jwtService.isValidTokens() && user.getUserType() == "TEACHER"){
        try{
            Optional<Classes> findById = classRepository.findById(bootcampId);
            Classes classes = findById.orElseThrow(NullPointerException::new);
            Optional<List<HomeworkQuestions>> findByBootcampId = homeworkQuestionRepository.findAllByClasses(classes);
            List<HomeworkQuestions> response = findByBootcampId.orElseThrow(NullPointerException::new);
            return response;
            } catch (Exception e) {
                return null;
            }
//        }
//        return null;
    }
}
