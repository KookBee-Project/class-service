package com.KookBee.classservice.domain.dto;

import com.KookBee.classservice.domain.entity.Classes;
import com.KookBee.classservice.domain.enums.EStatus;
import com.KookBee.classservice.domain.request.ClassInsertRequest;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClassDTO {
    private Long companyId;
    private Long campusId;
    private String classTitle;
    private String classDescription;
    private String classStartDate;
    private String classEndDate;
    private String classEnterDate;
    private EStatus classStatus;

    public ClassDTO(ClassInsertRequest request) {
        this.companyId = request.getCompanyId();
        this.campusId = request.getCampusId();
        this.classTitle = request.getClassTitle();
        this.classDescription = request.getClassDescription();
        this.classStartDate = request.getClassStartDate();
        this.classEndDate = request.getClassEnterDate();
        this.classEnterDate = request.getClassEnterDate();
        this.classStatus = request.getClassStatus();
    }
    public ClassDTO(Classes classes) {
        this.companyId = classes.getCompanyId();
        this.campusId = classes.getCampusId();
        this.classTitle = classes.getClassTitle();
        this.classDescription = classes.getClassDescription();
        this.classStartDate = classes.getClassStartDate();
        this.classEndDate = classes.getClassEnterDate();
        this.classEnterDate = classes.getClassEnterDate();
        this.classStatus = classes.getClassStatus();
    }
}
