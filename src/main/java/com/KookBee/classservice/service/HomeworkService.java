package com.KookBee.classservice.service;

import com.KookBee.classservice.domain.entity.Bootcamp;
import com.KookBee.classservice.domain.entity.Curriculum;
import com.KookBee.classservice.domain.entity.HomeworkQuestion;
import com.KookBee.classservice.domain.response.TeacherHomeworkListResponse;
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

//    public HomeworkQuestions createHomework(HomeworkQuestionRequest request) {
//        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
////        User user = userServiceClient.getUserById(userId);
////        if(jwtService.isValidTokens() && user.getUserType() == "TEACHER"){
////            try {
//                Bootcamp bootcamp = new Bootcamp(request.getBootcampId());
//                SkillSet skillSet = new SkillSet(request.getSkillSetId());
//                HomeworkQuestions homeworkQuestions = new HomeworkQuestions(request, userId, bootcamp, skillSet);
//                return homeworkQuestionRepository.save(homeworkQuestions);
////            }catch (Exception e){
////                return null;
////            }
////        }
////        return null;
//    }

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

    public TeacherHomeworkListResponse getHomeworkDetail(Long homeworkId) {
        Optional<HomeworkQuestion> findById = homeworkQuestionRepository.findById(homeworkId);
        HomeworkQuestion homeworkQuestions = findById.orElseThrow(NullPointerException::new);
        Integer totalStudent = studentBootcampRepository.countBybootcamp(homeworkQuestions.getCurriculum().getBootcamp());
        return new TeacherHomeworkListResponse(homeworkQuestions, totalStudent);
    }
}
