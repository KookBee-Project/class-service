package com.KookBee.classservice.domain.entity;

import com.KookBee.classservice.domain.enums.EProductStatus;
import com.KookBee.classservice.domain.enums.EProductType;
import com.KookBee.classservice.domain.request.ProductRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    public Date productRentalStartDate;
    public Date productRentalEndDate;
    public String productName;
    public String productCode;
    @Enumerated(EnumType.STRING)
    public EProductType productType;
    @Enumerated(EnumType.STRING)
    public EProductStatus productStatus;
    public Integer productCount;

    public Product(ProductRequest productRequest) {
        this.managerId = productRequest.getManagerId();
        this.studentId = productRequest.getStudentId();
        this.productRentalStartDate = productRequest.getProductRentalStartDate();
        this.productRentalEndDate = productRequest.getProductRentalEndDate();
        this.productName = productRequest.getProductName();
        this.productCode = productRequest.getProductCode();
        this.productType = productRequest.getProductType();
        this.productStatus = productRequest.getProductStatus();
        this.productCount = productRequest.getProductCount();
    }
}