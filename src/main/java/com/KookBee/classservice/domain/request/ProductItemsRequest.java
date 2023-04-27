package com.KookBee.classservice.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ProductItemsRequest {
    private String productItemName;
    private Integer productItemCounts;
    private Long managerId;
    private String campusName;
}
