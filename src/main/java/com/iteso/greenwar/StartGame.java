package com.iteso.greenwar;

import com.iteso.greenwar.score.Player;

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
        Scanner sc = new Scanner(System.in);
        Scanner user = new Scanner(System.in);
        Player player = new Player();

        startCurrentGameStruct.displayLevel();
        while(sc.hasNextInt()) {
            int n = sc.nextInt();
            startCurrentGameStruct.displayOptions();
            int m = sc.nextInt();
            System.out.println( "\n\n\tIngrese nombre de jugador");
            String name = user.nextLine();
            player.setNickname(name);
            startCurrentGameStruct.starCurrentGame(m,n,player);
            user.close();
        }
        sc.close();
    }
}
