package com.KookBee.classservice.domain.response;

import com.KookBee.classservice.domain.entity.Curriculum;
import com.KookBee.classservice.domain.enums.EStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ManagerCurriculumListResponse {
    private Long id;
    private Long bootcampId;
    private String curriculumName;
    private String curriculumStartDate;
    private String curriculumEndDate;
    private String teacherEmail;
    private Long skillSetId;
    private EStatus curriculumStatus;

    public ManagerCurriculumListResponse(Curriculum curriculum, String teacherEmail) {
        this.id = curriculum.getId();
        this.bootcampId = curriculum.getBootcamp().getId();
        this.curriculumName = curriculum.getCurriculumName();
        this.curriculumStartDate = curriculum.getCurriculumStartDate();
        this.curriculumEndDate = curriculum.getCurriculumEndDate();
        this.teacherEmail = teacherEmail;
        this.skillSetId = curriculum.getSkillSet().getId();
        this.curriculumStatus = curriculum.getCurriculumStatus();
    }
}
