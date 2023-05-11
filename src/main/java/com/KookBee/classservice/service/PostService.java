package com.KookBee.classservice.service;

import com.KookBee.classservice.client.UserServiceClient;
import com.KookBee.classservice.domain.dto.PostDTO;
import com.KookBee.classservice.domain.entity.Bootcamp;
import com.KookBee.classservice.domain.entity.Post;
import com.KookBee.classservice.domain.enums.EPostType;
import com.KookBee.classservice.domain.enums.EStatus;
import com.KookBee.classservice.domain.request.PostCreateRequest;
import com.KookBee.classservice.domain.request.PostEditRequest;
import com.KookBee.classservice.domain.request.PostUpdatePostTypeRequest;
import com.KookBee.classservice.domain.response.notification.PostDetailResponse;
import com.KookBee.classservice.domain.response.notification.PostListResponse;
import com.KookBee.classservice.repository.BootcampRepository;
import com.KookBee.classservice.repository.PostRepository;
import com.KookBee.classservice.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final BootcampRepository bootcampRepository;
    private final JwtService jwtService;
    private final UserServiceClient userServiceClient;

    public PostDetailResponse createPost (PostCreateRequest request) { //QNA NOTIFICATION 둘다 이걸로 생성
//        Long userId = 1L ; //로그인 귀찮아서 테스트용
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        PostDTO dto = new PostDTO(request);
        Post post = new Post(dto, userId);
        String userName = userServiceClient.getUserById(post.getWriterId()).getUserName();
        return new PostDetailResponse(postRepository.save(post),userName);
    }
    public PostDetailResponse findOnePost(Long postId) { // QNA NOTIFICATION 둘다 이걸로
        Post post = postRepository.findById(postId).orElse(null);
        assert post != null;
        String userName = userServiceClient.getUserById(post.getWriterId()).getUserName();
        post.incrementViewCount();

        return new PostDetailResponse(postRepository.save(post), userName);

    }

    public List<PostListResponse> findAllPostByPostType(Long bootcampId, EPostType postType) {
        // 일단 EPostType이 제공된 postType 인 에들만 찾아오기
        Optional<Bootcamp> bootcamp = bootcampRepository.findById(bootcampId);
        List<Post> post =  postRepository.findAllByBootcampAndPostTypeAndStatusNot(bootcamp.orElse(null),postType, EStatus.DELETED);
        return post.stream().map(el ->
                        new PostListResponse(el,
                                userServiceClient.getUserById(el.getWriterId()).getUserName(),
                                (long) el.getCommentList().size()))
                .toList();
    }

    public PostDetailResponse deletePost(Long postId) { //이것도 둘다 사용 가능
        Long userId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        Post post  = postRepository.findById(postId).orElse(null);
        assert post != null;
        if (Objects.equals(post.getWriterId(), userId)) {
            return new PostDetailResponse(
                    postRepository.save(post.updateStatus(EStatus.DELETED)));

        }
        else
            return null;
    }
    public String updatePostType(Long id, PostUpdatePostTypeRequest request) { // 사용할일이 없을듯?
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
    public String updatePost(Long id, PostEditRequest request){ // 이것도 둘다
        Post findByIdPost = postRepository.findById(id).orElse(null);
        assert findByIdPost != null;
        postRepository.save(findByIdPost.updatePost(request));
        return "포스트 변경완료";
    }


}
