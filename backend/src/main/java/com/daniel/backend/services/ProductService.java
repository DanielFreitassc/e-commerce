package com.daniel.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.daniel.backend.dtos.ProductDto;
import com.daniel.backend.mappers.ProductMapper;
import com.daniel.backend.models.ProductEntity;
import com.daniel.backend.repositories.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductDto createProduct(ProductDto productRecordDTO) {
        return productMapper.toDto(productRepository.save(productMapper.toEntity(productRecordDTO)));
    }

    public List<ProductDto> getProduct() {
        return productRepository.findAll().stream().map(productMapper::toDto).toList();
    }

    public ProductDto getById(Long id) {
        return productMapper.toDto(findProductOrThrow(id));
    }

    public ProductDto updateProduct(Long id, ProductDto productRecordDTO) {
        ProductEntity productEntity = findProductOrThrow(id);
        productMapper.updateEntity(productRecordDTO, productEntity);
        return productMapper.toDto(productRepository.save(productEntity));
    }

    public ProductDto deleteProduct(Long id) {
        productRepository.delete(findProductOrThrow(id));
        return productMapper.toDto(findProductOrThrow(id));
    }

    private ProductEntity findProductOrThrow(Long id) {
        Optional<ProductEntity> product = productRepository.findById(id);
        if(product.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Nenhum produto encontrado");
        return product.get();
    }
}
