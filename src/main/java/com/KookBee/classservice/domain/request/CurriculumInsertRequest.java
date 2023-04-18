package com.KookBee.classservice.domain.request;

import com.KookBee.classservice.domain.enums.EStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CurriculumInsertRequest {
    private Long bootcampId;
    private String teacherEmail;
    private String curriculumStartDate;
    private String curriculumEndDate;
    private EStatus curriculumStatus;
}
