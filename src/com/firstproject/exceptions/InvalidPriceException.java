package com.firstproject.exceptions;

public class InvalidPriceException extends RuntimeException{

    public InvalidPriceException(double price){
        super(String.format("Preço R$ %.2f inválido", price));
    }
}
