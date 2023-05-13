package com.KookBee.classservice.domain.response;

import com.KookBee.classservice.domain.entity.Bootcamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class BootcampNameListResponse {
    private Long bootcampId;
    private String bootcampName;

    public BootcampNameListResponse(Bootcamp bootcamp) {
        this.bootcampId = bootcamp.getId();
        this.bootcampName = bootcamp.getBootcampTitle();
    }
}
