package com.KookBee.classservice.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HomeworkAnswerCommentRequest {
    private Long homeworkAnswerId;
    private String homeworkAnswerComment;
    private Integer homeworkAnswerScore;
}
