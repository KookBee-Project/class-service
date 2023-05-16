package com.KookBee.classservice.repository;

import com.KookBee.classservice.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    @Query("select count(c) from Comment c where c.post.id = :postId")
    Integer answerCount(@Param("postId") Long postId);
  
}



