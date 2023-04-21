package com.KookBee.classservice.domain.response;

import com.KookBee.classservice.domain.entity.Product;
import com.KookBee.classservice.domain.enums.EProductStatus;
import com.KookBee.classservice.domain.enums.EProductType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.Date;

public class OfferProductResponse {
    private Long id;
    private String bootcampTitle;
    public Long studentId;
    public Date productRentalStartDate;
    public String productName;
    public EProductType productType;
    public EProductStatus productStatus;
    public Integer productCount;

    public OfferProductResponse(Product product){
        this.id = product.getId();
        this.bootcampTitle = product.getBootcampTitle();
        this.studentId = product.getStudentId();
        this.productRentalStartDate = product.getProductRentalStartDate();
        this.productName = product.getProductName();
        this.productType = product.getProductType();
        this.productStatus = product.getProductStatus();
        this.productCount = product.getProductCount();
    }
}
