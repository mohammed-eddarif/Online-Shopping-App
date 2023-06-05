package com.microservices.productservice.controller;

import com.microservices.productservice.dto.ProductDto;
import com.microservices.productservice.request.ProductRequest;
import com.microservices.productservice.response.ProductResponse;
import com.microservices.productservice.service.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private ProductServiceImpl productServiceImpl;

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public ProductResponse createProduct(@RequestBody ProductRequest productRequest){
//        ProductDto productDto = new ProductDto();
//        BeanUtils.copyProperties(productRequest, productDto);
//
//        ProductDto productDto1 = productService.createProduct(productDto);
//
//        ProductResponse productResponse = new ProductResponse().builder()
//                .name(productDto1.getName())
//                .description(productDto1.getDescription())
//                .price(productDto1.getPrice())
//                .build();
//
//        return productResponse;
//    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest) {
        try {
            ProductDto productDto = new ProductDto().builder()
                    .name(productRequest.getName())
                    .description(productRequest.getDescription())
                    .price(productRequest.getPrice())
                    .build();

            ProductDto createdProductDto = productServiceImpl.createProduct(productDto);

            ProductResponse productResponse = new ProductResponse().builder()
                    .name(createdProductDto.getName())
                    .description(createdProductDto.getDescription())
                    .price(createdProductDto.getPrice())
                    .build();

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(productResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productServiceImpl.getAllProducts();
    }
}
