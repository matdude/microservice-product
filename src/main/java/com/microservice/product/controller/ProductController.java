package com.microservice.product.controller;

import com.microservice.product.domain.model.ProductDto;
import com.microservice.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/v1/product")
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductDto> getProducts() {
        List<ProductDto> products = productService.getProducts();
        return products;
    }

    @GetMapping("/{creditId")
    public ResponseEntity<ProductDto> getProducts(@PathVariable Long creditId) {
        return productService.getProduct(creditId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProductDto createProduct(@RequestBody @Valid ProductDto productDto) {
        return productService.createProduct(productDto);
    }
}
