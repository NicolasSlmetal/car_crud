package com.firstproject.utils;

import java.util.Scanner;

public class Keyboard {

    private static final Scanner sc = new Scanner(System.in);

    public static int readInteger(){

        int parsedValue;
        do{
            String input = sc.nextLine();
            parsedValue = input.matches("[0-9]+")? Integer.parseInt(input) : Integer.MAX_VALUE;
        } while (parsedValue == Integer.MAX_VALUE);
        return parsedValue;
    }

    public static String readString(){
        return sc.nextLine();
    }

    public static Double readDouble(){
        double parsedValue;
        do{
            String input = sc.nextLine();
            input = input.replace(",", ".");
            parsedValue = input.matches("^-?\\d+(\\.\\d+)?$")? Double.parseDouble(input) : Double.MAX_VALUE;
        } while (parsedValue == Double.MAX_VALUE);
        return parsedValue;
    }

    public static void close(){
        sc.close();
    }

    public static void waitUserPressEnter() {
        System.out.println("Pressione ENTER para voltar: ");
        sc.nextLine();
        System.out.println("Voltando...");
    }

}
