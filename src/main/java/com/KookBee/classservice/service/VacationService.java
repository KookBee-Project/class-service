package com.KookBee.classservice.service;

import com.KookBee.classservice.domain.dto.VacationApplyDTO;
import com.KookBee.classservice.domain.entity.Vacation;
import com.KookBee.classservice.domain.request.VacationApplyRequest;
import com.KookBee.classservice.repository.VacationRepository;
import com.KookBee.classservice.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VacationService {
    private final VacationRepository vacationRepository;
    private final JwtService jwtService;

    public Vacation vacationApply(VacationApplyRequest request, Long curriculumId){
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
//        Optional<Vacation> byCurriculumName
//                = vacationRepository.findByCurriculumName(curriculumId);
//        Vacation vacation = byCurriculumName.orElse(null);
        VacationApplyDTO dto = new VacationApplyDTO(request,userId, curriculumId);
        return vacationRepository.save(new Vacation(dto));
    }
}
