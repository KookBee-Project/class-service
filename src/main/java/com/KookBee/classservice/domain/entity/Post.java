package com.KookBee.classservice.domain.entity;

import com.KookBee.classservice.domain.dto.PostDTO;
import com.KookBee.classservice.domain.enums.EPostType;
import com.KookBee.classservice.domain.enums.EStatus;
import com.KookBee.classservice.domain.request.PostEditRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Post {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="post_id")
    private Long id;
    @Enumerated(EnumType.STRING)
    private EPostType postType;
    private String postTitle;
    private String postContent;
    private LocalDate postCreateAt;
    private Long writerId; //아이디로 이름을 가져오자...? 토큰으로 가져오면 될듯?
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bootcamp_id")
    private Bootcamp bootcamp; // 부트캠프 아이디 가져오기
    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
    private List<Comment> commentList;

    private String fileUUID; // uuid 만 저장
    @Enumerated(EnumType.STRING)
    private EStatus status = EStatus.PROCEEDING;
    private Long viewCount = 0L;

    public Post(PostDTO dto, Long userId, Bootcamp bootcamp) {
        this.postType = dto.getPostType();
        this.postTitle = dto.getPostTitle();
        this.postContent = dto.getPostContent();
        this.postCreateAt = LocalDate.now();
        this.bootcamp = bootcamp;
        this.writerId = userId;
        this.fileUUID = dto.getFileUUID();
    }
    public Post updateStatus(EStatus status){
        this.status = status;
        return this;
    }
    public Post updatePostType(EPostType postType){
        this.postType = postType;
        return this;
    }
    public Post updatePost(PostEditRequest request){
        this.postContent=request.getPostContent();
        this.postTitle=request.getPostTitle();
        return this;
    }
    public void incrementViewCount() {
        this.viewCount=viewCount+1;
    }
}

