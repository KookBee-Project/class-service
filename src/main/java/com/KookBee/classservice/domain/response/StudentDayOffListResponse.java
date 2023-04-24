package com.KookBee.classservice.domain.response;

import com.KookBee.classservice.domain.entity.DayOff;
import com.KookBee.classservice.domain.enums.EDayOffStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class StudentDayOffListResponse {
    private String bootcampName;
    private String curriculumName;
    private LocalDate dayOffStartDate;
    private LocalDate dayOffEndDate;
    private Integer useDays;
    private EDayOffStatus dayOffStatus;


    public StudentDayOffListResponse(DayOff dayOff, String bootcampName) {
        if(bootcampName.length() <= 10)
            this.bootcampName = bootcampName;
        else
            this.bootcampName = bootcampName.substring(0, 9) + "...";
        this.curriculumName = dayOff.getCurriculum().getCurriculumName();
        this.dayOffStartDate = dayOff.getStartDate();
        this.dayOffEndDate = dayOff.getEndDate();
        this.useDays = dayOff.getDays();
        this.dayOffStatus = dayOff.getStatus();
    }
}
