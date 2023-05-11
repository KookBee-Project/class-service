package com.KookBee.classservice.controller;

import com.KookBee.classservice.domain.request.CommentCreateRequest;
import com.KookBee.classservice.domain.response.CommentResponse;
import com.KookBee.classservice.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/class/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    @PostMapping("/{postId}")
    public CommentResponse createComment ( @RequestBody CommentCreateRequest request, @PathVariable Long postId) {
        return commentService.createComment(request, postId);
    }
}
