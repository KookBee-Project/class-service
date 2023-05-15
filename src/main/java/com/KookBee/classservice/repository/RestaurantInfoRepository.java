package com.KookBee.classservice.repository;

import com.KookBee.classservice.domain.entity.RestaurantInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Vector;

public interface RestaurantInfoRepository extends JpaRepository<RestaurantInfo, Long> {

    Optional<RestaurantInfo> findByRestaurantPositionLaAndRestaurantPositionMa(Double restaurantPositionLa, Double restaurantPositionMa);
}
