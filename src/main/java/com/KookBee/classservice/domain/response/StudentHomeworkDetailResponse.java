package com.KookBee.classservice.domain.response;

import com.KookBee.classservice.domain.entity.HomeworkQuestion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentHomeworkDetailResponse {
    private String homeworkTitle;
    private String bootcampName;
    private String curriculumName;
    private String teacherName;
    private String skillSetName;
    private Long skillSetId;
    private String homeworkStartDate;
    private String homeworkEndDate;
    private String homeworkContent;

    public StudentHomeworkDetailResponse(HomeworkQuestion homeworkQuestion, String teacherName) {
        this.homeworkTitle = homeworkQuestion.getHomeworkQuestionTitle();
        this.bootcampName = homeworkQuestion.getCurriculum().getBootcamp().getBootcampTitle();
        this.curriculumName = homeworkQuestion.getCurriculum().getCurriculumName();
        this.teacherName = teacherName;
        this.skillSetName = homeworkQuestion.getSkillSet().getSkillSetName();
        this.skillSetId = homeworkQuestion.getSkillSet().getId();
        this.homeworkStartDate = homeworkQuestion.getHomeworkQuestionStartDate();
        this.homeworkEndDate = homeworkQuestion.getHomeworkQuestionEndDate();
        this.homeworkContent = homeworkQuestion.getHomeworkQuestionContent();
    }
}
