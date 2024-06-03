package com.daniel.backend.mappers;

import org.springframework.stereotype.Component;

import com.daniel.backend.dtos.ProductRecordDTO;
import com.daniel.backend.models.ProductEntity;

@Component
public class ProductMapper {
    public ProductRecordDTO toDto(ProductEntity productEntity) {
        return new ProductRecordDTO(
            productEntity.getId(),
            productEntity.getName(),
            productEntity.getPrice(),
            productEntity.getValidity(),
            productEntity.getDescription(),
            productEntity.getImage());
    }

    public ProductEntity toEntity(ProductRecordDTO productRecordDTO) {
        return ProductEntity.builder()
        .name(productRecordDTO.name())
        .price(productRecordDTO.price())
        .validity(productRecordDTO.validity())
        .description(productRecordDTO.description())
        .image(productRecordDTO.image())
        .build();
    }
    
}
