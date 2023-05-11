package com.KookBee.classservice.domain.response;

import com.KookBee.classservice.domain.entity.Curriculum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CurriculumCalendarResponse {
    private Long id;
    private String title;
    private String start;
    private String end;
    private String bootcampTitle;
    private String skillSetName;
    private String teacherName;
    private String color = "#76818D";

    public CurriculumCalendarResponse(Curriculum curriculum, String teacherName) {
        this.id = curriculum.getId();
        if(curriculum.getCurriculumName().length() <= 10) this.title = curriculum.getCurriculumName();
        else this.title = curriculum.getCurriculumName().substring(0,9);
        this.start = curriculum.getCurriculumStartDate();
        this.end = curriculum.getCurriculumEndDate();
        if(curriculum.getBootcamp().getBootcampTitle().length() <= 10) this.bootcampTitle = curriculum.getBootcamp().getBootcampTitle();
        else this.bootcampTitle = curriculum.getBootcamp().getBootcampTitle().substring(0,9);
        this.skillSetName = curriculum.getSkillSet().getSkillSetName();
        this.teacherName = teacherName;
    }
}
