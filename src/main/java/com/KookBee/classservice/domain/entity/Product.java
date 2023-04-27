package com.KookBee.classservice.domain.entity;

import com.KookBee.classservice.domain.enums.EProductStatus;
import com.KookBee.classservice.domain.enums.EProductType;
import com.KookBee.classservice.domain.request.ProductRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    public Long id;
    public Long managerId;
    public Long studentId;
    private Long bootcampId;
    public LocalDate productRentalStartDate;
    public LocalDate productRentalEndDate;
    public Long productItemId;
    @Enumerated(EnumType.STRING)
    public EProductType productType;
    public Integer productCount;

    public Product(ProductRequest productRequest) {
        this.managerId = productRequest.getManagerId();
        this.studentId = productRequest.getStudentId();
        this.productRentalStartDate = productRequest.getProductRentalStartDate();
        this.productRentalEndDate = productRequest.getProductRentalEndDate();
        this.productItemId = productRequest.getProductItemId();
        this.productType = productRequest.getProductType();
        this.productCount = productRequest.getProductCount();
        this.bootcampId = productRequest.getBootcampId();
    }
}