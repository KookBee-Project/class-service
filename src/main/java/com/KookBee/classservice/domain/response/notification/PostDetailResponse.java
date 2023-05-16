package com.KookBee.classservice.domain.response.notification;

import com.KookBee.classservice.domain.entity.Comment;
import com.KookBee.classservice.domain.entity.Post;
import com.KookBee.classservice.domain.enums.EPostType;
import com.KookBee.classservice.domain.enums.EStatus;
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
public class PostDetailResponse {
    private Long id;
    private EPostType postType;
    private String postTitle;
    private String postContent;
    private LocalDate postCreateAt;
    private String writerName;
    private Long writerId;

//    private Bootcamp bootcamp; // 부트캠프 아이디 가져오기

    private List<Comment> commentList;

    private String fileUUID; // uuid 만 저장

    private EStatus status;
    private Long viewCount;

    public PostDetailResponse(Post post, String writerName) {
        this.id = post.getId();
        this.postType = post.getPostType();
        this.postTitle = post.getPostTitle();
        this.postContent = post.getPostContent();
        this.postCreateAt = post.getPostCreateAt();
        this.writerName = writerName;
        this.writerId = post.getWriterId();
        this.commentList = post.getCommentList();
        this.fileUUID = post.getFileUUID();
        this.status = post.getStatus();
        this.viewCount = post.getViewCount();
    }
    public PostDetailResponse(Post post) {
        this.id = post.getId();
        this.postType = post.getPostType();
        this.postTitle = post.getPostTitle();
        this.postContent = post.getPostContent();
        this.postCreateAt = post.getPostCreateAt();
        this.writerId = post.getWriterId();
        this.commentList = post.getCommentList();
        this.fileUUID = post.getFileUUID();
        this.status = post.getStatus();
        this.viewCount = post.getViewCount();
    }
}
