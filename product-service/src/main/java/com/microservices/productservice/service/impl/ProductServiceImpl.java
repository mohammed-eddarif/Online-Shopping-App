package com.microservices.productservice.service.impl;

import com.microservices.productservice.dto.ProductDto;
import com.microservices.productservice.response.ProductResponse;
import com.microservices.productservice.model.Product;
import com.microservices.productservice.repository.ProductRepository;
import com.microservices.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductRepository productRepository;

    public ProductDto createProduct(ProductDto productDto) {
        Product product = Product.builder()
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .build();


        Product prod = productRepository.save(product);


        // using model map "mapping library ", or use builder to map objects manually give us the same result
        // , there are some benefits of every single one , check then on chatGPT conv.

//        ProductDto productDto1 = EntityToDtoMapper.mapEntityToDto(prod);
        ProductDto productDto1 = ProductDto.builder()
                .name(prod.getName())
                .description(prod.getDescription())
                .price(prod.getPrice())
                .build();

        log.info("Product {} is saved", productDto1.getId());

        return productDto1;
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

}
