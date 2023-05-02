package com.KookBee.classservice.domain.dto;

import com.KookBee.classservice.domain.request.CommentCreateRequest;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
    private String commentContents;
    private Long writerId;
    private Long postId;
    private LocalDate commentCreateAt;

    public CommentDTO(CommentCreateRequest request) {
        this.commentContents = request.getCommentContents();
    }
}
