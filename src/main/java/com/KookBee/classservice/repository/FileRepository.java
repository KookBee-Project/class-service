package com.KookBee.classservice.repository;

import com.KookBee.classservice.domain.entity.FileTest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileTest,Long> {
}
