package com.KookBee.classservice.service;

import com.KookBee.classservice.domain.dto.PostDTO;
import com.KookBee.classservice.domain.entity.Bootcamp;
import com.KookBee.classservice.domain.entity.Post;
import com.KookBee.classservice.domain.enums.EPostType;
import com.KookBee.classservice.domain.enums.EStatus;
import com.KookBee.classservice.domain.request.PostCreateRequest;
import com.KookBee.classservice.domain.request.PostEditRequest;
import com.KookBee.classservice.domain.request.PostUpdatePostTypeRequest;
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
    public String deletePost(Long postId) {
        Optional<Post> deleteById = postRepository.findById(postId);
        Post post = deleteById.orElse(null);
        assert post != null;
        postRepository.save(post.updateStatus(EStatus.DELETED));
        return "삭제완료";
    }
    public String updatePostType(Long id, PostUpdatePostTypeRequest request) {
        Post findPostById = postRepository.findById(id).orElse(null);
        assert findPostById != null;
        String newPostType = request.getPostType();
        //이거 더 좋은방법이 없을지 생각해보자. post란게 새로 생길떄마다 코드를 추가해야 하니깐.
        if (newPostType.equals("QNA")) {
            postRepository.save(findPostById.updatePostType(EPostType.QNA));
            return "Q&A로 변경완료";
        }
        if (newPostType.equals("NOTIFICATION")) {
            postRepository.save(findPostById.updatePostType(EPostType.NOTIFICATION));
            return "공지사항으로 변경완료";
        }
        else {
            return "변경실패";
        }
    }
    public String updatePost(Long id, PostEditRequest request){
        Post findByIdPost = postRepository.findById(id).orElse(null);
        assert findByIdPost != null;
        postRepository.save(findByIdPost.updatePost(request));
        return "포스트 변경완료";
    }

}
