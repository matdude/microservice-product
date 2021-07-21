package com.microservice.product.service;

import com.microservice.product.domain.model.Product;
import com.microservice.product.domain.model.ProductDto;
import com.microservice.product.domain.repository.ProductRepository;
import com.microservice.product.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final static ProductMapper mapper = ProductMapper.INSTANCE;
    private final ProductRepository repository;

    public List<ProductDto> getProducts() {
        return repository.findAll()
                .stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }

    public Optional<ProductDto> getProduct(Long creditId) {
        return repository.findById(creditId)
                .map(mapper::mapToDto);
    }

    public ProductDto createProduct(final ProductDto productDto) {
        Product product = mapper.mapTo(productDto);
        repository.save(product);
        return mapper.mapToDto(product);
    }
}
