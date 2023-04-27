package com.KookBee.classservice.repository;

import com.KookBee.classservice.domain.entity.Bootcamp;
import com.KookBee.classservice.domain.entity.Curriculum;
import com.KookBee.classservice.domain.entity.HomeworkQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface HomeworkQuestionRepository extends JpaRepository<HomeworkQuestion, Long> {
    List<HomeworkQuestion> findByCurriculum(Curriculum curriculum);
}
