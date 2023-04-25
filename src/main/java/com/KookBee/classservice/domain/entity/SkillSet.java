package com.KookBee.classservice.domain.entity;

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
public class SkillSet {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_set_id")
    private Long id;
    private String skillSetName;
    @JsonIgnore
    @OneToMany(mappedBy = "skillSet")
    private List<Curriculum> curriculumList;
    @JsonIgnore
    @OneToMany(mappedBy = "skillSet", fetch = FetchType.LAZY)
    private List<HomeworkQuestions> homeworkQuestionsList;

    public SkillSet(Long skillSetId) {
        this.id = skillSetId;
    }
}
