package com.daniel.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daniel.backend.models.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity,Long>{
    
}
