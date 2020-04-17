package com.iteso.greenwar.banner;

/**
 * This abstract class is implementing the Singleton
 * pattern for managing game results.
 * Created with IntelliJ IDEA.
 * @author: jortiz
 * @version: 09/04/2020/1.0
 */
public interface Observer {
    /**
     * This method is in charge of
     * managing game results.
     * Created with IntelliJ IDEA.
     * @author: jortiz
     * @version: 14/04/2020/1.0
     * @param hit correct answers
     * @param mark score
     * @param totalTurns maximun amount
     *                  of turns for the payer
     * @param turn current turn
     */
    void scoreUpdate(int turn, int totalTurns, int mark, boolean hit);
}
