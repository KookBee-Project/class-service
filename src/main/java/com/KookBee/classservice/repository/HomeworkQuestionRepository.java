package com.KookBee.classservice.repository;

import com.KookBee.classservice.domain.entity.HomeworkQuestions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeworkQuestionRepository extends JpaRepository<HomeworkQuestions, Long> {
}
