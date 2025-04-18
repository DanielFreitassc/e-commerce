package com.daniel.backend.mappers;

import org.springframework.stereotype.Component;

import com.daniel.backend.dtos.ProductDto;
import com.daniel.backend.models.ProductEntity;

@Component
public class ProductMapper {
    public ProductDto toDto(ProductEntity productEntity) {
        return new ProductDto(
            productEntity.getId(),
            productEntity.getName(),
            productEntity.getPrice(),
            productEntity.getValidity(),
            productEntity.getDescription(),
            productEntity.getImage());
    }

    public ProductEntity toEntity(ProductDto productRecordDTO) {
        return ProductEntity.builder()
        .name(productRecordDTO.name())
        .price(productRecordDTO.price())
        .validity(productRecordDTO.validity())
        .description(productRecordDTO.description())
        .image(productRecordDTO.image())
        .build();
    }

    public ProductEntity updateEntity(ProductDto productRecordDTO, ProductEntity productEntity) {
        if (productRecordDTO.name() != null) {
            productEntity.setName(productRecordDTO.name());
        }
        if (productRecordDTO.price() != null) {
            productEntity.setPrice(productRecordDTO.price());
        }
        if (productRecordDTO.validity() != null) {
            productEntity.setValidity(productRecordDTO.validity());
        }
        if (productRecordDTO.description() != null) {
            productEntity.setDescription(productRecordDTO.description());
        }
        if (productRecordDTO.image() != null) {
            productEntity.setImage(productRecordDTO.image());
        }
        return productEntity;
    }
    
}
