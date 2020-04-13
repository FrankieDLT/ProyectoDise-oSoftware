package com.iteso.greenwar.banner.impl;

import com.iteso.greenwar.banner.Observer;
import com.iteso.greenwar.banner.Subject;

/**
 * This abstract class is implementing the Singleton pattern for managing game results.
 * Created with IntelliJ IDEA.
 * @author: jortiz
 * @version: 09/04/2020/1.0
 */
public class BannerObserver implements Observer {
    private int turnIs;
    private int totalTurnsAre;
    private float markIs;
    private boolean isHit;

    public void display() {

        String ScoredBoard = "";
        System.out.println("Ultima actualizacion del porcentaje:");
        for (int i = 0; i < turnIs; i++) {
            ScoredBoard += "\n\tTurno: "+ turnIs + "\tAcierto: "+ isHit +"\tPromedio: "+ markIs;
        }
        System.out.println(ScoredBoard);
    }

    public void scoreUpdate(int turn, int totalTurns, float mark, boolean hit) {
        this.turnIs = turn;
        this.totalTurnsAre = totalTurns;
        this.markIs = mark;
        this.isHit = hit;

        display();
    }
}
