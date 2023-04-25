package com.KookBee.classservice.service;

import com.KookBee.classservice.domain.entity.Bootcamp;
import com.KookBee.classservice.domain.entity.HomeworkQuestions;
import com.KookBee.classservice.domain.entity.SkillSet;
import com.KookBee.classservice.domain.request.HomeworkQuestionRequest;
import com.KookBee.classservice.domain.response.TeacherHomeworkListResponse;
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

    public List<HomeworkQuestions> getHomeworkList(Long bootcampId) {
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
//        User user = userServiceClient.getUserById(userId);
//        if(jwtService.isValidTokens() && user.getUserType() == "TEACHER"){
        try{
            Optional<Bootcamp> findById = bootcampRepository.findById(bootcampId);
            Bootcamp bootcamp = findById.orElseThrow(NullPointerException::new);
            Optional<List<HomeworkQuestions>> findByBootcampId = homeworkQuestionRepository.findByBootcamp(bootcamp);
            List<HomeworkQuestions> response = findByBootcampId.orElseThrow(NullPointerException::new);
            return response;
            } catch (Exception e) {
                return null;
            }
//        }
//        return null;
    }

//    public TeacherHomeworkListResponse getHomeworkDetail(Long homeworkId) {
//        Optional<HomeworkQuestions> findById = homeworkQuestionRepository.findById(homeworkId);
//        HomeworkQuestions homeworkQuestions = findById.orElseThrow(NullPointerException::new);
//        Integer totalStudent = homeworkQuestionRepository.countByBootcamp(homeworkQuestions.getBootcamp());
//        return new TeacherHomeworkListResponse(homeworkQuestions, totalStudent);
//    }
}
