package com.KookBee.classservice.domain.request;

import com.KookBee.classservice.domain.enums.EPostType;
import com.KookBee.classservice.domain.enums.EStatus;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PostCreateRequest {

    private EPostType postType;
    private String postTitle;
    private String postContent;
    private Long bootcampId;
    private String fileUUID; // uuid 만 저장
    private EStatus status;


}
