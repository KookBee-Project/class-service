package com.KookBee.classservice.domain.entity;

import com.KookBee.classservice.domain.dto.ClassDTO;
import com.KookBee.classservice.domain.enums.EStatus;
import com.KookBee.classservice.domain.request.ClassEditRequest;
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
    @Enumerated(EnumType.STRING)
    private EStatus classStatus;
    @OneToMany(mappedBy = "classes", fetch = FetchType.LAZY)
    private List<StudentClass> studentClassList;

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

    public Classes(Classes orDefault) {
        this.companyId = orDefault.getCompanyId();
        this.campusId = orDefault.getCampusId();
        this.classTitle = orDefault.getClassTitle();
        this.classDescription = orDefault.getClassDescription();
        this.classStartDate = orDefault.getClassStartDate();
        this.classEndDate = orDefault.getClassEnterDate();
        this.classEnterDate = orDefault.getClassEnterDate();
        this.classStatus = orDefault.getClassStatus();
    }

    public Classes updateStatus(EStatus classStatus) {
        this.classStatus = classStatus;
        return this;
    }
    public Classes updateClasses(ClassEditRequest request) {
        this.id = request.getClassId();
        this.companyId = request.getCompanyId();
        this.campusId = request.getCampusId();
        this.classTitle = request.getClassTitle();
        this.classDescription = request.getClassDescription();
        this.classStartDate = request.getClassStartDate();
        this.classEndDate = request.getClassEnterDate();
        this.classEnterDate = request.getClassEnterDate();
        this.classStatus = request.getClassStatus();
        return this;
    }
}
