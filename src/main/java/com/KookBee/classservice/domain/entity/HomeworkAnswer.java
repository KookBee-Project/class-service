package com.KookBee.classservice.domain.entity;

import com.KookBee.classservice.domain.enums.EHomeworkStatus;
import com.KookBee.classservice.domain.enums.EStatus;
import com.KookBee.classservice.domain.request.HomeworkAnswerCommentRequest;
import com.KookBee.classservice.domain.request.HomeworkAnswerRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class HomeworkAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "homework_answer_id")
    private Long id;
    private Long userId;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "homework_question_id")
    private HomeworkQuestion homeworkQuestion;
    private String homeworkAnswerUpdateAt;
    private Integer homeworkAnswerScore;
    private String homeworkAnswerContent;
    private String homeworkAnswerImages;
    private String homeworkAnswerComment;
    @Enumerated(EnumType.STRING)
    private EHomeworkStatus homeworkAnswerStatus;

    public HomeworkAnswer(HomeworkAnswerRequest request, Long userId, HomeworkQuestion homeworkQuestion) {
        this.userId = userId;
        this.homeworkQuestion = homeworkQuestion;
        this.homeworkAnswerUpdateAt = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.homeworkAnswerContent = request.getHomeworkAnswerContent();
        this.homeworkAnswerImages = request.getHomeworkAnswerImages();
        this.homeworkAnswerStatus = EHomeworkStatus.SUBMIT;
    }

    public void updateHomeworkAnswer(String homeworkAnswerContent, String homeworkAnswerImages) {
        this.homeworkAnswerContent = homeworkAnswerContent;
        this.homeworkAnswerImages = homeworkAnswerImages;
    }

    public void addComment(HomeworkAnswerCommentRequest request) {
        this.homeworkAnswerComment = request.getHomeworkAnswerComment();
        this.homeworkAnswerScore = request.getHomeworkAnswerScore();
        this.homeworkAnswerStatus = EHomeworkStatus.COMPLETE;
    }
}
