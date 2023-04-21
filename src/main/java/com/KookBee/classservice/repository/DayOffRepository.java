package com.KookBee.classservice.repository;

import com.KookBee.classservice.domain.entity.DayOff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Optional;

public interface DayOffRepository extends JpaRepository<DayOff,Long> {
    @Query("select sum(d.days) from DayOff d where d.userId = :userId " +
            "and d.curriculum.id = :curriculumId")
    Optional<Integer> findSumOfDaysByUserId(Long userId, Long curriculumId);

}
