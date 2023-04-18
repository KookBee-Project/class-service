package com.KookBee.classservice.domain.entity;

import com.KookBee.classservice.domain.dto.BootcampDTO;
import com.KookBee.classservice.domain.enums.EStatus;
import com.KookBee.classservice.domain.request.BootcampEditRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Bootcamp {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private Long id;
    private Long companyId;
    private Long campusId;
    private String classTitle;
    private String classDescription;
    @OneToMany (mappedBy = "bootcamp", fetch = FetchType.LAZY)
    private List<Curriculum> curriculumList;
    private String classStartDate;
    private String classEndDate;
    private String classEnterDate;
    @Enumerated(EnumType.STRING)
    private EStatus classStatus;
    @OneToMany(mappedBy = "bootcamp", fetch = FetchType.LAZY)
    private List<StudentClass> studentClassList;

    public Bootcamp(BootcampDTO dto) {
        this.companyId = dto.getCompanyId();
        this.campusId = dto.getCampusId();
        this.classTitle = dto.getClassTitle();
        this.classDescription = dto.getClassDescription();
        this.classStartDate = dto.getClassStartDate();
        this.classEndDate = dto.getClassEnterDate();
        this.classEnterDate = dto.getClassEnterDate();
        this.classStatus = dto.getClassStatus();
    }
    public Bootcamp updateStatus(EStatus classStatus) {
        this.classStatus = classStatus;
        return this;
    }
    public Bootcamp updateClasses(BootcampEditRequest request) {
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
