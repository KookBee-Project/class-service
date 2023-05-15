package com.KookBee.classservice.repository;

import com.KookBee.classservice.domain.entity.Curriculum;
import com.KookBee.classservice.domain.entity.HomeworkAnswer;
import com.KookBee.classservice.domain.entity.HomeworkQuestion;
import com.KookBee.classservice.domain.enums.EHomeworkStatus;
import com.KookBee.classservice.domain.response.StudentHomeworkListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;

public interface HomeworkAnswerRepository extends JpaRepository<HomeworkAnswer, Long> {
    Integer countByHomeworkQuestion(HomeworkQuestion homeworkQuestion);
    Optional<HomeworkAnswer> findByHomeworkQuestionAndUserId(HomeworkQuestion el, Long userId);

}
