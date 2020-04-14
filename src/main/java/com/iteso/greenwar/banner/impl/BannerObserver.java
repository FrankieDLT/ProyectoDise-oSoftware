package com.iteso.greenwar.banner.impl;

import com.iteso.greenwar.banner.Observer;
//import com.iteso.greenwar.banner.Subject;

/**
 * This abstract class is implementing the
 * Singleton pattern for managing game results.
 * Created with IntelliJ IDEA.
 * @author: jortiz
 * @version: 09/04/2020/1.0
 */
public class BannerObserver implements Observer {
    /**
     * Current Turn.
     * @author: jortiz
     * @version: 14/04/2020/1.0
     */
    private int turnIs;
    /**
     * Maximun amount of turns.
     * @author: jortiz
     * @version: 14/04/2020/1.0
     */
    private int totalTurnsAre;
    /**
     * Turn mean.
     * @author: jortiz
     * @version: 14/04/2020/1.0
     */
    private float markIs;
    /**
     * Boolean for the correct answer.
     * @author: jortiz
     * @version: 14/04/2020/1.0
     */
    private boolean isHit;

    /**
     * Method that show currect info about
     * the game.
     * @author: jortiz
     * @version: 14/04/2020/1.0
     */
    public void display() {

        String scoredBoard = "";
        System.out.println("Ultima actualizacion del porcentaje:");
        for (int i = 0; i < turnIs; i++) {
            scoredBoard += "\n\tTurno: " + turnIs
                    + "\tAcierto: " + isHit + "\tPromedio: " + markIs;
        }
        System.out.println(scoredBoard);
    }

    /**
     * Method that updates the score.
     * @author: jortiz
     * @version: 14/04/2020/1.0
     * @param turn Current turn
     * @param totalTurns maximun amount of turns
     * @param mark score
     * @param hit correct or not
     */
    public void scoreUpdate(final int turn, final  int totalTurns,
                            final float mark, final boolean hit) {
        this.turnIs = turn;
        this.totalTurnsAre = totalTurns;
        this.markIs = mark;
        this.isHit = hit;

        display();
    }
}
