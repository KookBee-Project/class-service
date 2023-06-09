package com.KookBee.classservice.domain.response.dayoff;

import com.KookBee.classservice.domain.dto.ManagerDayOffListDTO;
import com.KookBee.classservice.domain.dto.TeacherDayOffListDTO;
import com.KookBee.classservice.domain.enums.EDayOffStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class DayOffListForTeacherResponse {
    private Long dayOffId;
    private String campusName;
    private String bootcampName;
    private String studentName;
    private LocalDate dayOffStartDate;
    private LocalDate dayOffEndDate;
    private EDayOffStatus dayOffTeacherStatus;

    public DayOffListForTeacherResponse(TeacherDayOffListDTO dto) {
        this.dayOffId = dto.getDayOffId();
        this.campusName = dto.getCampusName();
        if(dto.getBootcampName().length() <= 10)
            this.bootcampName = dto.getBootcampName();
        else
            this.bootcampName = dto.getBootcampName().substring(0, 9) + "...";
        this.studentName = dto.getStudentName();
        this.dayOffStartDate = dto.getDayOffStartDate();
        this.dayOffEndDate = dto.getDayOffEndDate();
        this.dayOffTeacherStatus = dto.getDayOffTeacherStatus();
    }
}
