package com.KookBee.classservice.repository;

import com.KookBee.classservice.domain.entity.Bootcamp;
import com.KookBee.classservice.domain.entity.Post;
import com.KookBee.classservice.domain.enums.EPostType;
import com.KookBee.classservice.domain.enums.EStatus;
import com.KookBee.classservice.domain.response.PostListResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findAllByBootcampAndPostTypeAndStatusNot(Bootcamp bootcamp, EPostType postType, EStatus status);
}
