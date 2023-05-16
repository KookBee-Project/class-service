package com.KookBee.classservice.domain.request;

import com.KookBee.classservice.domain.entity.EatingTogether;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class EatingPartyRequest {
    private Long eatingTogetherId;
}
