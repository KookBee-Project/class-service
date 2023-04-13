package com.KookBee.classservice.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter

public class StudentClass {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_class_id")
    private Long id;
    private Long studentId;
    private Long classId;
    // 일단 제거 private String studentClassAttendance;
    //총 출석일
    //현제 출석일
    private String studentClassStatus;
}
