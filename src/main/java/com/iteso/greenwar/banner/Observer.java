package com.iteso.greenwar.banner;

/**
 * This abstract class is implementing the Singleton pattern for managing game results.
 * Created with IntelliJ IDEA.
 * @author: jortiz
 * @version: 09/04/2020/1.0
 */
public interface Observer {
    void scoreUpdate(int turn, int totalTurns, float mark, boolean hit);
}
