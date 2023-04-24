package com.KookBee.classservice.domain.entity;

import com.KookBee.classservice.domain.dto.DayOffApplyDTO;
import com.KookBee.classservice.domain.enums.EDayOffStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DayOff {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "day_off_id")
    private Long id;
    private Long userId; // 휴가 신청자의 Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curriculum_id")
    private Curriculum curriculum; // 매니저,강사,학생의 연결요소
    private LocalDate startDate;
    private LocalDate endDate;
    private String reason; // 휴가 신청사유
    private Integer days; // 휴가 사용일수
    @Enumerated(EnumType.STRING)
    private EDayOffStatus managerApproval; // 매니저 승인여부
    @Enumerated(EnumType.STRING)
    private EDayOffStatus teacherApproval; // 강사 승인여부
    @Enumerated(EnumType.STRING)
    private EDayOffStatus status; // 휴가상태 - 매니저와 강사의 결정에 따라 결정

    public DayOff(DayOffApplyDTO dto) {
        this.userId = dto.getUserId();
        this.curriculum = dto.getCurriculum();
        this.startDate = dto.getStartDate();
        this.endDate = dto.getEndDate();
        this.reason = dto.getReason();
        this.days = dto.getDays();
        this.managerApproval = dto.getManagerApproval();
        this.teacherApproval = dto.getTeacherApproval();
        this.status = dto.getStatus();
    }
}
