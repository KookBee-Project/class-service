package com.KookBee.classservice.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter

public class StudentBootcamp {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_bootcamp_id")
    private Long id;
    private Long studentId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bootcamp_id")
    private Bootcamp bootcamp;
    // 일단 제거 private String studentClassAttendance;
    //총 출석일
    //현제 출석일
    private String studentClassStatus;

//    public StudentClass(Classes classes){
//        this.classId = classes.getId();
//    }
}