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
    public String bootcampTitle;
    public Long studentId;
    public LocalDate productRentalStartDate;
    public String productItemName;
    public EProductType productType;
    public Integer productCount;

    public OfferProductResponse(Product product, String bootcampTitle, String productItemName){
        this.id = product.getId();
        this.bootcampTitle = bootcampTitle;
        this.studentId = product.getStudentId();
        this.productRentalStartDate = product.getProductRentalStartDate();
        this.productItemName = productItemName;
        this.productType = product.getProductType();
        this.productCount = product.getProductCount();
    }
}
