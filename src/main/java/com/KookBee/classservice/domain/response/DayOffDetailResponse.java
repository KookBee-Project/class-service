package com.KookBee.classservice.domain.response;

import com.KookBee.classservice.domain.dto.DayOffDetailDTO;
import com.KookBee.classservice.domain.enums.EDayOffStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class DayOffDetailResponse {
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

    public DayOffDetailResponse(DayOffDetailDTO dto) {
        this.userType = dto.getUserType();
        this.campusName = dto.getCampusName();
        this.bootcampName = dto.getBootcampName();
        this.studentName = dto.getStudentName();
        this.dayOffStartDate = dto.getDayOffStartDate();
        this.dayOffEndDate = dto.getDayOffEndDate();
        this.useDays = dto.getUseDays();
        this.dayOffReason = dto.getDayOffReason();
        this.dayOffManagerStatus = dto.getDayOffManagerStatus();
        this.dayOffTeacherStatus = dto.getDayOffTeacherStatus();
        this.dayOffStatus = dto.getDayOffStatus();
    }
}
