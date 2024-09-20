package com.firstproject;

import com.firstproject.connection.DriverConnection;
import com.firstproject.daos.CarDAO;
import com.firstproject.menus.MainMenu;
import com.firstproject.services.CarService;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        DriverConnection.getInstance().setHost(System.getenv("HOST"));
        DriverConnection.getInstance().setUser(System.getenv("USER"));
        DriverConnection.getInstance().setPassword(System.getenv("PASSWORD"));

        MainMenu.show(new CarService(new CarDAO(DriverConnection.getInstance())));
    }
}