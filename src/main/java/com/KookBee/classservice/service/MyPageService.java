package com.KookBee.classservice.service;

import com.KookBee.classservice.domain.entity.*;
import com.KookBee.classservice.domain.enums.EPostType;
import com.KookBee.classservice.domain.enums.EStatus;
import com.KookBee.classservice.domain.response.MyPageHomeworkListResponse;
import com.KookBee.classservice.domain.response.MyPageQnAListResponse;
import com.KookBee.classservice.repository.*;
import com.KookBee.classservice.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
@RequiredArgsConstructor
public class MyPageService {
    private final JwtService jwtService;
    private final StudentBootcampRepository studentBootcampRepository;
    private final HomeworkQuestionRepository homeworkQuestionRepository;
    private final HomeworkAnswerRepository homeworkAnswerRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final CurriculumRepository curriculumRepository;

    public Long getRemainDay(){
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();

        // 부트캠프의 남은 일수 구하기
        EStatus status = EStatus.PROCEEDING;
        LocalDate endDate = LocalDate.parse(studentBootcampRepository.findEndDateList(userId, status).get(0));
        LocalDate today = LocalDate.now();
        Long remainDay = ChronoUnit.DAYS.between(today, endDate);
        return remainDay;
    }

    public List<String> getSkillsetNameList(){
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        String today = String.valueOf(LocalDate.now());
        List<StudentBootcamp> bootcampList = studentBootcampRepository.findALlByStudentId(userId);
        List<String> skillsetNameList = new ArrayList<>();
        for (int i = 0; i < bootcampList.size(); i++) {
            List<SkillSet> skillsetList = curriculumRepository
                    .getSkillsetList(today, bootcampList.get(i).getBootcamp().getId());
            List<String> list = skillsetList.stream().map(el->{
                return el.getSkillSetName();
            }).toList();
            skillsetNameList.addAll(list);
        }
        return skillsetNameList.stream().distinct().toList();
    }

    public List<MyPageHomeworkListResponse> getHomeworkList(){
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        // 내가 속해있는 부트캠프의 과제 목록
        List<MyPageHomeworkListResponse> responses = new ArrayList<>();

        // 1. 내가 속한 부트캠프
        List<StudentBootcamp> bootcampList = studentBootcampRepository.findALlByStudentId(userId);
        // 2. 그 부트캠프 아이디를 가지고 있는 과제목록
        for (int i = 0; i < bootcampList.size(); i++) {
            List<HomeworkQuestion> questions =
                    homeworkQuestionRepository.findByBootcampIdOrderByEndDate(bootcampList.get(i)
                            .getBootcamp().getId());
            for (int j = 0; j < questions.size(); j++) {
                Optional<HomeworkAnswer> answer =
                        homeworkAnswerRepository.findByHomeworkQuestionAndUserId(questions.get(j), userId);
                String isAnswer = (questions.get(j).getHomeworkStatus() == EStatus.CLOSED) ? "제출마감"
                        : ((answer.isPresent()) ? "제출완료" : "대기중");
                responses.add(new MyPageHomeworkListResponse(questions.get(j), isAnswer));
            }
        }

        // 5개까지만 반환
        if (responses.size()>5){
            return responses.subList(0,5);
        } else {
            return responses;
        }
    }

    public List<MyPageQnAListResponse> getQnAList(){
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        EPostType type = EPostType.QNA;

        List<MyPageQnAListResponse> responses = postRepository.findMyQnA(type, userId).stream().map(el->{
            Integer answerCount = commentRepository.answerCount(el.getId());
            String isAnswer = (answerCount == 0) ? "대기중" : "답변완료";
            return new MyPageQnAListResponse(el, isAnswer);
        }).toList();

        // 5개까지만 반환
        if (responses.size()>5){
            return responses.subList(0,5);
        } else {
            return responses;
        }
    }
}
// 나의 완료한 스킬셋 리스트