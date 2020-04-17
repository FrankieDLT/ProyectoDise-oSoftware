package com.iteso.greenwar;

import java.util.Scanner;

/**
 * This class will act as the initialization
 * class for the game.
 * @author Juan Carlos
 * @version 06/04/2020/1.0
 * */
public class StartGame {
    /**
     * This class is the main class for the game.
     * @author Juan Carlos
     * @version 06/04/2020/1.0
     * @param args "array of strings which
     *             stores arguments passed by command line
     *             while starting a program"
     * */
    public static void main(final String[] args) {
        StartCurrentGameStruct startCurrentGameStruct = new StartCurrentGameStruct();
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        startCurrentGameStruct.displayLevel();
        while(sc1.hasNextInt()) {
            int n = sc1.nextInt();
            startCurrentGameStruct.displayOptions();
            while(sc2.hasNextInt()) {
                int m = sc2.nextInt();
                startCurrentGameStruct.starCurrentGame(m,n);
            }
            sc2.close();
        }
        sc1.close();
    }
}
