package com.KookBee.classservice.domain.request;

import com.KookBee.classservice.domain.entity.Curriculum;
import com.KookBee.classservice.domain.enums.EStatus;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ClassInsertRequest {
    private Long companyId;
    private Long campusId;
    private String classTitle;
    private String classDescription;
    private String classStartDate;
    private String classEndDate;
    private String classEnterDate;
    private EStatus classStatus;

}
