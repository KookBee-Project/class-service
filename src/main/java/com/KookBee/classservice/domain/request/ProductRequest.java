package com.KookBee.classservice.domain.request;

import com.KookBee.classservice.domain.enums.EProductStatus;
import com.KookBee.classservice.domain.enums.EProductType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ProductRequest {
    public Long managerId;
    public Long studentId;
    public Date productRentalStartDate;
    public Date productRentalEndDate;
    public String productName;
    public String productCode;
    public EProductType productType;
    public EProductStatus productStatus;
    public Integer productCount;
}
