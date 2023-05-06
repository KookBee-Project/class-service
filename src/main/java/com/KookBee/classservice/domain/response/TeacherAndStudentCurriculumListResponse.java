package com.KookBee.classservice.domain.response;

import com.KookBee.classservice.domain.entity.Curriculum;
import com.KookBee.classservice.domain.entity.SkillSet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TeacherAndStudentCurriculumListResponse {
    private Long curriculumId;
    private String curriculumName;
    private String curriculumStartDate;
    private String curriculumEndDate;
    private SkillSet skillSet;
    private String bootcampTitle;


    public TeacherAndStudentCurriculumListResponse(Curriculum curriculum) {
        this.curriculumId = curriculum.getId();
        this.curriculumName = curriculum.getCurriculumName();
        this.curriculumStartDate = curriculum.getCurriculumStartDate();
        this.curriculumEndDate = curriculum.getCurriculumEndDate();
        this.skillSet = curriculum.getSkillSet();
        if(curriculum.getBootcamp().getBootcampTitle().length() <= 10)
            this.bootcampTitle = curriculum.getBootcamp().getBootcampTitle();
        else
            this.bootcampTitle = curriculum.getBootcamp().getBootcampTitle().substring(0, 9) + "...";
    }

}
