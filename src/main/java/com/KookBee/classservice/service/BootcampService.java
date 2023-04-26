package com.KookBee.classservice.service;

import com.KookBee.classservice.client.Campus;
import com.KookBee.classservice.client.UserServiceClient;
import com.KookBee.classservice.domain.dto.BootcampDTO;
import com.KookBee.classservice.domain.entity.Bootcamp;
import com.KookBee.classservice.domain.entity.Curriculum;
import com.KookBee.classservice.domain.entity.StudentBootcamp;
import com.KookBee.classservice.domain.enums.EStatus;
import com.KookBee.classservice.domain.request.BootcampEditRequest;
import com.KookBee.classservice.domain.request.BootcampInsertRequest;
import com.KookBee.classservice.domain.request.BootcampStatusChangeRequest;
import com.KookBee.classservice.domain.response.ManagerBootcampListResponse;
import com.KookBee.classservice.domain.response.TeacherBootcampListResponse;
import com.KookBee.classservice.repository.BootcampRepository;
import com.KookBee.classservice.repository.CurriculumRepository;
import com.KookBee.classservice.repository.StudentBootcampRepository;
import com.KookBee.classservice.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BootcampService {
    private final BootcampRepository bootcampRepository;
    private final CurriculumRepository curriculumRepository;
    private final UserServiceClient userServiceClient;
    private final StudentBootcampRepository studentBootcampRepository;
    private final JwtService jwtService;

    public Bootcamp createClass(BootcampInsertRequest request) {
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        StringBuilder enterCode = new StringBuilder();
        for (int i = 1;i<=10;i++){
            char ch;
            if(i<=6){
                ch = (char) ((Math.random() * 26) + 65);
            }else {
                ch = (char) ((Math.random() * 10) + 48);
            }
            enterCode.append(Character.toString(ch));
        }
        BootcampDTO dto = new BootcampDTO(request, enterCode.toString());
        Bootcamp bootcamp = new Bootcamp(dto, userId);
        return bootcampRepository.save(bootcamp);

    }

    public String updateBootcampStatus(Long bootcampId) {
        // 바꿔줘야 하는 아이
        Optional<Bootcamp> findById = bootcampRepository.findById(bootcampId);
        Bootcamp bootcamp = findById.orElseThrow(NullPointerException::new);
        bootcampRepository.save(bootcamp.updateStatus(EStatus.DELETED));
        return bootcamp.getBootcampStatus().name() + "변경됨";
    }

    public Bootcamp updateBootcamp(BootcampEditRequest request) {
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        Bootcamp bootcamp = bootcampRepository.findById(request.getId()).orElse(null);
        assert bootcamp != null;
        bootcampRepository.save(bootcamp.updateBootcamp(request, userId));
        return bootcamp;
    }

    public List<ManagerBootcampListResponse> getBootcampByManagerId() {
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        List<Bootcamp> bootcampList = bootcampRepository.findByManagerId(userId);
        List<ManagerBootcampListResponse> response = bootcampList.stream().map(el -> {
            Campus campusName = userServiceClient.getCampusById(el.getCampusId());
            return new ManagerBootcampListResponse(el, campusName.getCampusName());
        }).toList().stream().filter(el -> el.getCurriculumStatus().equals(EStatus.PROCEEDING)).collect(Collectors.toList());
        return response;
    }

    public List<TeacherBootcampListResponse> getBootcampByTeacherId() {
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
//        if(jwtService.isValidTokens()){
//            try{
                List<Bootcamp> allByTeacherId = bootcampRepository.findAllByTeacherId(userId);
                List<TeacherBootcampListResponse> bootcampList = allByTeacherId.stream().map(bootcamp -> {
                    String campusName = userServiceClient.getCampusById(bootcamp.getCampusId()).getCampusName();
                    Integer studentCount = studentBootcampRepository.countByBootcamp(bootcamp);
                    return new TeacherBootcampListResponse(bootcamp, campusName, studentCount);
                }).collect(Collectors.toList());
                return bootcampList;
//            } catch (Exception e) {
//                return null;
//            }
//        }
//        return null;
    }

    public Bootcamp getBootcampById(Long bootcampId) {
        Optional<Bootcamp> findById = bootcampRepository.findById(bootcampId);
        Bootcamp bootcamp = findById.orElseThrow(NullPointerException::new);
        return bootcamp;
    }
}
