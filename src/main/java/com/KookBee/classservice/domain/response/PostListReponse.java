package com.KookBee.classservice.domain.response;

import com.KookBee.classservice.domain.entity.Post;
import com.KookBee.classservice.domain.enums.EPostType;
import com.KookBee.classservice.domain.enums.EStatus;

import java.time.LocalDate;

public class PostListReponse {
    private Long id;
    private EPostType postType;
    private String postTitle;
    private String postContent;
    private LocalDate postCreateAt;
    private Long writerId;
    private String fileUUID; // uuid 만 저장
    private EStatus status;

    public PostListReponse(Post post) {
        this.id = post.getId();
        this.postType = post.getPostType();
        this.postTitle = post.getPostTitle();
        this.postContent = post.getPostContent();
        if(post.getPostContent().length() <= 10)
            this.postContent = post.getPostContent();
        else
            this.postContent = post.getPostContent().substring(0, 20) + "...";
        this.postCreateAt = post.getPostCreateAt();
        this.writerId = post.getWriterId();
        this.fileUUID = post.getFileUUID();
        this.status = post.getStatus();
    }
}