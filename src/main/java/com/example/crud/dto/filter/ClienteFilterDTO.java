package com.example.crud.dto.filter;

public record ClienteFilterDTO(
        String nome,
        String cpf,
        String email,
        Boolean ativo,
        Long id
) {
}
