package com.KookBee.classservice.domain.request;

import com.KookBee.classservice.domain.enums.EProductStatus;
import com.KookBee.classservice.domain.enums.EProductType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ProductRequest {
    public Long managerId;
    public Long studentId;
    private Long bootcampId;
    public LocalDate productRentalStartDate;
    public LocalDate productRentalEndDate;
    public Long productItemId;
    public EProductType productType;
    public Integer productCount;
}
