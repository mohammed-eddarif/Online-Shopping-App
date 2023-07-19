package com.microservices.productservice.controller;

import com.microservices.productservice.dto.ProductDto;
import com.microservices.productservice.dto.ProductRequestDto;
import com.microservices.productservice.dto.ProductResponseDto;
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
//    public ProductResponseDto createProduct(@RequestBody ProductRequestDto productRequest){
//        ProductDto productDto = new ProductDto();
//        BeanUtils.copyProperties(productRequest, productDto);
//
//        ProductDto productDto1 = productService.createProduct(productDto);
//
//        ProductResponseDto productResponse = new ProductResponseDto().builder()
//                .name(productDto1.getName())
//                .description(productDto1.getDescription())
//                .price(productDto1.getPrice())
//                .build();
//
//        return productResponse;
//    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductRequestDto productRequestDto) {
        try {
            ProductDto productDto = new ProductDto().builder()
                    .name(productRequestDto.getName())
                    .description(productRequestDto.getDescription())
                    .price(productRequestDto.getPrice())
                    .build();

            ProductDto createdProductDto = productServiceImpl.createProduct(productDto);

            ProductResponseDto productResponseDto = new ProductResponseDto().builder()
                    .name(createdProductDto.getName())
                    .description(createdProductDto.getDescription())
                    .price(createdProductDto.getPrice())
                    .build();

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(productResponseDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponseDto> getAllProducts() {
        return productServiceImpl.getAllProducts();
    }
}
