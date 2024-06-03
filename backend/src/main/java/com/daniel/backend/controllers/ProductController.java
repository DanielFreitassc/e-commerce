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

import com.daniel.backend.dtos.ProductRecordDTO;
import com.daniel.backend.services.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    private ProductService productService;


    @PostMapping
    public ProductRecordDTO createProduct(@RequestBody @Valid ProductRecordDTO productRecordDTO) {
        return productService.createProduct(productRecordDTO);
    }

    @GetMapping
    public List<ProductRecordDTO> getProduct() {
        return productService.getProduct();
    }

    @GetMapping("{id}")
    public ProductRecordDTO getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @PutMapping("{id}")
    public ProductRecordDTO updateProduct(@PathVariable Long id,@RequestBody @Valid ProductRecordDTO productRecordDTO) {
        return productService.updateProduct(id, productRecordDTO);
    }

    @DeleteMapping("{id}")
    public ProductRecordDTO deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
 }
