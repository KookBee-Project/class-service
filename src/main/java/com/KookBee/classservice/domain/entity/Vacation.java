package com.KookBee.classservice.domain.entity;

import com.KookBee.classservice.domain.enums.EVacationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Vacation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacation_id")
    private Long id;
    private Long userId; // 휴가 신청자의 Id
    private Long curriculumId; // 매니저,강사,학생의 연결요소
    private String startDate;
    private String endDate;
    private Integer days; // 휴가 사용일수
    private EVacationStatus managerApproval; // 매니저 승인여부
    private EVacationStatus teacherApproval; // 강사 승인여부
    private EVacationStatus status; // 휴가상태/
}
