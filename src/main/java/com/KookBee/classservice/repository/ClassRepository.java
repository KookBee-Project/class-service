package com.KookBee.classservice.repository;

import com.KookBee.classservice.domain.entity.Classes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository <Classes,Long> {

}
