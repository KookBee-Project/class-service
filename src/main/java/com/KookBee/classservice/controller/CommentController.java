package com.KookBee.classservice.controller;

import com.KookBee.classservice.domain.entity.Comment;
import com.KookBee.classservice.domain.request.CommentCreateRequest;
import com.KookBee.classservice.domain.response.CommentResponse;
import com.KookBee.classservice.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    @PostMapping("/{postId}")
    public CommentResponse createComment (@PathVariable Long postId, @RequestBody CommentCreateRequest request) {
        return commentService.createComment(request, postId);
    }
}
