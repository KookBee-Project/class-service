package com.KookBee.classservice.domain.request;

import com.KookBee.classservice.domain.enums.EStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CurriculumInsertRequest {
    private String curriculumName;
    private Long bootcampId;
    private String teacherEmail;
    private String curriculumStartDate;
    private String curriculumEndDate;
    private Long skillSetId;
    private EStatus curriculumStatus;

    public CurriculumInsertRequest(CurriculumEditRequest curriculumEditRequest) {
        this.curriculumName = curriculumEditRequest.getCurriculumName();
        this.bootcampId = curriculumEditRequest.getBootcampId();
        this.teacherEmail = curriculumEditRequest.getTeacherEmail();
        this.curriculumStartDate = curriculumEditRequest.getCurriculumStartDate();
        this.curriculumEndDate = curriculumEditRequest.getCurriculumEndDate();
        this.skillSetId = curriculumEditRequest.getSkillSetId();
        this.curriculumStatus = curriculumEditRequest.getCurriculumStatus();
    }
}
