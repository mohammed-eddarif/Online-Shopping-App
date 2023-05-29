package com.microservices.productservice;


import com.microservices.productservice.dto.ProductDto;
import com.microservices.productservice.model.Product;
import org.modelmapper.ModelMapper;

public class EntityToDtoMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static ProductDto mapEntityToDto(Product product) {
        if(product != null){
        return modelMapper.map(product, ProductDto.class);
        }else return null;
    }
}
