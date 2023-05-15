package com.KookBee.classservice.domain.response;

import com.KookBee.classservice.domain.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class MyPageQnAListResponse {
    private Long postId;
    private String bootcampTitle;
    private String postTitle;
    private String postCreateAt;
    private String isAnswer;

    public MyPageQnAListResponse(Post post, String isAnswer) {
        this.postId = post.getId();
        this.bootcampTitle = post.getBootcamp().getBootcampTitle();
        this.postTitle = post.getPostTitle();
        this.postCreateAt = String.valueOf(post.getPostCreateAt());
        this.isAnswer = isAnswer;
    }
}
