package com.KookBee.classservice.domain.entity;

import com.KookBee.classservice.domain.enums.EStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private String homeworkAnswerContent;
    private String homeworkAnswerImages;
    @Enumerated(EnumType.STRING)
    private EStatus homeworkAnswerStatus;
}
