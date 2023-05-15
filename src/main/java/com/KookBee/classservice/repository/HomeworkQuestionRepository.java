package com.KookBee.classservice.repository;

import com.KookBee.classservice.domain.entity.Bootcamp;
import com.KookBee.classservice.domain.entity.Curriculum;
import com.KookBee.classservice.domain.entity.HomeworkQuestion;
import com.KookBee.classservice.domain.response.StudentHomeworkListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface HomeworkQuestionRepository extends JpaRepository<HomeworkQuestion, Long> {
    List<HomeworkQuestion> findByCurriculum(Curriculum curriculum);


//            "hq.homeworkQuestionTitle, hq.homeworkQuestionStartDate, hq.homeworkQuestionEndDate, hq.homeworkStatus," +
//            " c.curriculumName, c.skillSet, " +
//            "b.bootcampTitle " +
    @Query("SELECT hq, c, b " +
            "FROM HomeworkQuestion hq " +
            "JOIN hq.curriculum c " +
            "JOIN c.bootcamp b " +
            "WHERE b.id = :bootcampId")
    List<HomeworkQuestion> findByBootcampId(@Param("bootcampId") Long bootcampId);

    @Query("SELECT hq, c, b " +
            "FROM HomeworkQuestion hq " +
            "JOIN hq.curriculum c " +
            "JOIN c.bootcamp b " +
            "WHERE b.id = :bootcampId " +
            "ORDER BY hq.homeworkQuestionEndDate DESC")
    List<HomeworkQuestion> findByBootcampIdOrderByEndDate(@Param("bootcampId") Long bootcampId);
}
