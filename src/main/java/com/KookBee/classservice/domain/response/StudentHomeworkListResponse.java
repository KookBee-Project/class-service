package com.KookBee.classservice.domain.response;

import com.KookBee.classservice.domain.entity.HomeworkAnswer;
import com.KookBee.classservice.domain.entity.HomeworkQuestion;
import com.KookBee.classservice.domain.entity.SkillSet;
import com.KookBee.classservice.domain.enums.EHomeworkStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentHomeworkListResponse {
    private Long homeworkQuestionId;
    private String bootcampTitle;
    private String curriculumName;
    private String skillSetName;
    private String homeworkQuestionTitle;
    private String homeworkQuestionStartDate;
    private String homeworkQuestionEndDate;
    private EHomeworkStatus homeworkAnswerStatus;

    public StudentHomeworkListResponse(HomeworkQuestion homeworkQuestion, String bootcampTitle, SkillSet skillSet, HomeworkAnswer answer) {
        this.homeworkQuestionId = homeworkQuestion.getId();
        if(bootcampTitle.length() <= 10) this.bootcampTitle = bootcampTitle;
        else this.bootcampTitle = bootcampTitle.substring(0, 9) + "...";
        if(homeworkQuestion.getCurriculum().getCurriculumName().length() <= 10) this.curriculumName = homeworkQuestion.getCurriculum().getCurriculumName();
        else this.curriculumName = homeworkQuestion.getCurriculum().getCurriculumName().substring(0, 9);
        this.curriculumName = homeworkQuestion.getCurriculum().getCurriculumName();
        this.skillSetName = skillSet.getSkillSetName();
        this.homeworkQuestionTitle = homeworkQuestion.getHomeworkQuestionTitle();
        this.homeworkQuestionStartDate = homeworkQuestion.getHomeworkQuestionStartDate();
        this.homeworkQuestionEndDate = homeworkQuestion.getHomeworkQuestionEndDate();
        if(answer == null)
            this.homeworkAnswerStatus = null;
        else
            this.homeworkAnswerStatus = answer.getHomeworkAnswerStatus();
    }

}
