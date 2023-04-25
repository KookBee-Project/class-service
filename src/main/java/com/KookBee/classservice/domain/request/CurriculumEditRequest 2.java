package com.KookBee.classservice.domain.request;

import com.KookBee.classservice.domain.enums.EStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CurriculumEditRequest {
    private Long id;
    private Long bootcampId;
    private Long teacherId;
    private String curriculumStartDate;
    private String curriculumEndDate;
    private EStatus curriculumStatus;
}
