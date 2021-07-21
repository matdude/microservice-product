package com.microservice.product.mapper;

import com.microservice.product.domain.model.Product;
import com.microservice.product.domain.model.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto mapToDto(Product product);

    Product mapTo(ProductDto productDto);
}
