package com.KookBee.classservice.domain.response;

import com.KookBee.classservice.domain.entity.Product;
import com.KookBee.classservice.domain.enums.EProductStatus;
import com.KookBee.classservice.domain.enums.EProductType;

import java.util.Date;

public class RentalProductResponse {
    private Long id;
    private Long bootcampId;
    public Long studentId;
    public Date productRentalStartDate;
    public Date productRentalEndDate;
    public Long productItemId;
    public EProductType productType;
    public EProductStatus productStatus;
    public Integer productCount;

    public RentalProductResponse(Product product){
        this.id = product.getId();
        this.bootcampId = product.getBootcampId();
        this.studentId = product.getStudentId();
        this.productRentalStartDate = product.getProductRentalStartDate();
        this.productRentalEndDate = product.getProductRentalEndDate();
        this.productItemId = product.getProductItemId();
        this.productType = product.getProductType();
        this.productStatus = product.getProductStatus();
        this.productCount = product.getProductCount();
    }
}
