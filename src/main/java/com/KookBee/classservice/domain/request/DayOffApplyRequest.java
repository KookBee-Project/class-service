package com.KookBee.classservice.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class DayOffApplyRequest {
    private String dayOffStartDate;
    private String dayOffEndDate;
    private String dayOffReason;
    private Long bootcampId;
}
