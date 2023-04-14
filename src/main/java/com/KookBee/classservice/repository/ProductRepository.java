package com.KookBee.classservice.repository;

import com.KookBee.classservice.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
