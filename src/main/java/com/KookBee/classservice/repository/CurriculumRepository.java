package com.KookBee.classservice.repository;

import com.KookBee.classservice.domain.entity.Curriculum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CurriculumRepository extends JpaRepository<Curriculum,Long> {

    List<Curriculum> findAllByTeacherId(Long userId);
}
