package com.KookBee.classservice.domain.response;

import com.KookBee.classservice.domain.entity.HomeworkQuestions;
import com.KookBee.classservice.domain.entity.SkillSet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TeacherHomeworkListResponse {
    private Long homeworkId;
    private String homeworkTitle;
    private String homeworkContent;
    private String homeworkStartDate;
    private String curriculumName;
    private String homeworkEndDate;
    private SkillSet skillSet;
    private Integer summitStudent;
    private Integer totalStudent;

    public TeacherHomeworkListResponse(HomeworkQuestions homeworkQuestions, Integer totalStudent) {
        this.homeworkId = homeworkQuestions.getId();
        this.homeworkTitle = homeworkQuestions.getHomeworkQuestionTitle();
        this.homeworkContent = homeworkQuestions.getHomeworkQuestionContent();
        this.homeworkStartDate = homeworkQuestions.getHomeworkQuestionStartDate();
        this.homeworkEndDate = homeworkQuestions.getHomeworkQuestionEndDate();
        this.skillSet = homeworkQuestions.getSkillSet();
        this.totalStudent = totalStudent;
    }
}
