package com.KookBee.classservice.domain.entity;

import com.KookBee.classservice.domain.request.PostRestaurantInfoRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Vector;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RestaurantInfo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_info_id")
    private Long id;
    private String restaurantName;
    private Double restaurantPositionLa;
    private Double restaurantPositionMa;
    @OneToMany(mappedBy = "restaurantInfo", fetch = FetchType.LAZY)
    private List<EatingTogether> eatingTogetherList;


    public RestaurantInfo(PostRestaurantInfoRequest request) {
        this.restaurantName = request.getRestaurantName();
        this.restaurantPositionLa = request.getRestaurantPositionLa();
        this.restaurantPositionMa = request.getRestaurantPositionMa();
    }

    public RestaurantInfo(Long id) {
        this.id = id;
    }
}
