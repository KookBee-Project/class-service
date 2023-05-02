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
public class TeacherCurriculumListResponse {
    private Long curriculumId;
    private String curriculumName;
    private String curriculumStartDate;
    private String curriculumEndDate;
    private String bootcampTitle;

    public TeacherCurriculumListResponse(Curriculum curriculum) {
        this.curriculumId = curriculum.getId();
        this.curriculumName = curriculum.getCurriculumName();
        this.curriculumStartDate = curriculum.getCurriculumStartDate();
        this.curriculumEndDate = curriculum.getCurriculumEndDate();
        if(curriculum.getBootcamp().getBootcampTitle().length() <= 10)
            this.bootcampTitle = curriculum.getBootcamp().getBootcampTitle();
        else
            this.bootcampTitle = curriculum.getBootcamp().getBootcampTitle().substring(0, 9) + "...";

    }
}
