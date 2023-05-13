package com.KookBee.classservice.controller;

import com.KookBee.classservice.domain.enums.EPostType;
import com.KookBee.classservice.domain.request.PostCreateRequest;
import com.KookBee.classservice.domain.request.PostEditRequest;
import com.KookBee.classservice.domain.request.PostUpdatePostTypeRequest;
import com.KookBee.classservice.domain.response.notification.PostDetailResponse;
import com.KookBee.classservice.domain.response.notification.PostListResponse;
import com.KookBee.classservice.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping
    public PostDetailResponse createNotificationPost(@RequestBody PostCreateRequest request) {
        return postService.createPost(request);
    }
    @GetMapping("/{postId}")
    public PostDetailResponse getPostDetail(@PathVariable("postId") Long postId){
        return postService.findOnePost(postId);

    }
    @GetMapping("/{bootcampId}/{postType}")
    public List<PostListResponse> getPostList(@PathVariable("bootcampId") Long id, @PathVariable("postType") EPostType postType) {
        return postService.findAllPostByPostType(id, postType);
    }
    @DeleteMapping("/{postId}")
    public PostDetailResponse deleteNotification(@PathVariable Long postId){
        return postService.deletePost(postId);
    }
    @PutMapping("/{postId}/status")
    public String changePostType(@PathVariable("postId") Long postId, @RequestBody PostUpdatePostTypeRequest request){
        return postService.updatePostType(postId, request);
    }
    @PutMapping("/{postId}")
    public String changePost(@PathVariable("postId")Long postId, @RequestBody PostEditRequest request){
        return postService.updatePost(postId,request);
    }
}
