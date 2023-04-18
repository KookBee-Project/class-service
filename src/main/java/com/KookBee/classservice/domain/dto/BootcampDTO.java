package com.KookBee.classservice.domain.dto;

import com.KookBee.classservice.domain.entity.Bootcamp;
import com.KookBee.classservice.domain.enums.EStatus;
import com.KookBee.classservice.domain.request.BootcampInsertrequest;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BootcampDTO {
    private Long companyId;
    private Long campusId;
    private String classTitle;
    private String classDescription;
    private String classStartDate;
    private String classEndDate;
    private String classEnterDate;
    private EStatus classStatus;

    public BootcampDTO(BootcampInsertrequest request) {
        this.companyId = request.getCompanyId();
        this.campusId = request.getCampusId();
        this.classTitle = request.getClassTitle();
        this.classDescription = request.getClassDescription();
        this.classStartDate = request.getClassStartDate();
        this.classEndDate = request.getClassEnterCode();
        this.classEnterDate = request.getClassEnterCode();
        this.classStatus = request.getClassStatus();
    }
    public BootcampDTO(Bootcamp bootcamp) {
        this.companyId = bootcamp.getCompanyId();
        this.campusId = bootcamp.getCampusId();
        this.classTitle = bootcamp.getClassTitle();
        this.classDescription = bootcamp.getClassDescription();
        this.classStartDate = bootcamp.getClassStartDate();
        this.classEndDate = bootcamp.getClassEnterDate();
        this.classEnterDate = bootcamp.getClassEnterDate();
        this.classStatus = bootcamp.getClassStatus();
    }
}
