package com.KookBee.classservice.domain.entity;

import com.KookBee.classservice.domain.dto.BootcampDTO;
import com.KookBee.classservice.domain.enums.EStatus;
import com.KookBee.classservice.domain.request.BootcampEditRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Bootcamp {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bootcamp_id")
    private Long id;
    private Long companyId;
    private Long campusId;
    private Long managerId; // userId
    private String bootcampTitle;
    private String bootcampDescription;
    @JsonIgnore
    @OneToMany (mappedBy = "bootcamp", fetch = FetchType.LAZY)
    private List<Curriculum> curriculumList;
    private String bootcampStartDate;
    private String bootcampEndDate;
    private String bootcampEnterCode;
    @Enumerated(EnumType.STRING)
    private EStatus bootcampStatus;
    @JsonIgnore
    @OneToMany(mappedBy = "bootcamp", fetch = FetchType.LAZY)
    private List<StudentBootcamp> studentBootcampList;
    @JsonIgnore
    @OneToMany(mappedBy = "bootcamp", fetch =FetchType.LAZY)
    private List<Post> postList;

    public Bootcamp(BootcampDTO dto, Long userId) {
        this.companyId = dto.getCompanyId();
        this.campusId = dto.getCampusId();
        this.managerId = userId;
        this.bootcampTitle = dto.getBootcampTitle();
        this.bootcampDescription = dto.getBootcampDescription();
        this.bootcampStartDate = dto.getBootcampStartDate();
        this.bootcampEndDate = dto.getBootcampEndDate();
        this.bootcampEnterCode = dto.getBootcampEnterCode();
        this.bootcampStatus = dto.getBootcampStatus();
    }

    public Bootcamp(Bootcamp orDefault) {
        this.id = orDefault.getId();
        this.companyId = orDefault.getCompanyId();
        this.campusId = orDefault.getCampusId();
        this.bootcampTitle = orDefault.getBootcampTitle();
        this.bootcampDescription = orDefault.getBootcampDescription();
        this.bootcampStartDate = orDefault.getBootcampStartDate();
        this.bootcampEndDate = orDefault.getBootcampEndDate();
        this.bootcampEnterCode = orDefault.getBootcampEnterCode();
        this.bootcampStatus = orDefault.getBootcampStatus();
    }

    public Bootcamp(Long bootcampId) {
        this.id = bootcampId;
    }

    public Bootcamp updateStatus(EStatus bootcampStatus) {

        this.bootcampStatus = bootcampStatus;
        return this;
    }
    public Bootcamp updateBootcamp(BootcampEditRequest request, Long userId) {
        this.id = request.getId();
        this.companyId = request.getCompanyId();
        this.campusId = request.getCampusId();
        this.managerId = userId;
        this.bootcampTitle = request.getBootcampTitle();
        this.bootcampDescription = request.getBootcampDescription();
        this.bootcampStartDate = request.getBootcampStartDate();
        this.bootcampEndDate = request.getBootcampEndDate();
        this.bootcampEnterCode = request.getBootcampEnterCode();
        this.bootcampStatus = request.getBootcampStatus();
        return this;
    }
}
