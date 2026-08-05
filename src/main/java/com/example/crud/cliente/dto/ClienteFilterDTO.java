package com.example.crud.cliente.dto;

public record ClienteFilterDTO(
        String nome,
        String cpf,
        String email,
        Boolean ativo,
        Long id
) {
}
