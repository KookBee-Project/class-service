package com.KookBee.classservice.domain.request;

import com.KookBee.classservice.domain.entity.Classes;
import com.KookBee.classservice.domain.entity.SkillSet;
import com.KookBee.classservice.domain.enums.EStatus;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class HomeworkQuestionRequest {
    private Long classesId;
    private String homeworkQuestionStartDate;
    private String homeworkQuestionEndDate;
    private String homeworkQuestionTitle;
    private String homeworkQuestionContent;
    private String homeworkQuestionImage;
    private List<Long> skillSetIdList;
}
