package com.microservices.productservice.mapping;


import com.microservices.productservice.dto.ProductDto;
import com.microservices.productservice.model.Product;
import org.modelmapper.ModelMapper;

public class EntityToDtoMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static ProductDto mapEntityToDto(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }
}
