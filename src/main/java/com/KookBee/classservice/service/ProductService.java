package com.KookBee.classservice.service;


import com.KookBee.classservice.client.Campus;
import com.KookBee.classservice.client.User;
import com.KookBee.classservice.client.UserServiceClient;
import com.KookBee.classservice.domain.entity.Bootcamp;
import com.KookBee.classservice.domain.entity.Product;
import com.KookBee.classservice.domain.entity.ProductItems;
import com.KookBee.classservice.domain.entity.StudentBootcamp;
import com.KookBee.classservice.domain.enums.EProductType;
import com.KookBee.classservice.domain.request.ProductItemsRequest;
import com.KookBee.classservice.domain.request.ProductRequest;
import com.KookBee.classservice.domain.response.*;
import com.KookBee.classservice.repository.BootcampRepository;
import com.KookBee.classservice.repository.ProductItemsRepository;
import com.KookBee.classservice.repository.ProductRepository;
import com.KookBee.classservice.repository.StudentBootcampRepository;
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
    private final BootcampRepository bootcampRepository;
    private final JwtService jwtService;
    private final UserServiceClient userServiceClient;
    private final ProductItemsRepository productItemsRepository;
    private final StudentBootcampRepository studentBootcampRepository;

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

    // Manager - 부트캠프 리스트 조회
    public List<ManagerBootcampListResponse> getManagerBootcampList(){
        Long managerId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        List<Bootcamp> bootcamps= bootcampRepository.findByManagerId(managerId);
        List<ManagerBootcampListResponse> response = bootcamps.stream().map(el -> {
            Campus campusName = userServiceClient.getCampusById(el.getCampusId());
            return new ManagerBootcampListResponse(el, campusName.getCampusName());
        }).collect(Collectors.toList());
        return response;
    }

    // Manager - Product Item 등록
    public String postProductItems(ProductItemsRequest request){
        Long managerId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        request.setManagerId(managerId);
        ProductItems items = new ProductItems(request);
        productItemsRepository.save(items);
        return "등록이 완료되었습니다.";
    }

    // Manager - Product Items 조회
    public List<ProductItemsResponse> getProductItems(String campusName){
        Long managerId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        List<ProductItems> byCampusId = productItemsRepository.findByCampusNameAndManagerId(campusName, managerId);
        List<ProductItemsResponse> responses = byCampusId.stream().map(ProductItemsResponse::new).collect(Collectors.toList());
        return responses;
    }

    // Student 물품 제공 내역 조회
    public List<OfferProductResponse> getOfferProductService(){
        Long studentId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        List<Product> product = productRepository.findByStudentIdAndProductType(studentId, EProductType.OFFER);
        List<OfferProductResponse> responses = product.stream()
                .map(OfferProductResponse::new)
                .collect(Collectors.toList());
        return responses;
    }
    // Student 물품 대여 내역 조회
    public List<RentalProductResponse> getRentalProductService(){
        Long studentId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        List<Product> product = productRepository.findByStudentIdAndProductType(studentId, EProductType.RENTAL);
        List<RentalProductResponse> responses = product.stream()
                .map(RentalProductResponse::new)
                .collect(Collectors.toList());
        return responses;
    }

    // Student List 조회
    public List<StudentListResponse> getStudentList(Long bootcampId){
        Bootcamp bootcamp = new Bootcamp(bootcampId);
        List<StudentBootcamp> studentIdByBootcampId = studentBootcampRepository.findByBootcamp(bootcamp);
        List<StudentListResponse> responses = studentIdByBootcampId.stream().map(el->{
            User userById = userServiceClient.getUserById(el.getStudentId());
            return new StudentListResponse(el, userById);
        }).toList();
        return responses;
    }

    public List<ProductListResponse> getProductItemList(Long bootcampId){
        Bootcamp bootcamp = bootcampRepository.findCampusIdById(bootcampId);
        Long campusId = bootcamp.getCampusId();
        Campus campus = userServiceClient.getCampusById(campusId);
        Long managerId = jwtService.tokenToDTO(jwtService.getAccessToken()).getId();
        List<ProductItems> byCampusNameAndManagerId = productItemsRepository.findByCampusNameAndManagerId(campus.getCampusName(), managerId);
        List<ProductListResponse> responses = byCampusNameAndManagerId.stream().map(ProductListResponse::new).collect(Collectors.toList());
        return responses;
    }

    public Integer getProductItemCount(Long productItemId){
        Optional<ProductItems> byProductItemId = productItemsRepository.findById(productItemId);
        if(byProductItemId.isPresent()){
            Integer count = byProductItemId.get().getProductItemCounts();
            return count;
        }
        return null;
    }
}
