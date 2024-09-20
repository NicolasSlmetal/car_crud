package com.projeto1.exceptions;

public class InvalidYearException extends RuntimeException{
    public InvalidYearException(int year){
        super("O ano fornecido é inválido");
    }
}
