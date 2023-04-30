package com.KookBee.classservice.service;

import com.KookBee.classservice.client.UserServiceClient;
import com.KookBee.classservice.domain.entity.*;
import com.KookBee.classservice.domain.enums.EHomeworkStatus;
import com.KookBee.classservice.domain.request.HomeworkAnswerRequest;
import com.KookBee.classservice.domain.request.HomeworkQuestionRequest;
import com.KookBee.classservice.domain.response.StudentHomeworkDetailResponse;
import com.KookBee.classservice.domain.response.StudentHomeworkListResponse;
import com.KookBee.classservice.domain.response.TeacherHomeworkDetailResponse;
import com.KookBee.classservice.domain.response.TeacherHomeworkListResponse;
import com.KookBee.classservice.repository.*;
import com.KookBee.classservice.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
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
    private final UserServiceClient userServiceClient;
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
    public HomeworkAnswer createHomeworkAnswer(HomeworkAnswerRequest request) {
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        HomeworkQuestion homeworkQuestion = new HomeworkQuestion(request.getHomeworkQuestionId());
        HomeworkAnswer homeworkAnswer = new HomeworkAnswer(request, userId, homeworkQuestion);
        return homeworkAnswerRepository.save(homeworkAnswer);
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

    public List<StudentHomeworkListResponse> getStudentHomeworkList(Long bootcampId) {
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        List<HomeworkQuestion> homeworkQuestions = homeworkQuestionRepository.findByBootcampId(bootcampId);
        List<StudentHomeworkListResponse> responses = homeworkQuestions.stream().map(el -> {
            Optional<HomeworkAnswer> getAnswer = homeworkAnswerRepository.findByHomeworkQuestionAndUserId(el, userId);
            HomeworkAnswer answer = getAnswer.orElse(null);
            return new StudentHomeworkListResponse(el, el.getCurriculum().getBootcamp().getBootcampTitle(), el.getSkillSet(), answer);
        }).toList();
        return responses;
    }

    public StudentHomeworkDetailResponse getStudentHomeworkDetail(Long homeworkId) {
        Optional<HomeworkQuestion> findById = homeworkQuestionRepository.findById(homeworkId);
        HomeworkQuestion homeworkQuestions = findById.orElseThrow(NullPointerException::new);
        String teacherName = userServiceClient.getTeacherByTeacherId(homeworkQuestions.getUserId()).getUserName();
        return new StudentHomeworkDetailResponse(homeworkQuestions, teacherName);
    }

}
