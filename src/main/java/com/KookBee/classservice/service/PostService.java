package com.KookBee.classservice.service;

import com.KookBee.classservice.domain.dto.PostDTO;
import com.KookBee.classservice.domain.entity.Bootcamp;
import com.KookBee.classservice.domain.entity.Post;
import com.KookBee.classservice.domain.enums.EPostType;
import com.KookBee.classservice.domain.request.PostCreateRequest;
import com.KookBee.classservice.repository.BootcampRepository;
import com.KookBee.classservice.repository.PostRepository;
import com.KookBee.classservice.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final BootcampRepository bootcampRepository;
    private final JwtService jwtService;

    public Post createPost (PostCreateRequest request) {
        Long userId = 1L ; //로그인 귀찮아서 테스트용
//        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        PostDTO dto = new PostDTO(request);
        Post post = new Post(dto, userId);
        return postRepository.save(post);
    }
    public Post findOnePost(Long postId) {
        return postRepository.findById(postId).orElse(null);

    }

    public List<Post> findAllNotificationPost(Long bootcampId, EPostType postType) {
        // 일단 EPostType이 노티피케이션인 에들만 찾아오기
        // 그 후 클래스 아이디도 찾아서 해야하지 않을까???
        Optional<Bootcamp> bootcamp = bootcampRepository.findById(bootcampId);

        return postRepository.findAllByBootcampAndPostType(bootcamp.orElse(null),postType);
    }

}
