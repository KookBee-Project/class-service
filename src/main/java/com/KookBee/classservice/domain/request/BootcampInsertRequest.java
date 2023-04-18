package com.KookBee.classservice.domain.request;

import com.KookBee.classservice.domain.enums.EStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BootcampInsertRequest {
    private Long companyId;
    private Long campusId;
    private String bootcampTitle;
    private String bootcampDescription;
    private String bootcampStartDate;
    private String bootcampEndDate;
    private String bootcampEnterCode;
    private EStatus bootcampStatus;

}
