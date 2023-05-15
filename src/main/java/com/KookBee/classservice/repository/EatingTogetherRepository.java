package com.KookBee.classservice.repository;

import com.KookBee.classservice.domain.entity.EatingTogether;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EatingTogetherRepository extends JpaRepository<EatingTogether, Long> {
    List<EatingTogether> findByBootcampId(Long bootcampId);
}
