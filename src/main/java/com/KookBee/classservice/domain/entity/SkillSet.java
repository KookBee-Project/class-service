package com.KookBee.classservice.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SkillSet {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skillset_id")
    private Long id;
    private String skillSetName;
    @OneToMany(mappedBy = "skillSet")
    private List<Curriculum> curriculumList;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "homework_question_id")
    private HomeworkQuestions homeworkQuestions;

    public SkillSet(Long skillSetId) {
        this.id = skillSetId;
    }
}
