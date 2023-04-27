package com.KookBee.classservice.service;

import com.KookBee.classservice.domain.entity.Curriculum;
import com.KookBee.classservice.domain.entity.HomeworkQuestion;
import com.KookBee.classservice.domain.entity.SkillSet;
import com.KookBee.classservice.domain.request.HomeworkQuestionRequest;
import com.KookBee.classservice.domain.response.TeacherHomeworkDetailResponse;
import com.KookBee.classservice.domain.response.TeacherHomeworkListResponse;
import com.KookBee.classservice.repository.*;
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
    private final HomeworkAnswerRepository homeworkAnswerRepository;
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

    public List<TeacherHomeworkListResponse> getHomeworkList(Long curriculumId) {
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
//        User user = userServiceClient.getUserById(userId);
//        if(jwtService.isValidTokens() && user.getUserType() == "TEACHER"){
//        try{
            Curriculum curriculum = new Curriculum(curriculumId);
            List<HomeworkQuestion> findByCurriculumId = homeworkQuestionRepository.findByCurriculum(curriculum);
            List<TeacherHomeworkListResponse> responses = findByCurriculumId.stream().map(el -> {
                Integer summitStudent = homeworkAnswerRepository.countByHomeworkQuestion(el);
                Integer totalStudent = studentBootcampRepository.countByBootcamp(el.getCurriculum().getBootcamp());
                return new TeacherHomeworkListResponse(el, summitStudent, totalStudent);
            }).collect(Collectors.toList());
            return responses;
//            } catch (Exception e) {
//                return null;
//            }
////        }
////        return null;
    }

    public TeacherHomeworkDetailResponse getHomeworkDetail(Long homeworkId) {
        Optional<HomeworkQuestion> findById = homeworkQuestionRepository.findById(homeworkId);
        HomeworkQuestion homeworkQuestions = findById.orElseThrow(NullPointerException::new);
        Integer totalStudent = studentBootcampRepository.countByBootcamp(homeworkQuestions.getCurriculum().getBootcamp());
        return new TeacherHomeworkDetailResponse(homeworkQuestions, totalStudent);
    }
}
