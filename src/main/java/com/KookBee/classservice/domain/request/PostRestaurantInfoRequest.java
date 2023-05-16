package com.KookBee.classservice.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Vector;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PostRestaurantInfoRequest {
    private String restaurantName;
    private Double restaurantPositionLa;
    private Double restaurantPositionMa;
}
