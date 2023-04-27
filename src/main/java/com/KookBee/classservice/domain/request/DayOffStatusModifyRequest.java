package com.KookBee.classservice.domain.request;

import com.KookBee.classservice.domain.enums.EDayOffStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class DayOffStatusModifyRequest {
    private EDayOffStatus dayOffManagerStatus;
    private EDayOffStatus dayOffTeacherStatus;
}
