package com.example.crud.dto.request;

public record ClienteRequestDTO(

        String nome,
        String telefone,
        String cpf,
        String email
){}
