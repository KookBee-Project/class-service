package com.KookBee.classservice.repository;

import com.KookBee.classservice.domain.entity.Bootcamp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BootcampRepository extends JpaRepository <Bootcamp,Long> {
    List<Bootcamp> findByManagerId(Long userId);

//    @Transactional
//    @Modifying
//    @Query("UPDATE Classes c SET c.classStatus = :status WHERE c.id = :classId and c.campusId = :campusId")
//    String updateClassStatus(EStatus status, Long classId, Long campusId);
}
