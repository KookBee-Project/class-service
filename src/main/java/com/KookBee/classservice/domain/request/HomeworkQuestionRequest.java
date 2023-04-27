package com.KookBee.classservice.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class HomeworkQuestionRequest {
    private Long curriculumId;
    private String homeworkQuestionStartDate;
    private String homeworkQuestionEndDate;
    private String homeworkQuestionTitle;
    private String homeworkQuestionContent;
    private String homeworkQuestionImage;
    private Long skillSetId;
}
