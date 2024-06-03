package com.daniel.backend.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.daniel.backend.dtos.ProductRecordDTO;
import com.daniel.backend.mappers.ProductMapper;
import com.daniel.backend.models.ProductEntity;
import com.daniel.backend.repositories.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    public ProductRecordDTO createProduct(ProductRecordDTO productRecordDTO) {
        ProductEntity productEntity = productMapper.toEntity(productRecordDTO);
        ProductEntity productEntity2 = productRepository.save(productEntity);
        return productMapper.toDto(productEntity2);
    }

    public List<ProductRecordDTO> getProduct() {
        List<ProductEntity> products = productRepository.findAll();
        if(products.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Nenhum produto cadastrado no momenot");
        return products.stream().map(productMapper::toDto).collect(Collectors.toList());
    }

    public ProductRecordDTO getById(Long id) {
        Optional<ProductEntity> product = productRepository.findById(id);
        if(product.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Nenhum produto cadastrado no momento com este ID");
        return productMapper.toDto(product.get());
    }

    public ProductRecordDTO updateProduct(Long id, ProductRecordDTO productRecordDTO) {
        Optional<ProductEntity> product = productRepository.findById(id);
        if(product.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Nenhum produto cadastrado no momento com este ID");
        ProductEntity productEntity = productMapper.toEntity(productRecordDTO);
        productEntity.setId(id);
        ProductEntity updateProduct = productRepository.save(productEntity);
        return productMapper.toDto(updateProduct);
    }

    public ProductRecordDTO deleteProduct(Long id) {
        Optional<ProductEntity> product = productRepository.findById(id);
        if(product.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Nenhum produto cadastrado no momento com este ID");
        productRepository.delete(product.get());
        return productMapper.toDto(product.get());
    }
}
