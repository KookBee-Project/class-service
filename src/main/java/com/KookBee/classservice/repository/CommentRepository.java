package com.KookBee.classservice.repository;

import com.KookBee.classservice.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> { }
