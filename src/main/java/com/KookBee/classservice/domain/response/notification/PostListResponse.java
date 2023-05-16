package com.KookBee.classservice.domain.response.notification;

import com.KookBee.classservice.domain.entity.Post;
import com.KookBee.classservice.domain.enums.EPostType;
import com.KookBee.classservice.domain.enums.EStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

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
    private String writerName;
    private Long commentCount;
    private String fileUUID; // uuid 만 저장

    private EStatus status;
    private Long viewCount;
    public PostListResponse(Post post, String writerName, Long commentCount) {
        this.id = post.getId();
        this.postType = post.getPostType();
        this.postTitle = post.getPostTitle();

        if (post.getPostContent().length() < 5 ){
            this.postContent = post.getPostContent();
        }
        else {
            this.postContent = post.getPostContent().substring(0,5) + "...";
        }
        this.postCreateAt = post.getPostCreateAt();
        this.writerName = writerName;
        this.commentCount = commentCount;
        this.fileUUID = post.getFileUUID();
        this.status = post.getStatus();
        this.viewCount = post.getViewCount();
    }
}
