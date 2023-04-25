package com.KookBee.classservice.repository;

import com.KookBee.classservice.domain.entity.Bootcamp;
import com.KookBee.classservice.domain.entity.HomeworkQuestions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HomeworkQuestionRepository extends JpaRepository<HomeworkQuestions, Long> {
    Optional<List<HomeworkQuestions>> findByBootcamp(Bootcamp bootcamp);

    Integer countByBootcamp(Bootcamp bootcamp);
}
