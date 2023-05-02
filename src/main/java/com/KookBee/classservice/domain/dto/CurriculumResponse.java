package com.KookBee.classservice.domain.dto;

import com.KookBee.classservice.domain.entity.Bootcamp;
import com.KookBee.classservice.domain.entity.Curriculum;
import com.KookBee.classservice.domain.entity.DayOff;
import com.KookBee.classservice.domain.entity.SkillSet;
import com.KookBee.classservice.domain.enums.EStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class CurriculumResponse {
    private Long id;
    private Long teacherId; // teacher table nono user table id OO
    private String curriculumName;
    private String curriculumStartDate;
    private String curriculumEndDate;
    private EStatus curriculumStatus;

    public CurriculumResponse(Curriculum curriculum){
        this.id = curriculum.getId();
        this.teacherId = curriculum.getTeacherId();
        this.curriculumName = curriculum.getCurriculumName();
        this.curriculumStartDate = curriculum.getCurriculumStartDate();
        this.curriculumEndDate = curriculum.getCurriculumEndDate();
        this.curriculumStatus = curriculum.getCurriculumStatus();
    }
}
