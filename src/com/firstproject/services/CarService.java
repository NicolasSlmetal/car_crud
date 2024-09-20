package com.firstproject.services;

import com.firstproject.daos.DAO;
import com.firstproject.exceptions.*;
import com.firstproject.menus.CarForm;
import com.firstproject.menus.CarSheet;
import com.firstproject.model.Car;
import com.firstproject.utils.Keyboard;

public class CarService extends Service<Car> {

    public CarService(DAO<Car> dao){
        setDao(dao);
    }

    public Car promptWithValidation(){
        Car car = new Car();
        Exception ex;
        do {
            ex = null;
            try {
                CarForm.promptAllCarFields(car);
            } catch (InvalidYearException | InvalidPortsNumberException | EmptyFieldException |
                     InvalidPriceException exception) {
                System.out.println(exception.getMessage());
                ex = exception;
            }
        } while (ex != null);
        return car;
    }

    @Override
    public void readFormAndSave(){
        getDao().save(promptWithValidation());
    }

    @Override
    public void findAllAndShow() {
        CarSheet.showListOfCars(getDao().findAll());
    }

    @Override
    public void findByIdAndShow() {
        CarSheet.showCarInLine(findById());
        Keyboard.waitUserPressEnter();
    }

    private Car findById() {
        Car car = null;
        Exception ex;
        do {
            try {
                ex = null;
                car = getDao().findById(CarForm.promptId());
            } catch (CarNotFoundException exception) {
                System.out.println(exception.getMessage());
                ex = exception;
            }
        } while (ex != null || car == null);
        return car;
    }

    @Override
    public void updateIfConfirmed() {
        Car car = findById();
        CarSheet.showCarInLine(car);
        if (CarForm.confirmActionOfUser("Deseja realmente atualizar esse carro?")){
            Integer id = car.getId();
            car = promptWithValidation();
            car.setId(id);
            getDao().update(car);
        }

    }

    @Override
    public void deleteIfConfirmed() {
        Car car = findById();
        CarSheet.showCarInLine(car);
        if (CarForm.confirmActionOfUser("Deseja realmente excluir esse carro?")){
            getDao().delete(car.getId());
        }
    }

}
