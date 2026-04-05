package com.javanauta.aprendendo_spring.infrastructure.exceptions;


// CLasse criada para verificar conflitos
// Cria exceção

public class ConflictException extends RuntimeException{
    public ConflictException(String mensagem){
        super(mensagem);
    }
    public ConflictException(String mensagem, Throwable throwable){
        super(mensagem);
    }
}
