package com.game;

import java.util.Scanner;

public class GameConsole {

    private final static Scanner scanner = new Scanner(System.in);

    public static void consoleOut(String str){
        System.out.println(str);
    }

    public static String consoleIn(String str){
        System.out.print(str);
        return scanner.nextLine().trim();
    }
}
