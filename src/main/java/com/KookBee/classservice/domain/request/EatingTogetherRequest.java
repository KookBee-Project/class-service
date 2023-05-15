package com.KookBee.classservice.domain.request;

import com.KookBee.classservice.domain.entity.RestaurantInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class EatingTogetherRequest {
    private Long bootcampId;
    private String postTitle;
    private String postContents;
    private Long userId;
    private Long restaurantInfoId;
    private LocalDate appointmentDate;
    private Integer personnel;
}
