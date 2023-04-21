package com.KookBee.classservice.repository;

import com.KookBee.classservice.domain.entity.Bootcamp;
import com.KookBee.classservice.domain.entity.Curriculum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CurriculumRepository extends JpaRepository<Curriculum,Long> {

    List<Curriculum> findAllByTeacherId(Long userId);

    // bootcampId가 이거이면서 날짜가 속해있는것
    @Query("SELECT c.id FROM Curriculum c WHERE c.bootcamp.id = :bootcampId " +
            "AND date(c.curriculumStartDate) <= date(:date) " +
            "AND date(c.curriculumEndDate) >= date(:date)")
    Optional<Long> findCIdByBootcampIdAndDate(@Param("bootcampId") Long bootcampId, @Param("date") LocalDate date);

    List<Curriculum> findByBootcamp(Bootcamp bootcamp);
}
