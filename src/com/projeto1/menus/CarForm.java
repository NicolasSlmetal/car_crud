package com.projeto1.menus;

import com.projeto1.exceptions.EmptyFieldException;
import com.projeto1.exceptions.InvalidPortsNumberException;
import com.projeto1.exceptions.InvalidYearException;
import com.projeto1.model.Car;
import com.projeto1.utils.Keyboard;

public class CarForm {

    public static Car createCarFromUserInputs(){
        Car car = new Car();
        Exception ex;
        do {
            ex = null;
            try {
                promptAllCarFields(car);
            } catch (InvalidYearException | InvalidPortsNumberException | EmptyFieldException exception) {
                System.out.println(exception.getMessage());
                ex = exception;
            }
        } while (ex != null);

        return car;
    }

    private static void promptAllCarFields(Car car) {
        System.out.println("Digite o nome do carro: ");
        car.setName(Keyboard.readString());
        System.out.println("Digite a marca do carro: ");
        car.setBrand(Keyboard.readString());
        System.out.println("Digite o ano do carro: ");
        car.setYear(Keyboard.readInteger());
        System.out.println("Digite a cor do carro: ");
        car.setColor(Keyboard.readString());
        System.out.println("Digite a categoria do carro: ");
        car.setCategory(Keyboard.readString());
        System.out.println("Digite o país de fabricação do carro: ");
        car.setCountry(Keyboard.readString());
        System.out.println("Digite o número de portas do carro: ");
        car.setPorts(Keyboard.readInteger());
        System.out.println("Digite o preço do carro: ");
        car.setPrice(Keyboard.readDouble());
        System.out.println("Digite o motor do carro: ");
        car.setEngine(Keyboard.readString());
    }

    public static Integer promptId(){
        System.out.println("Digite o ID do carro: ");
        return Keyboard.readInteger();
    }
    public static Boolean confirmActionOfUser(String message){
        String option;
        do{
            System.out.printf("%s [Digite S/N]:\n",message);
            option = Keyboard.readString().toUpperCase();
        } while (!option.equals("S") && !option.equals("N"));
        return option.equals("S");
    }
}
