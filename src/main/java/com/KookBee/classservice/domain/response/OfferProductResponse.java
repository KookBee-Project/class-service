package com.KookBee.classservice.domain.response;

import com.KookBee.classservice.domain.entity.Product;
import com.KookBee.classservice.domain.enums.EProductStatus;
import com.KookBee.classservice.domain.enums.EProductType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.Date;

public class OfferProductResponse {
    private Long id;
    private Long bootcampId;
    public Long studentId;
    public Date productRentalStartDate;
    public Long productItemId;
    public EProductType productType;
    public EProductStatus productStatus;
    public Integer productCount;

    public OfferProductResponse(Product product){
        this.id = product.getId();
        this.bootcampId = product.getBootcampId();
        this.studentId = product.getStudentId();
        this.productRentalStartDate = product.getProductRentalStartDate();
        this.productItemId = product.getProductItemId();
        this.productType = product.getProductType();
        this.productStatus = product.getProductStatus();
        this.productCount = product.getProductCount();
    }
}
