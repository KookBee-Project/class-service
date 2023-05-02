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
public class TeacherHomeworkAnswerListResponse {
    private Long homeworkAnswerId;
    private String studentName;
    private String homeworkAnswerUpdateAt;
    private Integer homeworkAnswerScore;

    public TeacherHomeworkAnswerListResponse(HomeworkAnswer homeworkAnswer, String studentName) {
        this.homeworkAnswerId = homeworkAnswer.getId();
        this.studentName = studentName;
        this.homeworkAnswerUpdateAt = homeworkAnswer.getHomeworkAnswerUpdateAt();
        this.homeworkAnswerScore = homeworkAnswer.getHomeworkAnswerScore();
    }
}
