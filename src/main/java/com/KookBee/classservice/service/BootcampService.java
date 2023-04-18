package com.KookBee.classservice.service;

import com.KookBee.classservice.domain.dto.BootcampDTO;
import com.KookBee.classservice.domain.entity.Bootcamp;
import com.KookBee.classservice.domain.request.BootcampEditRequest;
import com.KookBee.classservice.domain.request.BootcampInsertrequest;
import com.KookBee.classservice.domain.request.ClassStatusChangeRequest;
import com.KookBee.classservice.repository.BootcampRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BootcampService {
    private final BootcampRepository bootcampRepository;

    public Bootcamp createClass(BootcampInsertrequest request) {
        BootcampDTO dto = new BootcampDTO(request);
        Bootcamp bootcamp = new Bootcamp(dto);
        return bootcampRepository.save(bootcamp);

    }

    public String updateClassStatus(ClassStatusChangeRequest request) {
        // 바꿔줘야 하는 아이
        Bootcamp bootcamp = bootcampRepository.findById(request.getClassId()).orElse(null);
        bootcampRepository.save(bootcamp.updateStatus(request.getEStatus()));
        return request.getEStatus().name() + "변경됨";
    }

    public Bootcamp updateClass(BootcampEditRequest request) {
        Bootcamp bootcamp = bootcampRepository.findById(request.getClassId()).orElse(null);
        bootcampRepository.save(bootcamp.updateClasses(request));
        return bootcamp;

    }
}
