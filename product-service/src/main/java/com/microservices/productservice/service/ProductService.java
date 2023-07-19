package com.microservices.productservice.service;

import com.microservices.productservice.dto.ProductDto;
import com.microservices.productservice.dto.ProductResponseDto;

import java.util.List;


public interface ProductService {
    public ProductDto createProduct(ProductDto productDto);
    public List<ProductResponseDto> getAllProducts();

}
