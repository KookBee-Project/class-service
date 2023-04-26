package com.KookBee.classservice.domain.entity;

import com.KookBee.classservice.domain.enums.EStatus;
import com.KookBee.classservice.domain.request.HomeworkQuestionRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class HomeworkQuestion {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "homework_question_id")
    private Long id;
    private Long userId;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "curriculum_id")
    private Curriculum curriculum;
    private String homeworkQuestionStartDate;
    private String homeworkQuestionEndDate;
    private String homeworkQuestionTitle;
    private String homeworkQuestionContent;
    private String homeworkQuestionImage;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "skill_set_id")
    private SkillSet skillSet;
    @JsonIgnore
    @OneToMany(mappedBy = "homeworkQuestion")
    private List<HomeworkAnswer> homeworkAnswerList;
    @Enumerated(EnumType.STRING)
    private EStatus homeworkStatus = EStatus.PROCEEDING;


    public HomeworkQuestion(HomeworkQuestionRequest request, Long userId, Curriculum curriculum, SkillSet skillSet) {
        this.userId = userId;
        this.curriculum = curriculum;
        this.homeworkQuestionStartDate = request.getHomeworkQuestionStartDate();
        this.homeworkQuestionEndDate = request.getHomeworkQuestionEndDate();
        this.homeworkQuestionTitle = request.getHomeworkQuestionTitle();
        this.homeworkQuestionContent = request.getHomeworkQuestionContent();
        this.homeworkQuestionImage = request.getHomeworkQuestionImage();
        this.skillSet = skillSet;
    }
}
