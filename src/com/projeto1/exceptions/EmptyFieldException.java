package com.projeto1.exceptions;

public class EmptyFieldException extends RuntimeException{

    public EmptyFieldException(String field){
        super(String.format("O campo %s não pode ser vazio", field));
    }
}
