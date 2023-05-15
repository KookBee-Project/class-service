package com.KookBee.classservice.domain.response;

import com.KookBee.classservice.domain.entity.RestaurantInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class RestaurantResponse {

    private Long id;
    private String restaurantName;
    private Double restaurantPositionLa;
    private Double restaurantPositionMa;

    public RestaurantResponse(RestaurantInfo restaurantInfo){
        this.id = restaurantInfo.getId();
        this.restaurantName = restaurantInfo.getRestaurantName();
        this.restaurantPositionLa = restaurantInfo.getRestaurantPositionLa();
        this.restaurantPositionMa = restaurantInfo.getRestaurantPositionMa();
    }
}
