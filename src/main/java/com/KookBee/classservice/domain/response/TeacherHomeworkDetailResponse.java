package com.KookBee.classservice.domain.response;

import com.KookBee.classservice.domain.entity.HomeworkQuestion;
import com.KookBee.classservice.domain.entity.SkillSet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TeacherHomeworkDetailResponse {
    private Long homeworkId;
    private String homeworkTitle;
    private String homeworkContent;
    private String homeworkStartDate;
    private String homeworkEndDate;
    private String curriculumName;
    private String skillSetName;
    private Long skillSetId;
    private Integer summitStudent;
    private Integer totalStudent;

    public TeacherHomeworkDetailResponse(HomeworkQuestion homeworkQuestion, Integer totalStudent) {
        this.homeworkId = homeworkQuestion.getId();
        this.homeworkTitle = homeworkQuestion.getHomeworkQuestionTitle();
        this.homeworkContent = homeworkQuestion.getHomeworkQuestionContent();
        this.homeworkStartDate = homeworkQuestion.getHomeworkQuestionStartDate();
        this.homeworkEndDate = homeworkQuestion.getHomeworkQuestionEndDate();
        this.curriculumName = homeworkQuestion.getCurriculum().getCurriculumName();
        this.skillSetName = homeworkQuestion.getSkillSet().getSkillSetName();
        this.skillSetId = homeworkQuestion.getSkillSet().getId();
        this.totalStudent = totalStudent;
    }
}
