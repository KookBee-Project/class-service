package com.KookBee.classservice.service;

import com.KookBee.classservice.domain.entity.SkillSet;
import com.KookBee.classservice.repository.SkillSetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillSetService {

    private final SkillSetRepository skillSetRepository;

    public List<SkillSet> getSkillSetList() {
        return skillSetRepository.findAll();
    }
}
