package com.KookBee.classservice.repository;

import com.KookBee.classservice.domain.entity.Bootcamp;
import com.KookBee.classservice.domain.entity.StudentBootcamp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentBootcampRepository extends JpaRepository<StudentBootcamp, Long> {
    List<StudentBootcamp> findByStudentId(Long userId);

    Integer countBybootcamp(Bootcamp bootcamp);
}
