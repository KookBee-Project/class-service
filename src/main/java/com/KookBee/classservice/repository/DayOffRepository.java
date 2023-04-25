package com.KookBee.classservice.repository;

import com.KookBee.classservice.domain.entity.DayOff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DayOffRepository extends JpaRepository<DayOff,Long> {
    @Query("select sum(d.days) from DayOff d where d.userId = :userId " +
            "and d.curriculum.id = :curriculumId")
    Optional<Integer> findSumOfDaysByUserId(Long userId, Long curriculumId);

    List<DayOff> findByUserIdAndCurriculumId(Long userId, Long id);

    @Query("select d,c from DayOff d join d.curriculum c " +
            "where c.bootcamp.id = :bootcampId and d.userId = :userId")
    List<DayOff> findByUserIdAndBootcampId(Long userId, Long bootcampId);

    // 커리큘럼id랑 유저id를 기져오는데 그 컬리큘럼의 아이디가 주어진 bootcampID
    @Query("select d,c,b from DayOff d join d.curriculum c " +
            "join c.bootcamp b where b.managerId = :userId")
    List<DayOff> findByManagerID(Long userId);
}
