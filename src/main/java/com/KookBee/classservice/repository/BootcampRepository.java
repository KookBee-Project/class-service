package com.KookBee.classservice.repository;

import com.KookBee.classservice.domain.entity.Bootcamp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BootcampRepository extends JpaRepository <Bootcamp,Long> {

//    @Transactional
//    @Modifying
//    @Query("UPDATE Classes c SET c.classStatus = :status WHERE c.id = :classId and c.campusId = :campusId")
//    String updateClassStatus(EStatus status, Long classId, Long campusId);
}
