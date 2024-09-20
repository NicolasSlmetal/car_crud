package com.projeto1.menus;

import com.projeto1.model.Car;
import com.projeto1.utils.Keyboard;

import java.util.List;

public class CarSheet {

    public static void showListOfCars(List<Car> carList){
        for (Car car: carList){
            showCarInLine(car);
        }
        Keyboard.waitUserPressEnter();
    }

    public static void showCarInLine(Car car) {
        String[] labels = {"ID do Carro", "|Nome",
                "|Marca", "|Ano", "|Cor", "|Categoria", "|Portas", "|Preço", "|Motor"};
        Object[] values = {car.getId(), car.getName(), car.getBrand(),
                car.getYear(), car.getColor(), car.getCategory(), car.getPorts(),
                String.format("R$ %.2f",car.getPrice()), car.getEngine()};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < labels.length; i++)
            sb.append(labels[i]).append(": ").append(values[i]);
        System.out.println(sb.append("\n"));
    }
}
