package com.projeto1.exceptions;

public class InvalidPortsNumberException extends RuntimeException{

    public InvalidPortsNumberException(int ports){
        super(String.format("Número de portas %d inválido", ports));
    }
}
