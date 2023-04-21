package com.KookBee.classservice.domain.response;

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
    private String curriculumName;
    private LocalDate dayOffStartDate;
    private LocalDate dayOffEndDate;
    private Integer useDays;
    private EDayOffStatus dayOffStatus;
}