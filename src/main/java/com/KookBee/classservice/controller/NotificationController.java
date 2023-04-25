package com.KookBee.classservice.controller;

import com.KookBee.classservice.domain.entity.Post;
import com.KookBee.classservice.domain.enums.EPostType;
import com.KookBee.classservice.domain.request.PostCreateRequest;
import com.KookBee.classservice.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class/notification")
@RequiredArgsConstructor
public class NotificationController {
    private final PostService postService;

    @PostMapping
    public Post createNotificationPost(@RequestBody PostCreateRequest request) {
        return postService.createPost(request);
    }
    @GetMapping("/{postId}")
    public Post getPostDetail(@PathVariable("postId") Long postId){
        return postService.findOnePost(postId);

    }
    @GetMapping("/{bootcampId}/{postType}")
    public List<Post> getPostList(@PathVariable("bootcampId") Long id,@PathVariable("postType") EPostType postType) {
        return postService.findAllNotificationPost(id, postType);

    }
    @DeleteMapping("/delete}")
    public void deleteNotification(PostDeleteRequest request){

    }

}
