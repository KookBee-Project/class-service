package com.KookBee.classservice.domain.response;

import com.KookBee.classservice.client.User;
import com.KookBee.classservice.domain.entity.Bootcamp;
import com.KookBee.classservice.domain.entity.EatingTogether;
import com.KookBee.classservice.domain.entity.RestaurantInfo;
import com.KookBee.classservice.domain.request.EatingTogetherRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class EatingTogetherResponse {
    private Long id;
    private Long bootcampId;
    private String postTitle;
    private String postContents;
    private String userName;
    private Long restaurantInfoId;
    private String restaurantName;
    private Double restaurantPositionLa;
    private Double restaurantPositionMa;
    private LocalDate appointmentDate;
    private Integer personnel;

    private Integer currentPersonnel;

    public EatingTogetherResponse(EatingTogether eatingTogether, String userName, RestaurantInfo restaurantInfo, Integer size){
        this.id = eatingTogether.getId();
        this.bootcampId = eatingTogether.getBootcampId();
        this.postTitle = eatingTogether.getPostTitle();
        this.postContents = eatingTogether.getPostContents();
        this.userName = userName;
        this.restaurantInfoId = restaurantInfo.getId();
        this.restaurantName = restaurantInfo.getRestaurantName();
        this.restaurantPositionLa = restaurantInfo.getRestaurantPositionLa();
        this.restaurantPositionMa = restaurantInfo.getRestaurantPositionMa();
        this.appointmentDate = LocalDate.now();
        this.currentPersonnel = size;
        this.personnel = eatingTogether.getPersonnel();
    }
}
