package com.KookBee.classservice.domain.dto;

import com.KookBee.classservice.domain.entity.Curriculum;
import com.KookBee.classservice.domain.enums.EDayOffStatus;
import com.KookBee.classservice.domain.request.DayOffApplyRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class DayOffApplyDTO {
    private Long userId; // 휴가 신청자의 Id
    private Curriculum curriculum; // 매니저,강사,학생의 연결요소
    private LocalDate startDate;
    private LocalDate endDate;
    private String reason; // 휴가 신청사유
    private Integer days; // 휴가 사용일수
    private EDayOffStatus managerApproval; // 매니저 승인여부
    private EDayOffStatus teacherApproval; // 강사 승인여부
    private EDayOffStatus status;

    public DayOffApplyDTO(DayOffApplyRequest request, Long userId, Long curriculumId) {
        this.userId = userId;
        this.curriculum = new Curriculum(curriculumId);
        this.startDate = LocalDate.parse(request.getDayOffStartDate(),
                DateTimeFormatter.ISO_DATE);
        this.endDate = LocalDate.parse(request.getDayOffEndDate(),
                DateTimeFormatter.ISO_DATE);
        this.reason = request.getDayOffReason();
        // 시작일과 종료일의 차이일을 계산하여 반환
        this.days = Math.toIntExact(ChronoUnit.DAYS.between(startDate, endDate))+1;
        this.managerApproval = EDayOffStatus.PENDING;
        this.teacherApproval = EDayOffStatus.PENDING;
        this.status = EDayOffStatus.PENDING;
    }
}
