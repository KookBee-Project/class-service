package com.KookBee.classservice.repository;

import com.KookBee.classservice.domain.entity.Bootcamp;
import com.KookBee.classservice.domain.entity.Post;
import com.KookBee.classservice.domain.enums.EPostType;
import com.KookBee.classservice.domain.enums.EStatus;
import com.KookBee.classservice.domain.response.PostListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findAllByBootcampAndPostTypeAndStatusNot(Bootcamp bootcamp, EPostType postType, EStatus status);

    @Query("select p from Post p where p.postType = :type and p.writerId = :userId " +
            "order by p.postCreateAt desc")
    List<Post> findMyQnA(@Param("type") EPostType type,
                         @Param("userId") Long userId);
}
