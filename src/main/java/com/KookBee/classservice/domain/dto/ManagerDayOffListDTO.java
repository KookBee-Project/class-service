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
public class ManagerDayOffListDTO {
    private String campusName;
    private String bootcampName;
    private String studentName;
    private LocalDate dayOffStartDay;
    private LocalDate dayOffEndDay;
    private EDayOffStatus dayOffStatus;

    public ManagerDayOffListDTO(User user, Campus campus, Bootcamp bootcamp, DayOff dayOff) {
        this.campusName = campus.getCampusName();
        this.bootcampName = bootcamp.getBootcampTitle();
        this.studentName = user.getUserName();
        this.dayOffStartDay = dayOff.getStartDate();
        this.dayOffEndDay = dayOff.getEndDate();
        this.dayOffStatus = dayOff.getStatus();
    }
}
