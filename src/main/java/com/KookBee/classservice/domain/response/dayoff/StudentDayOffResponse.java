package com.KookBee.classservice.domain.response.dayoff;

import com.KookBee.classservice.domain.entity.Bootcamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class StudentDayOffResponse {
    private Long bootcampId;
    private String bootcampName;
    private LocalDate bootcampStartDate;
    private LocalDate bootcampEndDate;
    private Integer remainingDayOff;
    private List<StudentDayOffListResponse> studentDayOffList;

    public StudentDayOffResponse(Bootcamp bootcamp, Integer sumOfDays, List<StudentDayOffListResponse> dayOffList) {
        this.bootcampId = bootcamp.getId();
        if(bootcamp.getBootcampTitle().length() <= 10)
            this.bootcampName = bootcamp.getBootcampTitle();
        else
            this.bootcampName = bootcamp.getBootcampTitle().substring(0, 9) + "...";
        this.bootcampStartDate = LocalDate.parse(bootcamp.getBootcampStartDate(),
                DateTimeFormatter.ISO_DATE);
        this.bootcampEndDate = LocalDate.parse(bootcamp.getBootcampEndDate(),
                DateTimeFormatter.ISO_DATE);
        this.remainingDayOff = sumOfDays; //Math.toIntExact(ChronoUnit.DAYS.between(bootcampStartDate,LocalDate.now()))/30-sumOfDays;
        this.studentDayOffList = dayOffList;
    }
}
