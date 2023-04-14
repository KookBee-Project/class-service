package com.KookBee.classservice.service;

import com.KookBee.classservice.domain.entity.Classes;
import com.KookBee.classservice.domain.entity.HomeworkQuestions;
import com.KookBee.classservice.domain.entity.SkillSet;
import com.KookBee.classservice.domain.request.HomeworkQuestionRequest;
import com.KookBee.classservice.repository.ClassRepository;
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
    private final ClassRepository classRepository;
    private final SkillSetRepository skillSetRepository;
    private final JwtService jwtService;

    public HomeworkQuestions createHomework(HomeworkQuestionRequest request) {
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
//        User user = userServiceClient.getUserById(userId);
//        if(jwtService.isValidTokens() && user.getUserType() == "TEACHER"){
            try {
                Optional<Classes> findClassesById = classRepository.findById(request.getClassesId());
                Classes classes = findClassesById.orElseThrow(NullPointerException::new);
                List<SkillSet> skillSetList = request.getSkillSetIdList().stream().map(el -> skillSetRepository.findById(el).get()).collect(Collectors.toList());
                HomeworkQuestions homeworkQuestionssssssssssssssss = new HomeworkQuestions(request, userId, classes, skillSetList);
                return homeworkQuestionRepository.save(homeworkQuestionssssssssssssssss);
            }catch (Exception e){
                return null;
            }
//        }
//        return null;
    }
}
