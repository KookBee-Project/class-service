package com.KookBee.classservice.domain.dto;

import com.KookBee.classservice.client.Campus;
import com.KookBee.classservice.client.User;
import com.KookBee.classservice.domain.entity.Bootcamp;
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
public class DayOffDetailDTO {
    private String userType;
    private String campusName;
    private String bootcampName;
    private String studentName;
    private LocalDate dayOffStartDate;
    private LocalDate dayOffEndDate;
    private Integer useDays;
    private String dayOffReason;
    private EDayOffStatus dayOffManagerStatus;
    private EDayOffStatus dayOffTeacherStatus;
    private EDayOffStatus dayOffStatus;

    public DayOffDetailDTO(DayOff dayOff, User admin, User student, Campus campus, Bootcamp bootcamp) {
        this.userType = admin.getUserType();
        this.campusName = campus.getCampusName();
        this.bootcampName = bootcamp.getBootcampTitle();
        this.studentName = student.getUserName();
        this.dayOffStartDate = dayOff.getStartDate();
        this.dayOffEndDate = dayOff.getEndDate();
        this.useDays = dayOff.getDays();
        this.dayOffReason = dayOff.getReason();
        this.dayOffManagerStatus = dayOff.getManagerApproval();
        this.dayOffTeacherStatus = dayOff.getTeacherApproval();
        this.dayOffStatus = dayOff.getStatus();
    }
}
