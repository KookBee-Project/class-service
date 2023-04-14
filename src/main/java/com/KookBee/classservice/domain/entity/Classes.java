package com.KookBee.classservice.domain.entity;

import com.KookBee.classservice.domain.dto.ClassDTO;
import com.KookBee.classservice.domain.enums.EStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Classes {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private Long id;
    private Long companyId;
    private Long campusId;
    private String classTitle;
    private String classDescription;
    @OneToMany (fetch = FetchType.LAZY)
    private List<Curriculum> curriculumList;
    private String classStartDate;
    private String classEndDate;
    private String classEnterDate;
    private EStatus classStatus;

    public Classes(ClassDTO dto) {
        this.companyId = dto.getCompanyId();
        this.campusId = dto.getCampusId();
        this.classTitle = dto.getClassTitle();
        this.classDescription = dto.getClassDescription();
        this.classStartDate = dto.getClassStartDate();
        this.classEndDate = dto.getClassEnterDate();
        this.classEnterDate = dto.getClassEnterDate();
        this.classStatus = dto.getClassStatus();
    }
}
