package com.example.crud.dto.response;

import java.time.LocalDateTime;

public record ClienteResponseDTO(
        Long id,
        String nome,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        Boolean ativo
) {}
