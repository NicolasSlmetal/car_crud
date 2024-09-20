package com.firstproject.exceptions;

public class InvalidYearException extends RuntimeException{
    public InvalidYearException(int year){
        super(String.format("O ano %d fornecido é inválido", year));
    }
}
