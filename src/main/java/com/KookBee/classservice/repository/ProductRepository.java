package com.KookBee.classservice.repository;

import com.KookBee.classservice.domain.entity.Product;
import com.KookBee.classservice.domain.enums.EProductType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByStudentIdAndProductType(Long studentId, EProductType productType);

    List<Product> findByBootcampId(Long bootcampId);

    List<Long> findProductItemIdByBootcampId(Long bootcampId);

}
