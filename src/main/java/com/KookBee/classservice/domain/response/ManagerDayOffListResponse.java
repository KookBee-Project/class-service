package com.KookBee.classservice.domain.response;

import com.KookBee.classservice.domain.dto.ManagerDayOffListDTO;
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
public class ManagerDayOffListResponse {
    private String campusName;
    private String bootcampName;
    private String studentName;
    private LocalDate dayOffStartDay;
    private LocalDate dayOffEndDay;
    private EDayOffStatus dayOffStatus;

    public ManagerDayOffListResponse(ManagerDayOffListDTO dto) {
        this.campusName = dto.getCampusName();
        if(dto.getBootcampName().length() <= 10)
            this.bootcampName = dto.getBootcampName();
        else
            this.bootcampName = dto.getBootcampName().substring(0, 9) + "...";
        this.studentName = dto.getStudentName();
        this.dayOffStartDay = dto.getDayOffStartDay();
        this.dayOffEndDay = dto.getDayOffEndDay();
        this.dayOffStatus = dto.getDayOffStatus();
    }
}
