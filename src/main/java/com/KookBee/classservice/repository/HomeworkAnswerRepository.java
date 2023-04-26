package com.KookBee.classservice.repository;

import com.KookBee.classservice.domain.entity.Curriculum;
import com.KookBee.classservice.domain.entity.HomeworkAnswer;
import com.KookBee.classservice.domain.entity.HomeworkQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeworkAnswerRepository extends JpaRepository<HomeworkAnswer, Long> {
    Integer countByHomeworkQuestion(HomeworkQuestion homeworkQuestion);
}
