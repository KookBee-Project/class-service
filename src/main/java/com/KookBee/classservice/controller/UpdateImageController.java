package com.KookBee.classservice.controller;

import com.KookBee.classservice.domain.request.FileDownRequest;
import com.KookBee.classservice.domain.request.FileRequest;
import com.KookBee.classservice.service.FileTestService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/class/upload")
@RequiredArgsConstructor
public class UpdateImageController {

    private final FileTestService testService;
    @PostMapping("")
    public ResponseEntity<Void> updateMemberInfo(FileRequest dto) throws IOException {

        testService.updateMemberInfo(dto);

        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public String downloadFile(@PathVariable Long id) {
        return testService.downloadFile(id);

    }
}
