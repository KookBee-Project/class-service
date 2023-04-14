package com.KookBee.classservice.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class HomeworkQuestion {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "homework_question_id")
    private Long id;
    private Long teacherId;
    @ManyToOne
    @JoinColumn(name = "class_id")
    private Classes classes;
    private String homeworkQuestionStartDate;
    private String homeworkQuestionEndDate;
    private String homeworkQuestionTitle;
    private String homeworkQuestionContent;
    private String homeworkQuestionImage;

}
