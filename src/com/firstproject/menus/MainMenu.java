package com.firstproject.menus;

import com.firstproject.model.Car;
import com.firstproject.services.Service;
import com.firstproject.utils.Keyboard;

public class MainMenu {

    private static Service<Car> service;
    public static void show(Service<Car> providedService) throws InterruptedException {
        service = providedService;
        String optionsMenu =
                "1 - Adicionar Carro\n" +
                "2 - Visualizar carros\n" +
                "3 - Visualizar por ID\n" +
                "4 - Editar carros\n" +
                "5 - Deletar carro\n" +
                "6 - Sair";
        System.out.println("==========");
        System.out.println("Bem-vindo");
        int option;
        do{
            System.out.println("==========");
            System.out.println(optionsMenu);
            System.out.println("Digite sua opção: ");
            option = Keyboard.readInteger();
            redirectToAction(option);
        } while(option != 6);
    }

    public static void redirectToAction(int option) throws InterruptedException {
        switch (option){
            case 1:
                service.readFormAndSave();
                break;
            case 2:
                service.findAllAndShow();
                break;
            case 3:
                service.findByIdAndShow();
                break;
            case 4:
                service.updateIfConfirmed();
                break;
            case 5:
                service.deleteIfConfirmed();
                break;
            case 6:
                System.out.println("Volte sempre!");
                break;
            default:
                System.out.println("Opção inválida");
        }
        Thread.sleep(2000);
    }
}
