package com.KookBee.classservice.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ProductItems {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productItem_id")
    private Long id;
    private String productItemName;
    private Integer productItemCounts;
    private Long managerId;
    private String campusName;
}
