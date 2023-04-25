package com.KookBee.classservice.domain.entity;

import com.KookBee.classservice.domain.dto.PostDTO;
import com.KookBee.classservice.domain.enums.EPostType;
import com.KookBee.classservice.domain.enums.EStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Post {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private EPostType postType;
    private String postTitle;
    private String postContent;
    private LocalDate postCreateAt;
    private Long writerId; //아이디로 이름을 가져오자...? 토큰으로 가져오면 될듯?
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bootcamp_id")
    private Bootcamp bootcamp; // 부트캠프 아이디 가져오기
    private String fileUUID; // uuid 만 저장
    private EStatus status;

    public Post(PostDTO dto, Long userId) {
        this.postType = dto.getPostType();
        this.postTitle = dto.getPostTitle();
        this.postContent = dto.getPostContent();
        this.postCreateAt = LocalDate.now();
        this.writerId = userId;
        this.fileUUID = dto.getFileUUID();
        this.status = dto.getStatus();
    }
}

