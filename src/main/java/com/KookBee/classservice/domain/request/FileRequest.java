package com.KookBee.classservice.domain.request;

import lombok.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class FileRequest {
    private MultipartFile image; //!!!!!!!!!이미지 업로드 관련 부분
}
