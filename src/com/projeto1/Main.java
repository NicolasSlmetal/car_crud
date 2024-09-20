package com.projeto1;

import com.projeto1.connection.DriverConnection;
import com.projeto1.daos.CarDAO;
import com.projeto1.menus.MainMenu;
import com.projeto1.services.CarService;
import com.projeto1.utils.Keyboard;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        DriverConnection.getInstance().setHost(System.getenv("HOST"));
        DriverConnection.getInstance().setUser(System.getenv("USER"));
        DriverConnection.getInstance().setPassword(System.getenv("PASSWORD"));

        MainMenu.show(new CarService(new CarDAO(DriverConnection.getInstance())));
    }
}