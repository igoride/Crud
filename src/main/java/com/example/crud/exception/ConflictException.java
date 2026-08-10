package com.example.crud.exception;

public class ConflictException extends ApplicationException{
    public ConflictException(String mensagem) {
        super(mensagem);
    }
}
