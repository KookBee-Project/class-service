package com.KookBee.classservice.domain.response;

import com.KookBee.classservice.domain.entity.Bootcamp;
import com.KookBee.classservice.domain.entity.Comment;
import com.KookBee.classservice.domain.enums.EPostType;
import com.KookBee.classservice.domain.enums.EStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostListResponse {
    private Long id;
    private EPostType postType;
    private String postTitle;
    private String postContent;
    private LocalDate postCreateAt;
    private String writerName; //아이디로 이름을 가져오자...? 토큰으로 가져오면 될듯?
    private Bootcamp bootcamp; // 부트캠프 아이디 가져오기
    private Long commentCount;
    private String fileUUID; // uuid 만 저장
    @Enumerated(EnumType.STRING)
    private EStatus status;
}
