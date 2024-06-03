package com.daniel.backend.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductRecordDTO(
    Long id,
    @NotBlank(message = "Nome não pode ser um campo vazio ou nulo") String name,
    @NotNull(message = "Preço não pode ser nulo") Double price,
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "Validade não pode ser nula") LocalDate validity,
    @NotBlank(message = "Mensagem não pode ser um campo vazio ou nulo") String description,
    @NotBlank(message = "Imagem não pode ser um campo vazio ou nulo") String image
) {
    
}
