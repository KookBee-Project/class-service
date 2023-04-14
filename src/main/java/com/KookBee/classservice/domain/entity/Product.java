package com.KookBee.classservice.domain.entity;

import com.KookBee.classservice.domain.enums.EProductStatus;
import com.KookBee.classservice.domain.enums.EProductType;
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
    public Date product_rental_start_date;
    public Date product_rental_end_date;
    public String product_name;
    public String product_code;
    @Enumerated(EnumType.STRING)
    public EProductType product_type;
    @Enumerated(EnumType.STRING)
    public EProductStatus product_status;
    public Integer product_count;
}