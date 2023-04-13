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
    @OneToMany
    private List<Curriculum> curriculumList;
}
