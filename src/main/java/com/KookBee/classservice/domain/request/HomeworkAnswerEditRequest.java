package com.KookBee.classservice.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HomeworkAnswerEditRequest {
    private Long homeworkAnswerId;
    private String homeworkAnswerContent;
    private String homeworkAnswerImages;
}
