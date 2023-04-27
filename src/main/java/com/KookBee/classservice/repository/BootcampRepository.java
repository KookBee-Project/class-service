package com.KookBee.classservice.repository;

import com.KookBee.classservice.domain.entity.Bootcamp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BootcampRepository extends JpaRepository <Bootcamp,Long> {
    List<Bootcamp> findByManagerId(Long userId);

    @Query("select distinct b from Bootcamp b join fetch b.curriculumList c where c.teacherId = :userId")
    List<Bootcamp> findAllByTeacherId(@Param("userId") Long userId);

    Optional<Bootcamp> findByBootcampEnterCode(String bootcampCode);

//    @Transactional
//    @Modifying
//    @Query("UPDATE Classes c SET c.classStatus = :status WHERE c.id = :classId and c.campusId = :campusId")
//    String updateClassStatus(EStatus status, Long classId, Long campusId);
}
