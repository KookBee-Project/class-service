package com.KookBee.classservice.service;


import com.KookBee.classservice.domain.entity.Product;
import com.KookBee.classservice.domain.enums.EProductType;
import com.KookBee.classservice.domain.request.ProductRequest;
import com.KookBee.classservice.domain.response.OfferProductResponse;
import com.KookBee.classservice.domain.response.RentalProductResponse;
import com.KookBee.classservice.repository.ProductRepository;
import com.KookBee.classservice.security.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    private final JwtService jwtService;

    // Manager 물품 대여 및 제공 서비스 등록
    public String postProductService(ProductRequest productRequest) {
        Long managerId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        productRequest.setManagerId(managerId);
        Product product = new Product(productRequest);
        productRepository.save(product);
        if (product != null) {
            return "등록이 완료되었습니다.";
        } else {
            throw new RuntimeException("등록에 실패하였습니다.");
        }
    }

    // Student 물품 대여 및 제공 서비스 조회
    public List<OfferProductResponse> getOfferProductService(){
        Long studentId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        List<Product> product = productRepository.findByStudentIdAndProductType(studentId, EProductType.OFFER);
        List<OfferProductResponse> responses = product.stream()
                .map(OfferProductResponse::new)
                .collect(Collectors.toList());
        return responses;
    }
    public List<RentalProductResponse> getRentalProductService(){
        Long studentId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        List<Product> product = productRepository.findByStudentIdAndProductType(studentId, EProductType.RENTAL);
        List<RentalProductResponse> responses = product.stream()
                .map(RentalProductResponse::new)
                .collect(Collectors.toList());
        return responses;
    }
}
