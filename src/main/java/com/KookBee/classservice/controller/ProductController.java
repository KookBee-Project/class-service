package com.KookBee.classservice.controller;

import com.KookBee.classservice.domain.entity.Bootcamp;
import com.KookBee.classservice.domain.entity.Product;
import com.KookBee.classservice.domain.entity.StudentBootcamp;
import com.KookBee.classservice.domain.request.ProductItemsRequest;
import com.KookBee.classservice.domain.request.ProductRequest;
import com.KookBee.classservice.domain.request.PutProductItemsRequest;
import com.KookBee.classservice.domain.response.*;
import com.KookBee.classservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    // 물품 제공 및 대여 서비스 등록
    @PostMapping
    public String postProduct(@RequestBody ProductRequest productRequest){
        return productService.postProductService(productRequest);
    }

    // Manager 클래스 내역 조회
    @GetMapping("/bootcamplist")
    public List<ManagerBootcampListResponse> getManagerBootcampList(){
        return productService.getManagerBootcampList();
    }

    // Manager 물품 등록하기
    @PostMapping("/productitems")
    public String postProductItems(@RequestBody ProductItemsRequest request){
        return productService.postProductItems(request);
    }

    // Manager 등록된 물품 조회
    @GetMapping("/productlist/{campusName}")
    public List<ProductItemsResponse> getProductItems(@PathVariable("campusName") String campusName){
        return productService.getProductItems(campusName);
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

    // Student List 조회
    @GetMapping("/studentlist/{bootcampId}")
    public List<StudentListResponse> getStudentList(@PathVariable("bootcampId") Long bootcampId){
        return productService.getStudentList(bootcampId);
    }

    // BootcampID -> CampusId -> CampusName -> 등록된 물품 조회
    @GetMapping("/productitemlist/{bootcampId}")
    public List<ProductListResponse> getProductItemList(@PathVariable("bootcampId") Long bootcampId){
        return productService.getProductItemList(bootcampId);
    }

    // ProductItemsId -> ProductItemCount 조회
    @GetMapping("/productitemcount/{productItemId}")
    public Integer getProductItemCount(@PathVariable("productItemId") Long productItemId){
        return productService.getProductItemCount(productItemId);
    }

    // BootcampId -> bootcampTitle 호출
    @GetMapping("/bootcamptitle/{bootcampId}")
    public String getBootcampTitle(@PathVariable("bootcampId") Long bootcampId){
        return productService.getBootcampTitle(bootcampId);
    }

    // BootcampId -> ProductResponse 호출
    @GetMapping("/product/{bootcampId}")
    public List<ProductResponse> getPublic(@PathVariable("bootcampId") long bootcampId){
        return productService.getProduct(bootcampId);
    }

    // productItemId -> productItemName 호출
    @GetMapping("/productItemName/{productItemId}")
    public String getProductItemName(@PathVariable("productItemId") Long productItemId){
        return productService.getProductItemName(productItemId);
    }

    // 등록시 수량 차감
    @PutMapping("/putproductitemcounts")
    public String putProductItemCounts(@RequestBody PutProductItemsRequest request){
        return productService.putProductItemCounts(request);
    }
}