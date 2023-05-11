package com.KookBee.classservice.repository;

import com.KookBee.classservice.domain.entity.Bootcamp;
import com.KookBee.classservice.domain.entity.HomeworkQuestion;
import com.KookBee.classservice.domain.entity.StudentBootcamp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentBootcampRepository extends JpaRepository<StudentBootcamp, Long> {
    List<StudentBootcamp> findListByStudentId(Long userId);

    StudentBootcamp findByStudentId (Long studentId);

    Integer countByBootcamp(Bootcamp bootcamp);

    List<StudentBootcamp> findByBootcamp(Bootcamp bootcamp);

    Optional<StudentBootcamp> findByBootcampAndStudentId(Bootcamp bootcamp, Long userId);

    List<StudentBootcamp> findALlByStudentId(Long userId);
}
