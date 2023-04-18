package com.KookBee.classservice.service;

import com.KookBee.classservice.domain.dto.BootcampDTO;
import com.KookBee.classservice.domain.entity.Bootcamp;
import com.KookBee.classservice.domain.entity.Curriculum;
import com.KookBee.classservice.domain.request.BootcampEditRequest;
import com.KookBee.classservice.domain.request.BootcampInsertRequest;
import com.KookBee.classservice.domain.request.BootcampStatusChangeRequest;
import com.KookBee.classservice.repository.BootcampRepository;
import com.KookBee.classservice.repository.CurriculumRepository;
import com.KookBee.classservice.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BootcampService {
    private final BootcampRepository bootcampRepository;
    private final CurriculumRepository curriculumRepository;
    private final JwtService jwtService;

    public Bootcamp createClass(BootcampInsertRequest request) {
        BootcampDTO dto = new BootcampDTO(request);
        Bootcamp bootcamp = new Bootcamp(dto);
        return bootcampRepository.save(bootcamp);

    }

    public String updateBootcampStatus(BootcampStatusChangeRequest request) {
        // 바꿔줘야 하는 아이
        Bootcamp bootcamp = bootcampRepository.findById(request.getBootcampId()).orElse(null);
        assert bootcamp != null;
        bootcampRepository.save(bootcamp.updateStatus(request.getBootcampStatus()));
        return request.getBootcampStatus().name() + "변경됨";
    }

    public Bootcamp updateBootcamp(BootcampEditRequest request) {
        Bootcamp bootcamp = bootcampRepository.findById(request.getBootcampId()).orElse(null);
        assert bootcamp != null;
        bootcampRepository.save(bootcamp.updateBootcamp(request));
        return bootcamp;
    }

    public List<Bootcamp> getBootcampByTeacherId() {
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        if(jwtService.isValidTokens()){
            try{
                List<Curriculum> findByTeacherId = curriculumRepository.findAllByTeacherId(userId);
                Map<Long, Bootcamp> map = new HashMap<>();
                List<Bootcamp> bootcampList = findByTeacherId.stream().map(curriculum -> {
                    Bootcamp orDefault = map.getOrDefault(curriculum.getBootcamp(), null);
                    if(orDefault==null) {
                        orDefault = curriculum.getBootcamp();
                        map.put(curriculum.getBootcamp().getId(),orDefault);
                    }
                    return new Bootcamp(orDefault);
                }).toList();
                return bootcampList;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
