package com.KookBee.classservice.service;

import com.KookBee.classservice.domain.entity.Curriculum;
import com.KookBee.classservice.domain.entity.HomeworkQuestion;
import com.KookBee.classservice.domain.entity.SkillSet;
import com.KookBee.classservice.domain.request.HomeworkQuestionRequest;
import com.KookBee.classservice.domain.response.TeacherHomeworkDetailResponse;
import com.KookBee.classservice.repository.*;
import com.KookBee.classservice.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HomeworkService {

    private final HomeworkQuestionRepository homeworkQuestionRepository;
    private final BootcampRepository bootcampRepository;
    private final CurriculumRepository curriculumRepository;
    private final SkillSetRepository skillSetRepository;
    private final StudentBootcampRepository studentBootcampRepository;
    private final JwtService jwtService;

    public HomeworkQuestion createHomework(HomeworkQuestionRequest request) {
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
//        User user = userServiceClient.getUserById(userId);
//        if(jwtService.isValidTokens() && user.getUserType() == "TEACHER"){
//            try {
                Curriculum curriculum = new Curriculum(request.getCurriculumId());
                SkillSet skillSet = new SkillSet(request.getSkillSetId());
                HomeworkQuestion homeworkQuestion = new HomeworkQuestion(request, userId, curriculum, skillSet);
                return homeworkQuestionRepository.save(homeworkQuestion);
//            }catch (Exception e){
//                return null;
//            }
//        }
//        return null;
    }

    public List<HomeworkQuestion> getHomeworkList(Long curriculumId) {
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
//        User user = userServiceClient.getUserById(userId);
//        if(jwtService.isValidTokens() && user.getUserType() == "TEACHER"){
//        try{
            Curriculum curriculum = new Curriculum(curriculumId);
            List<HomeworkQuestion> findByBootcampId = homeworkQuestionRepository.findByCurriculum(curriculum);
            return findByBootcampId;
//            } catch (Exception e) {
//                return null;
//            }
////        }
////        return null;
    }

    public TeacherHomeworkDetailResponse getHomeworkDetail(Long homeworkId) {
        Optional<HomeworkQuestion> findById = homeworkQuestionRepository.findById(homeworkId);
        HomeworkQuestion homeworkQuestions = findById.orElseThrow(NullPointerException::new);
        Integer totalStudent = studentBootcampRepository.countBybootcamp(homeworkQuestions.getCurriculum().getBootcamp());
        return new TeacherHomeworkDetailResponse(homeworkQuestions, totalStudent);
    }
}
