package com.iteso.greenwar.score;

import java.util.ArrayList;

/**
 * This abstract class is implementing the Singleton pattern for managing game results.
 * Created with IntelliJ IDEA.
 * @author: jortiz
 * @version: 05/04/2020/1.0
 */
public abstract class ScoreBoard {
    public ArrayList questionsCurrentGame;
    public Player player;

    public void addCurrentGameScore(CurrentQuestion currentQuestion) { questionsCurrentGame.add(currentQuestion); }
    public void clearCurrentGameScore() {  questionsCurrentGame.clear();  }

    public void currentScore() {

    }

    public void finalScore() {

    }

}
