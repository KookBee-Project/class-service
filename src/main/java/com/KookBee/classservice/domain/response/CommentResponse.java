package com.KookBee.classservice.domain.response;

import com.KookBee.classservice.domain.entity.Comment;
import com.KookBee.classservice.domain.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommentResponse {
    private Long id;
    private String commentContents;
    private Long writerId;
//    private String writerName;// 나중에 유저 feign으로 가져와서 이름 리턴할것!!
    private Post post;
    private LocalDate commentCreateAt;

    public CommentResponse(Comment comment) {
        this.id = comment.getId();
        this.commentContents = comment.getCommentContents();
        this.writerId = comment.getWriterId();
        this.post = comment.getPost();
        this.commentCreateAt = comment.getCommentCreateAt();
    }
}
