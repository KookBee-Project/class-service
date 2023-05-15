package com.KookBee.classservice.domain.response;

import com.KookBee.classservice.domain.entity.HomeworkQuestion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class MyPageHomeworkListResponse {
    private Long homeworkQuestionId;
    private String homeworkCurriculumName;
    private String homeworkQuestionTitle;
    private String skillSet;
    private String homeworkQuestionEndDate;
    private String homeworkStatus;

    public MyPageHomeworkListResponse(HomeworkQuestion homeworkQuestion, String isAnswer) {
        this.homeworkQuestionId = homeworkQuestion.getId();
        this.homeworkCurriculumName = homeworkQuestion.getCurriculum().getCurriculumName();
        this.homeworkQuestionTitle = homeworkQuestion.getHomeworkQuestionTitle();
        this.skillSet = homeworkQuestion.getSkillSet().getSkillSetName();
        this.homeworkQuestionEndDate = homeworkQuestion.getHomeworkQuestionEndDate();
        this.homeworkStatus = isAnswer;
    }
}
