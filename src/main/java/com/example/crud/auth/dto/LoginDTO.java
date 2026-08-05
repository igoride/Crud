package com.example.crud.auth.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginDTO {

    @NotBlank(message = "O nome de usuário não pode estar em branco.")
    private String username;

    @NotBlank(message = "A senha não pode estar em branco.")
    private String password;
}
