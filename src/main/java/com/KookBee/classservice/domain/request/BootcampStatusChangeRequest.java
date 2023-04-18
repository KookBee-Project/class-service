package com.KookBee.classservice.domain.request;

import com.KookBee.classservice.domain.enums.EStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class BootcampStatusChangeRequest {
    private Long bootcampId;
    public EStatus bootcampStatus;
}
