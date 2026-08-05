package com.example.crud.parceiro.dto;

import com.example.crud.enums.TipoPessoa;

public record ParceiroResponseDTO(
        String nome,
        String cpfCnpj,
        String email,
        TipoPessoa tipoPessoa
) {
}
