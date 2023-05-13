package com.KookBee.classservice.domain.dto;

import com.KookBee.classservice.domain.enums.EDayOffStatus;
import com.KookBee.classservice.domain.request.DayOffStatusModifyRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class DayOffStatusModifyDTO {
    private Long dayOffId;
    private EDayOffStatus dayOffManagerStatus;
    private EDayOffStatus dayOffTeacherStatus;
    private EDayOffStatus dayOffStatus;

    public DayOffStatusModifyDTO(Long dayOffId, DayOffStatusModifyRequest request) {
        this.dayOffId = dayOffId;
        this.dayOffManagerStatus = request.getDayOffManagerStatus();
        this.dayOffTeacherStatus = request.getDayOffTeacherStatus();

        if(this.dayOffManagerStatus == EDayOffStatus.APPROVAL
                & this.dayOffTeacherStatus == EDayOffStatus.APPROVAL){
            this.dayOffStatus = EDayOffStatus.APPROVAL;
        } else if (this.dayOffManagerStatus == EDayOffStatus.REJECT
                | this.dayOffTeacherStatus == EDayOffStatus.REJECT) {
            this.dayOffStatus = EDayOffStatus.REJECT;
        } else {
            this.dayOffStatus = EDayOffStatus.PENDING;
        }
    }
}
