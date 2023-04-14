package com.KookBee.classservice.repository;

import com.KookBee.classservice.domain.entity.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VacationRepository extends JpaRepository<Vacation,Long> {
//    Optional<Vacation> findByCurriculumName(String curriculumId);
}
