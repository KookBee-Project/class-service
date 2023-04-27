package com.KookBee.classservice.domain.response;

import com.KookBee.classservice.domain.entity.Product;
import com.KookBee.classservice.domain.enums.EProductStatus;
import com.KookBee.classservice.domain.enums.EProductType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;
import java.util.Date;

public class OfferProductResponse {
    private Long id;
    private Long bootcampId;
    public Long studentId;
    public LocalDate productRentalStartDate;
    public Long productItemId;
    public EProductType productType;
    public Integer productCount;

    public OfferProductResponse(Product product){
        this.id = product.getId();
        this.bootcampId = product.getBootcampId();
        this.studentId = product.getStudentId();
        this.productRentalStartDate = product.getProductRentalStartDate();
        this.productItemId = product.getProductItemId();
        this.productType = product.getProductType();
        this.productCount = product.getProductCount();
    }
}
