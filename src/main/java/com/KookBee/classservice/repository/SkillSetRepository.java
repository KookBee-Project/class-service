package com.KookBee.classservice.repository;

import com.KookBee.classservice.domain.entity.SkillSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SkillSetRepository extends JpaRepository<SkillSet, Long> {
}
