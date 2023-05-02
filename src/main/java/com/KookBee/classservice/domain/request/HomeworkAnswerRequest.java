package com.KookBee.classservice.domain.request;

import com.KookBee.classservice.domain.enums.EHomeworkStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HomeworkAnswerRequest {
    public Long homeworkQuestionId;
    public String homeworkAnswerContent;
    public String homeworkAnswerImages;
}
