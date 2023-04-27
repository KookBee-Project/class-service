package com.KookBee.classservice.domain.response;

import com.KookBee.classservice.domain.entity.ProductItems;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ProductItemsResponse {
    private Long id;
    private String productItemName;
    private Integer productItemCounts;

    public ProductItemsResponse(ProductItems productItems){
        this.id = productItems.getId();
        this.productItemName = productItems.getProductItemName();
        this.productItemCounts = productItems.getProductItemCounts();
    }
}
