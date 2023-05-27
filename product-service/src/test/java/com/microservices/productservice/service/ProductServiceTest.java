package com.microservices.productservice.service;

import com.microservices.productservice.model.Product;
import com.microservices.productservice.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    public void ProductService_CreateProduct_ReturnsProductDto(){
        Product product = Product.builder()
                .name("iphone11")
                .description("iphone11 green")
                .price("1200")
                .build();


    }
}
