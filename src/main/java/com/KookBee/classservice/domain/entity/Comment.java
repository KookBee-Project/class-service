package com.KookBee.classservice.domain.entity;

import com.KookBee.classservice.domain.dto.CommentDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String commentContents;
    private Long writerId;
    private String writerName;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;
    private LocalDate commentCreateAt;

    public Comment(CommentDTO dto, Long writerId, String writerName, Post post  ) {
        this.commentContents = dto.getCommentContents();
        this.writerId = writerId;
        this.writerName = writerName;
        this.post = post;
        this.commentCreateAt = LocalDate.now();
    }
}
