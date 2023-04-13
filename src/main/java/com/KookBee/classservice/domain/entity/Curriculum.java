package com.KookBee.classservice.domain.entity;

import com.KookBee.classservice.domain.enums.EStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Curriculum {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "curriculum_id")
    private Long id;
    private Long classId;
    private Long teacherId;
    private String curriculumSkillSet;
    private String curriculumStartDate;
    private String curriculumEndDate;
    private EStatus curriculumStatus;


}
