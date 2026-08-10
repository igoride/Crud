package com.example.crud.exception;

public class NotFoundException extends ApplicationException{
    public NotFoundException (String mensagem) {
        super(mensagem);
    }
}
