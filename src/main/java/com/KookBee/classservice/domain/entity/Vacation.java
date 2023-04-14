package com.KookBee.classservice.domain.entity;

import com.KookBee.classservice.domain.dto.VacationApplyDTO;
import com.KookBee.classservice.domain.enums.EVacationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
    private LocalDate startDate;
    private LocalDate endDate;
    private String reason; // 휴가 신청사유
    private Integer days; // 휴가 사용일수
    private EVacationStatus managerApproval; // 매니저 승인여부
    private EVacationStatus teacherApproval; // 강사 승인여부
    private EVacationStatus status; // 휴가상태 - 매니저와 강사의 결정에 따라 결정

    public Vacation(VacationApplyDTO dto) {
        this.userId = dto.getUserId();
        this.curriculumId = dto.getCurriculumId();
        this.startDate = dto.getStartDate();
        this.endDate = dto.getEndDate();
        this.reason = dto.getReason();
        this.days = dto.getDays();
        this.managerApproval = dto.getManagerApproval();
        this.teacherApproval = dto.getTeacherApproval();
        this.status = dto.getStatus();
    }
}
