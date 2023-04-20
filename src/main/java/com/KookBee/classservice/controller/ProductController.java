package com.KookBee.classservice.controller;

import com.KookBee.classservice.domain.request.ProductRequest;
import com.KookBee.classservice.domain.response.OfferProductResponse;
import com.KookBee.classservice.domain.response.RentalProductResponse;
import com.KookBee.classservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @PostMapping
    public String postProduct(@RequestBody ProductRequest productRequest){
        return productService.postProductService(productRequest);
    }



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
