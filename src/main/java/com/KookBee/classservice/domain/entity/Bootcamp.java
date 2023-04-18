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
    private String bootcampTitle;
    private String bootcampDescription;
    @OneToMany (mappedBy = "bootcamp", fetch = FetchType.LAZY)
    private List<Curriculum> curriculumList;
    private String bootcampStartDate;
    private String bootcampEndDate;
    private String bootcampEnterDate;
    @Enumerated(EnumType.STRING)
    private EStatus bootcampStatus;
    @OneToMany(mappedBy = "bootcamp", fetch = FetchType.LAZY)
    private List<StudentBootcamp> studentBootcampList;

    public Bootcamp(BootcampDTO dto) {
        this.companyId = dto.getCompanyId();
        this.campusId = dto.getCampusId();
        this.bootcampTitle = dto.getBootcampTitle();
        this.bootcampDescription = dto.getBootcampDescription();
        this.bootcampStartDate = dto.getBootcampStartDate();
        this.bootcampEndDate = dto.getBootcampEnterDate();
        this.bootcampEnterDate = dto.getBootcampEnterDate();
        this.bootcampStatus = dto.getBootcampStatus();
    }

    public Bootcamp updateStatus(EStatus classStatus) {

        this.bootcampStatus = classStatus;
        return this;
    }
    public Bootcamp updateBootcamp(BootcampEditRequest request) {
        this.id = request.getBootcampId();
        this.companyId = request.getCompanyId();
        this.campusId = request.getCampusId();
        this.bootcampTitle = request.getBootcampTitle();
        this.bootcampDescription = request.getBootcampDescription();
        this.bootcampStartDate = request.getBootcampStartDate();
        this.bootcampEndDate = request.getBootcampEnterDate();
        this.bootcampEnterDate = request.getBootcampEnterDate();
        this.bootcampStatus = request.getBootcampStatus();
        return this;
    }
}
