package com.KookBee.classservice.domain.dto;

import com.KookBee.classservice.domain.entity.Bootcamp;
import com.KookBee.classservice.domain.enums.EStatus;
import com.KookBee.classservice.domain.request.BootcampInsertRequest;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BootcampDTO {
    private Long companyId;
    private Long campusId;
    private String bootcampTitle;
    private String bootcampDescription;
    private String bootcampStartDate;
    private String bootcampEndDate;
    private String bootcampEnterCode;
    private EStatus bootcampStatus;

    public BootcampDTO(BootcampInsertRequest request, String enterCode) {
        this.companyId = request.getCompanyId();
        this.campusId = request.getCampusId();
        this.bootcampTitle = request.getBootcampTitle();
        this.bootcampDescription = request.getBootcampDescription();
        this.bootcampStartDate = request.getBootcampStartDate();
        this.bootcampEndDate = request.getBootcampEndDate();
        this.bootcampEnterCode = enterCode;
        this.bootcampStatus = request.getBootcampStatus();
    }
    public BootcampDTO(Bootcamp bootcamp) {
        this.companyId = bootcamp.getCompanyId();
        this.campusId = bootcamp.getCampusId();
        this.bootcampTitle = bootcamp.getBootcampTitle();
        this.bootcampDescription = bootcamp.getBootcampDescription();
        this.bootcampStartDate = bootcamp.getBootcampStartDate();
        this.bootcampEndDate = bootcamp.getBootcampEndDate();
        this.bootcampEnterCode = bootcamp.getBootcampEnterCode();
        this.bootcampStatus = bootcamp.getBootcampStatus();
    }
}
