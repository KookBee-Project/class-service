package com.KookBee.classservice.service;

import com.KookBee.classservice.domain.dto.BootcampDTO;
import com.KookBee.classservice.domain.entity.Bootcamp;
import com.KookBee.classservice.domain.request.BootcampEditRequest;
import com.KookBee.classservice.domain.request.BootcampInsertRequest;
import com.KookBee.classservice.domain.request.BootcampStatusChangeRequest;
import com.KookBee.classservice.repository.BootcampRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BootcampService {
    private final BootcampRepository bootcampRepository;

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
}
