package com.KookBee.classservice.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PutProductItemsRequest {
    private Long productItemId;
    private Integer productCount;
}
