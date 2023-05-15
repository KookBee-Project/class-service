package com.KookBee.classservice.repository;

import com.KookBee.classservice.domain.entity.Bootcamp;
import com.KookBee.classservice.domain.entity.Curriculum;
import com.KookBee.classservice.domain.entity.SkillSet;
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

    List<Curriculum> findAllByTeacherIdAndBootcampId(Long userId, Long bootcampId);
    @Query("select c from Curriculum c " +
            "join fetch c.bootcamp b " +
            "join fetch b.studentBootcampList sb " +
            "where sb.studentId = :userId")
    List<Curriculum> get(@Param("userId") Long userId);

    @Query("select s from Curriculum c " +
            "join c.bootcamp b " +
            "join c.skillSet s " +
            "where b.id = :bootcampId and c.curriculumEndDate < :today ")
    List<SkillSet> getSkillsetList(@Param("today") String today,
                                   @Param("bootcampId") Long bootcampId);
}
