package com.example.crud.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ItemDTO {

    @NotBlank(message = "O nome do item é obrigatório.")
    @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres")
    private String nome;

    @NotBlank(message = "A descrição do item é obrigatório.")
    @Size(max = 255, message = "A descrição deve ter no máximo 255 caracteres")
    private String descricao;
}
