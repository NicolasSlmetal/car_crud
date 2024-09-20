package com.firstproject.exceptions;

public class CarNotFoundException extends RuntimeException{
    public CarNotFoundException(){
        super("Carro não encontrado");
    }
}
