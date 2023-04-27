package com.KookBee.classservice.repository;

import com.KookBee.classservice.domain.entity.ProductItems;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductItemsRepository extends JpaRepository<ProductItems, Long> {
    List<ProductItems> findByCampusNameAndManagerId(String campusName, Long managerId);

    Optional<ProductItems> findById(Long productItemId);
}
