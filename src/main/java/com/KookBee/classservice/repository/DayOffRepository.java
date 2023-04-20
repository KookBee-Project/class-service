package com.KookBee.classservice.repository;

import com.KookBee.classservice.domain.entity.DayOff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DayOffRepository extends JpaRepository<DayOff,Long> {
//    Optional<Vacation> findByCurriculumName(String curriculumId);
}
