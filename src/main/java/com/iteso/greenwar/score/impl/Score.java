package com.iteso.greenwar.score.impl;

import com.iteso.greenwar.score.Player;
import com.iteso.greenwar.score.ScoreBoard;

import java.util.ArrayList;

/**
 * This simple class is extended to initialize the Singleton pattern.
 * Created with IntelliJ IDEA.
 * @author: jortiz
 * @version: 05/04/2020/1.0
 */
public final class Score extends ScoreBoard {

    /**
     * Variable for the scoreboard.
     * @author: jortiz
     * @version: 14/04/2020/1.0
     */
    private static ScoreBoard uniqueInstance;

    /**
     * Method to initialize the player and questions.
     * @author: jortiz
     * @version: 14/04/2020/1.0
     */
    private  Score() {
        super.setQuestionsCurrentGame(
                new ArrayList()); //questionsCurrentGame
        super.setPlayer(new Player()); //player
    }

    /**
     * Method to create new scoreboard.
     * @author: jortiz
     * @version: 14/04/2020/1.0
     * @return the game instance
     */
    public static ScoreBoard getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Score();
        }
        return uniqueInstance;
    }

    /**
     * Method to clear thecurrent game.
     * @author: jortiz
     * @version: 14/04/2020/1.0
     */
    public static void clearCurrentGame() {

        uniqueInstance = null;
    }
}
