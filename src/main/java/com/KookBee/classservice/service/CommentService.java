package com.KookBee.classservice.service;

import com.KookBee.classservice.domain.dto.CommentDTO;
import com.KookBee.classservice.domain.entity.Comment;
import com.KookBee.classservice.domain.entity.Post;
import com.KookBee.classservice.domain.request.CommentCreateRequest;
import com.KookBee.classservice.domain.response.CommentResponse;
import com.KookBee.classservice.repository.CommentRepository;
import com.KookBee.classservice.repository.PostRepository;
import com.KookBee.classservice.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final JwtService jwtService;

    public CommentResponse createComment(CommentCreateRequest request, Long postId) {
        Long userId =1L;
        //Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        Post findByIdPost = postRepository.findById(postId).orElse(null);
        assert findByIdPost != null;
        CommentDTO dto = new CommentDTO(request);
        Comment comment = new Comment(dto,userId,findByIdPost);
        commentRepository.save(comment);
        CommentResponse response = new CommentResponse(comment);
        return response;
    }

}
