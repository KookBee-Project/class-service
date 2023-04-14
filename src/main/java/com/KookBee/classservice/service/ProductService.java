package com.KookBee.classservice.service;


import com.KookBee.classservice.domain.entity.Product;
import com.KookBee.classservice.domain.request.ProductRequest;
import com.KookBee.classservice.repository.ProductRepository;
import com.KookBee.classservice.security.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    private final JwtService jwtService;
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
}
