package com.daniel.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.backend.dtos.ProductDto;
import com.daniel.backend.services.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ProductDto createProduct(@RequestBody @Valid ProductDto productRecordDTO) {
        return productService.createProduct(productRecordDTO);
    }

    @GetMapping
    public List<ProductDto> getProduct() {
        return productService.getProduct();
    }

    @GetMapping("{id}")
    public ProductDto getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @PutMapping("{id}")
    public ProductDto updateProduct(@PathVariable Long id,@RequestBody @Valid ProductDto productRecordDTO) {
        return productService.updateProduct(id, productRecordDTO);
    }

    @DeleteMapping("{id}")
    public ProductDto deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
 }
