package com.microservices.productservice.service;

import com.microservices.productservice.dto.ProductDto;
import com.microservices.productservice.model.Product;
import com.microservices.productservice.repository.ProductRepository;
import com.microservices.productservice.service.impl.ProductServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productServiceImpl;

    @Test
    public void ProductService_CreateProduct_ReturnsProductDto() {
        Product product = Product.builder()
                .name("iphone11")
                .description("iphone11 green")
                .price("1200")
                .build();

        ProductDto productDto = ProductDto.builder()
                .name("iphone11")
                .description("iphone11 green")
                .price("1200")
                .build();

        // mock save function of product Repository object ,
        // it's the funct we use in create product function in product service
        // here we say that after every save of a product , just return the product object we created above
        when(productRepository.save(Mockito.any(Product.class))).thenReturn(product);

        // act
        ProductDto savedProduct = productServiceImpl.createProduct(productDto);

        //assert
        Assertions.assertThat(savedProduct).isNotNull();

    }
}
