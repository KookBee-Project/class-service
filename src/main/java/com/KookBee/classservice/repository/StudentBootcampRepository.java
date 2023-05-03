package com.KookBee.classservice.repository;

import com.KookBee.classservice.domain.entity.Bootcamp;
import com.KookBee.classservice.domain.entity.StudentBootcamp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentBootcampRepository extends JpaRepository<StudentBootcamp, Long> {
    List<StudentBootcamp> findListByStudentId(Long userId);

    StudentBootcamp findByStudentId (Long studentId);

    Integer countBybootcamp(Bootcamp bootcamp);
}
