package com.example.crud.cliente.dto;

import java.time.LocalDateTime;

public record ClienteResponseDTO(
        Long id,
        String nome,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        Boolean ativo
) {}
