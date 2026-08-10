package com.example.crud.shared;

public record ApiResponseDTO<T> (String mensagem, T dados){
    public static <T> ApiResponseDTO<T> of (String mensagem, T dados) {
        return new ApiResponseDTO<>(mensagem, dados);
    }
}
