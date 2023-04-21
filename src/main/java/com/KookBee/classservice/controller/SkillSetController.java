package com.KookBee.classservice.controller;

import com.KookBee.classservice.domain.entity.SkillSet;
import com.KookBee.classservice.service.SkillSetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/class/skill_set")
@RequiredArgsConstructor
public class SkillSetController {

    private final SkillSetService skillSetService;
    @GetMapping
    public List<SkillSet> getSkillSetList(){
        return skillSetService.getSkillSetList();
    }
}
