package com.KookBee.classservice.domain.entity;

import com.KookBee.classservice.domain.enums.EStatus;
import com.KookBee.classservice.domain.request.CurriculumEditRequest;
import com.KookBee.classservice.domain.request.CurriculumInsertRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Curriculum {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "curriculum_id")
    private Long id;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bootcamp_id")
    private Bootcamp bootcamp;
    private Long teacherId; // teacher table nono user table id OO
    private String curriculumName;
    private String curriculumStartDate;
    private String curriculumEndDate;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skill_set_id")
    private SkillSet skillSet;
    @Enumerated(EnumType.STRING)
    private EStatus curriculumStatus;
    @OneToMany(mappedBy = "curriculum", fetch = FetchType.LAZY)
    private List<DayOff> dayOffList;
    @OneToMany(mappedBy = "curriculum", fetch = FetchType.LAZY)
    private List<HomeworkQuestion> homeworkQuestions;

    public Curriculum(CurriculumInsertRequest request, Bootcamp bootcamp, Long id, SkillSet skillSet) {
        this.curriculumName = request.getCurriculumName();
        this.bootcamp = bootcamp;
        this.teacherId = id;
        this.curriculumStartDate = request.getCurriculumStartDate();
        this.curriculumEndDate = request.getCurriculumEndDate();
        this.skillSet = skillSet;
        this.curriculumStatus = request.getCurriculumStatus();
    }

    public Curriculum updateCurriculum(CurriculumEditRequest request, SkillSet skillSet, Long teacherId){
        this.curriculumName = request.getCurriculumName();
        this.teacherId = teacherId;
        this.curriculumStartDate = request.getCurriculumStartDate();
        this.curriculumEndDate = request.getCurriculumEndDate();
        this.skillSet = skillSet;
        this.curriculumStatus = request.getCurriculumStatus();
        return this;
    }

    public Curriculum(Long curriculumId) {
        this.id = curriculumId;
    }

    public Curriculum delCurriculum(EStatus curriculumStatus){
        this.curriculumStatus = curriculumStatus;
        return this;
    }
}
