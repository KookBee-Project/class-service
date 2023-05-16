package com.KookBee.classservice.domain.response;

import com.KookBee.classservice.domain.entity.Product;
import com.KookBee.classservice.domain.enums.EProductStatus;
import com.KookBee.classservice.domain.enums.EProductType;

import java.time.LocalDate;
import java.util.Date;

public class RentalProductResponse {
    private Long id;
    public String bootcampTitle;
    public Long studentId;
    public LocalDate productRentalStartDate;
    public LocalDate productRentalEndDate;
    public String productItemName;
    public EProductType productType;
    public Integer productCount;

    public RentalProductResponse(Product product, String bootcampTitle, String productItemName){
        this.id = product.getId();
        this.bootcampTitle = bootcampTitle;
        this.studentId = product.getStudentId();
        this.productRentalStartDate = product.getProductRentalStartDate();
        this.productRentalEndDate = product.getProductRentalEndDate();
        this.productItemName = productItemName;
        this.productType = product.getProductType();
        this.productCount = product.getProductCount();
    }
}
