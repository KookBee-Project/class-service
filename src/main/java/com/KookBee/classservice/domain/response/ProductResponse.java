package com.KookBee.classservice.domain.response;

import com.KookBee.classservice.domain.entity.Product;
import com.KookBee.classservice.domain.entity.ProductItems;
import com.KookBee.classservice.domain.enums.EProductType;

import java.time.LocalDate;

public class ProductResponse {
    public Long id;
    public Long managerId;
    public String studentName;
    public Long studentId;
    private Long bootcampId;
    public LocalDate productRentalStartDate;
    public LocalDate productRentalEndDate;
    public Long productItemId;
    public String productItemName;
    public EProductType productType;
    public Integer productCount;
    public ProductResponse(Product product, String productItemName, String studentName){
        this.id = product.getId();
        this.managerId = product.getManagerId();
        this.studentId = product.getStudentId();
        this.bootcampId = product.getBootcampId();
        this.productRentalStartDate = product.getProductRentalStartDate();
        this.productRentalEndDate = product.getProductRentalEndDate();
        this.productItemId = product.getProductItemId();
        this.productType = product.getProductType();
        this.productCount = product.getProductCount();
        this.productItemName = productItemName;
        this.studentName = studentName;
    }
}
