package com.KookBee.classservice.domain.response;

import com.KookBee.classservice.domain.entity.HomeworkAnswer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentHomeworkAnswerDetailResponse {
    private String homeworkQuestionTitle;
    private String bootcampName;
    private String curriculumName;
    private String teacherName;
    private String skillSetName;
    private Long skillSetId;
    private String homeworkQuestionStartDate;
    private String homeworkQuestionEndDate;
    private String homeworkQuestionContent;
    private String homeworkQuestionImages;
    private String homeworkAnswerContent;
    private Integer homeworkAnswerScore;
    private String homeworkAnswerImages;
    private String homeworkAnswerComment;

    public StudentHomeworkAnswerDetailResponse(HomeworkAnswer homeworkAnswer, String teacherName) {
        this.homeworkQuestionTitle = homeworkAnswer.getHomeworkQuestion().getHomeworkQuestionTitle();
        this.bootcampName = homeworkAnswer.getHomeworkQuestion().getCurriculum().getBootcamp().getBootcampTitle();
        this.curriculumName = homeworkAnswer.getHomeworkQuestion().getCurriculum().getCurriculumName();
        this.teacherName = teacherName;
        this.skillSetName = homeworkAnswer.getHomeworkQuestion().getSkillSet().getSkillSetName();
        this.skillSetId = homeworkAnswer.getHomeworkQuestion().getSkillSet().getId();
        this.homeworkQuestionStartDate = homeworkAnswer.getHomeworkQuestion().getHomeworkQuestionStartDate();
        this.homeworkQuestionEndDate = homeworkAnswer.getHomeworkQuestion().getHomeworkQuestionEndDate();
        this.homeworkQuestionContent = homeworkAnswer.getHomeworkQuestion().getHomeworkQuestionContent();
        this.homeworkQuestionImages = homeworkAnswer.getHomeworkQuestion().getHomeworkQuestionImage();
        this.homeworkAnswerContent = homeworkAnswer.getHomeworkAnswerContent();
        this.homeworkAnswerImages = homeworkAnswer.getHomeworkAnswerImages();
        this.homeworkAnswerScore = homeworkAnswer.getHomeworkAnswerScore();
        this.homeworkAnswerComment = homeworkAnswer.getHomeworkAnswerComment();
    }
}
