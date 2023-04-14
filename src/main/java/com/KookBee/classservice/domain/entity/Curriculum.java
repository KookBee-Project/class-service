package com.KookBee.classservice.domain.entity;

import com.KookBee.classservice.domain.enums.EStatus;
import com.KookBee.classservice.domain.request.CurriculumInsertRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Curriculum {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "curriculum_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id")
    private Classes classes;
    private Long teacherId;
    private String curriculumStartDate;
    private String curriculumEndDate;
    private EStatus curriculumStatus;

    public Curriculum(CurriculumInsertRequest request, Classes classes) {
        this.classes = classes;
        this.teacherId = request.getTeacherId();
        this.curriculumStartDate = request.getCurriculumStartDate();
        this.curriculumEndDate = request.getCurriculumEndDate();
        this.curriculumStatus = request.getCurriculumStatus();
    }
}
