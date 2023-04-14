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
    public Long manager_id;
    public Long student_id;
    public Date product_rental_start_date;
    public Date product_rental_end_date;
    public String product_name;
    public String product_code;
    @Enumerated(EnumType.STRING)
    public EProductType product_type;
    @Enumerated(EnumType.STRING)
    public EProductStatus product_status;
    public Integer product_count;

    public Product(ProductRequest productRequest) {
        this.manager_id = productRequest.getManager_id();
        this.student_id = productRequest.getStudent_id();
        this.product_rental_start_date = productRequest.getProduct_rental_start_date();
        this.product_rental_end_date = productRequest.getProduct_rental_end_date();
        this.product_name = productRequest.getProduct_name();
        this.product_code = productRequest.getProduct_code();
        this.product_type = productRequest.getProduct_type();
        this.product_status = productRequest.getProduct_status();
        this.product_count = productRequest.getProduct_count();
    }
}