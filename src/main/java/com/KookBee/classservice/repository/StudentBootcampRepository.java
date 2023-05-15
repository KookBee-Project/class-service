package com.KookBee.classservice.repository;

import com.KookBee.classservice.domain.entity.Bootcamp;
import com.KookBee.classservice.domain.entity.HomeworkQuestion;
import com.KookBee.classservice.domain.entity.StudentBootcamp;
import com.KookBee.classservice.domain.enums.EStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface StudentBootcampRepository extends JpaRepository<StudentBootcamp, Long> {
    List<StudentBootcamp> findListByStudentId(Long userId);

    StudentBootcamp findByStudentId (Long studentId);

    Integer countByBootcamp(Bootcamp bootcamp);

    List<StudentBootcamp> findByBootcamp(Bootcamp bootcamp);

    Optional<StudentBootcamp> findByBootcampAndStudentId(Bootcamp bootcamp, Long userId);

    List<StudentBootcamp> findALlByStudentId(Long userId);

    @Query("select sb.bootcamp.bootcampEndDate from StudentBootcamp sb " +
            "where sb.bootcamp.bootcampStatus = :status and sb.studentId = :userId " +
            "order by sb.bootcamp.bootcampEndDate")
    List<String> findEndDateList(@Param("userId") Long userId,
                                 @Param("status") EStatus status);

}
