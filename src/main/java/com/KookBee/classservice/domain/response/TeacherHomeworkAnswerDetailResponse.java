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
public class TeacherHomeworkAnswerDetailResponse {
    private String homeworkQuestionTitle;
    private String curriculumName;
    private String studentName;
    private String skillSetName;
    private String homeworkAnswerUpdateAt;
    private String homeworkAnswerContent;
    private String homeworkAnswerImage;
    private Integer homeworkAnswerScore;
    private String homeworkAnswerComment;

    public TeacherHomeworkAnswerDetailResponse(HomeworkAnswer homeworkAnswer, String studentName) {
        this.homeworkQuestionTitle = homeworkAnswer.getHomeworkQuestion().getHomeworkQuestionTitle();
        this.curriculumName = homeworkAnswer.getHomeworkQuestion().getCurriculum().getCurriculumName();
        this.studentName = studentName;
        this.skillSetName = homeworkAnswer.getHomeworkQuestion().getSkillSet().getSkillSetName();
        this.homeworkAnswerUpdateAt = homeworkAnswer.getHomeworkAnswerUpdateAt();
        this.homeworkAnswerContent = homeworkAnswer.getHomeworkAnswerContent();
        this.homeworkAnswerImage = homeworkAnswer.getHomeworkAnswerImages();
        this.homeworkAnswerScore = homeworkAnswer.getHomeworkAnswerScore();
        this.homeworkAnswerComment = homeworkAnswer.getHomeworkAnswerComment();
    }
}
