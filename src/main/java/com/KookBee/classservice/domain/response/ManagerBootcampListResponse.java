package com.KookBee.classservice.domain.response;

import com.KookBee.classservice.domain.entity.Bootcamp;
import com.KookBee.classservice.domain.entity.Curriculum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ManagerBootcampListResponse {
    private Long bootcampId;
    private String bootcampTitle;
    private String bootcampStartDate;
    private String bootcampEndDate;
    private String campusName;
    private String bootcampEnterCode;
    private List<Curriculum> curriculumList;

    public ManagerBootcampListResponse(Bootcamp bootcamp, String campusName) {
        this.bootcampId = bootcamp.getId();
        if(bootcamp.getBootcampTitle().length() <= 10)
            this.bootcampTitle = bootcamp.getBootcampTitle();
        else
            this.bootcampTitle = bootcamp.getBootcampTitle().substring(0, 9) + "...";
        this.bootcampStartDate = bootcamp.getBootcampStartDate();
        this.bootcampEndDate = bootcamp.getBootcampEndDate();
        this.campusName = campusName;
        this.bootcampEnterCode = bootcamp.getBootcampEnterCode();
        this.curriculumList = bootcamp.getCurriculumList();
    }
}
