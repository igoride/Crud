package com.example.crud.cliente.dto;

public record ClienteRequestDTO(

        String nome,
        String telefone,
        String cpf,
        String email
){}
