package com.microservices.productservice.service;

import com.microservices.productservice.dto.ProductDto;
import com.microservices.productservice.model.Product;
import com.microservices.productservice.response.ProductResponse;

import java.util.List;


public interface ProductService {
    public ProductDto createProduct(ProductDto productDto);
    public List<ProductResponse> getAllProducts();

}
