package com.KookBee.classservice.domain.response;

import com.KookBee.classservice.domain.entity.HomeworkQuestion;
import com.KookBee.classservice.domain.entity.SkillSet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherHomeworkListResponse {
    private Long homeworkId;
    private String homeworkQuestionTitle;
    private String homeworkQuestionStartDate;
    private String homeworkQuestionEndDate;
    private SkillSet skillSet;
    private Integer summitStudent;
    private Integer totalStudent;

    public TeacherHomeworkListResponse(HomeworkQuestion el, Integer summitStudent, Integer totalStudent) {
        this.homeworkId = el.getId();
        if(el.getHomeworkQuestionTitle().length() <= 10)
            this.homeworkQuestionTitle = el.getHomeworkQuestionTitle();
        else
            this.homeworkQuestionTitle = el.getHomeworkQuestionTitle().substring(0, 9) + "...";
        this.homeworkQuestionStartDate = el.getHomeworkQuestionStartDate();
        this.homeworkQuestionEndDate = el.getHomeworkQuestionEndDate();
        this.skillSet = el.getSkillSet();
        this.summitStudent = summitStudent;
        this.totalStudent = totalStudent;
    }
}
