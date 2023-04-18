package com.KookBee.classservice.domain.entity;

import com.KookBee.classservice.domain.enums.EStatus;
import com.KookBee.classservice.domain.request.HomeworkQuestionRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class HomeworkQuestions {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "homework_question_id")
    private Long id;
    private Long userId;
    @ManyToOne
    @JoinColumn(name = "class_id")
    private Bootcamp bootcamp;
    private String homeworkQuestionStartDate;
    private String homeworkQuestionEndDate;
    private String homeworkQuestionTitle;
    private String homeworkQuestionContent;
    private String homeworkQuestionImage;
    @OneToMany(mappedBy = "homeworkQuestions", fetch = FetchType.LAZY)
    private List<SkillSet> skillSetList;
    @Enumerated(EnumType.STRING)
    private EStatus homeworkStatus = EStatus.PROCEEDING;


    public HomeworkQuestions(HomeworkQuestionRequest request, Long userId, Bootcamp bootcamp, List<SkillSet> skillSetList) {
        this.userId = userId;
        this.bootcamp = bootcamp;
        this.homeworkQuestionStartDate = request.getHomeworkQuestionStartDate();
        this.homeworkQuestionEndDate = request.getHomeworkQuestionEndDate();
        this.homeworkQuestionTitle = request.getHomeworkQuestionTitle();
        this.homeworkQuestionContent = request.getHomeworkQuestionContent();
        this.homeworkQuestionImage = request.getHomeworkQuestionImage();
        this.skillSetList = skillSetList;
    }
}
