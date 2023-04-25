package com.KookBee.classservice.domain.dto;


import com.KookBee.classservice.domain.enums.EPostType;
import com.KookBee.classservice.domain.enums.EStatus;
import com.KookBee.classservice.domain.request.PostCreateRequest;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PostDTO {

    private EPostType postType;
    private String postTitle;
    private String postContent;
    private LocalDate postCreateAt;
    private Long writerId; //아이디로 이름을 가져오자...? 토큰에서 id 가져오면 될듯?
    private Long bootcampId;
    private String fileUUID; // uuid 만 저장
    private EStatus status;

    public PostDTO(PostCreateRequest request) {
        this.postType = request.getPostType();
        this.postTitle = request.getPostTitle();
        this.postContent = request.getPostContent();
        this.fileUUID = request.getFileUUID();
        this.bootcampId = request.getBootcampId();
        this.status = request.getStatus();
    }
}
