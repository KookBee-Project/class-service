package com.KookBee.classservice.controller;

import com.KookBee.classservice.domain.request.ProductRequest;
import com.KookBee.classservice.domain.response.ManagerBootcampListResponse;
import com.KookBee.classservice.domain.response.OfferProductResponse;
import com.KookBee.classservice.domain.response.RentalProductResponse;
import com.KookBee.classservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;



    // Manager 클래스 내역 조회
    @GetMapping("/bootcamplist")
    public List<ManagerBootcampListResponse> getManagerBootcampList(){
        return productService.getManagerBootcampList();
    }

    @PostMapping
    public String postProduct(@RequestBody ProductRequest productRequest){
        return productService.postProductService(productRequest);
    }

    // Manager 상품 등록을 위한 캠퍼스 조회








    // Student 물품 제공 내역 조회
    @GetMapping("/offerproduct")
    public List<OfferProductResponse> getOfferProduct(){
        return productService.getOfferProductService();
    }
    // Student 물품 대여 내역 조회
    @GetMapping("/rentalproduct")
    public List<RentalProductResponse> getRentalProduct(){
        return productService.getRentalProductService();
    }
}
