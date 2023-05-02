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
public class TeacherDayOffListDTO {
    private Long dayOffId;
    private String campusName;
    private String bootcampName;
    private String studentName;
    private LocalDate dayOffStartDate;
    private LocalDate dayOffEndDate;
    private EDayOffStatus dayOffTeacherStatus;

    public TeacherDayOffListDTO(User user, Campus campus, Bootcamp bootcamp, DayOff dayOff) {
        this.dayOffId = dayOff.getId();
        this.campusName = campus.getCampusName();
        this.bootcampName = bootcamp.getBootcampTitle();
        this.studentName = user.getUserName();
        this.dayOffStartDate = dayOff.getStartDate();
        this.dayOffEndDate = dayOff.getEndDate();
        this.dayOffTeacherStatus = dayOff.getTeacherApproval();
    }
}
