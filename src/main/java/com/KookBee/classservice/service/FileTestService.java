package com.KookBee.classservice.service;

import com.KookBee.classservice.domain.entity.FileTest;
import com.KookBee.classservice.domain.request.FileDownRequest;
import com.KookBee.classservice.domain.request.FileRequest;
import com.KookBee.classservice.repository.FileRepository;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileTestService {

    private final FileRepository repository;
    private final Storage storage;
    @Value("${spring.cloud.gcp.storage.bucket}") // application.yml에 써둔 bucket 이름
    private String bucketName;

    // 회원 정보 수정
    public void updateMemberInfo(FileRequest request) throws IOException {

        // !!!!!!!!!!!이미지 업로드 관련 부분!!!!!!!!!!!!!!!
        String uuid = UUID.randomUUID().toString(); // Google Cloud Storage에 저장될 파일 이름
        String ext = request.getImage().getContentType(); // 파일의 형식 ex) JPG
        // Cloud에 이미지 업로드
        BlobInfo blobInfo = storage.create(
                BlobInfo.newBuilder(bucketName, uuid)
                        .setContentType(ext)
                        .build(),
                request.getImage().getInputStream()
        );
        FileTest fileTest = new FileTest(uuid);
        repository.save(fileTest);
    }

    public String downloadFile(Long id){
        FileTest fileTest = repository.findById(id).get();
        return "https://storage.googleapis.com/kookbee-test-strorage/" + fileTest.getImg();
    }
}
