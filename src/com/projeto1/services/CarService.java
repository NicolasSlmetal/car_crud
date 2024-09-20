package com.projeto1.services;

import com.projeto1.daos.DAO;
import com.projeto1.exceptions.CarNotFoundException;
import com.projeto1.menus.CarForm;
import com.projeto1.menus.CarSheet;
import com.projeto1.model.Car;
import com.projeto1.utils.Keyboard;

public class CarService extends Service<Car> {

    public CarService(DAO<Car> dao){
        setDao(dao);
    }

    public void readFormAndSave(){
        getDao().save(CarForm.createCarFromUserInputs());
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
            car = CarForm.createCarFromUserInputs();
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
