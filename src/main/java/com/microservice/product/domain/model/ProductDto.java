package com.microservice.product.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private int id;

    @NotNull
    private int creditId;

    @NotNull
    private String productName;

    @NotNull
    private int value;
}
