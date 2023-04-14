package com.KookBee.classservice.domain.dto;

import com.KookBee.classservice.domain.enums.EVacationStatus;
import com.KookBee.classservice.domain.request.VacationApplyRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class VacationApplyDTO {
    private Long userId; // 휴가 신청자의 Id
    private Long curriculumId; // 매니저,강사,학생의 연결요소
    private LocalDate startDate;
    private LocalDate endDate;
    private String reason; // 휴가 신청사유
    private Integer days; // 휴가 사용일수
    private EVacationStatus managerApproval; // 매니저 승인여부
    private EVacationStatus teacherApproval; // 강사 승인여부
    private EVacationStatus status;

    public VacationApplyDTO(VacationApplyRequest request, Long userId, Long curriculumId) {
        this.userId = userId;
        this.curriculumId = curriculumId;
        this.startDate = request.getStartDate();
        this.endDate = request.getEndDate();
        this.reason = request.getReason();
        // 시작일과 종료일의 차이일을 계산하여 반환
        this.days = Math.toIntExact(ChronoUnit.DAYS.between(startDate, endDate))+1;
        this.managerApproval = EVacationStatus.PENDING;
        this.teacherApproval = EVacationStatus.PENDING;
        this.status = EVacationStatus.PENDING;
    }
}
