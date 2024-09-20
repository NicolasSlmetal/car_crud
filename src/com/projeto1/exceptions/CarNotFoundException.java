package com.projeto1.exceptions;

public class CarNotFoundException extends RuntimeException{
    public CarNotFoundException(){
        super("Carro não encontrado");
    }
}
