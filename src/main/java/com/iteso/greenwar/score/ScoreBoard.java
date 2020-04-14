package com.iteso.greenwar.score;

import java.util.ArrayList;

/**
 * This abstract class is implementing the
 * Singleton pattern for managing game results.
 * Created with IntelliJ IDEA.
 * @author: jortiz
 * @version: 05/04/2020/1.0
 */
public abstract class ScoreBoard {
    /**
     * List of questions for the game.
     * @author: jortiz
     * @version: 14/04/2020/1.0
     */
    private ArrayList questionsCurrentGame;
    /**
     * Player object.
     * @author: jortiz
     * @version: 14/04/2020/1.0
     */
    private Player player;

    /**
     * Method that add the games score.
     * @author: jortiz
     * @version: 14/04/2020/1.0
     * @param currentQuestion question to be used
     */
    public void addCurrentGameScore(final CurrentQuestion currentQuestion) {
        questionsCurrentGame.add(currentQuestion); }
    /**
     * Errases the games score.
     * @author: jortiz
     * @version: 14/04/2020/1.0
     */
    public void clearCurrentGameScore() {
        questionsCurrentGame.clear();  }
    /**
     * Show the players score.
     * @author: jortiz
     * @version: 14/04/2020/1.0
     */
    public void currentScore() {
        //Aqui la voy a utilizar para poner hacer un banner
        // de resultados(observer pattern) y mostrarlo
    }

    /**
     * Show the score after the game has ended.
     * @author: jortiz
     * @version: 14/04/2020/1.0
     */
    public void finalScore() {
        //Aqui voy a implementar una vez que termine la partida
        // que guarde en un archivo de txt los resultados
    }

    /**
     * List of questions.
     * @author: jortiz
     * @version: 14/04/2020/1.0
     * @return questions used
     */
    public ArrayList getQuestionsCurrentGame() {
        return questionsCurrentGame;
    }

    /**
     * Changes the questions used.
     * @author: jortiz
     * @version: 14/04/2020/1.0
     * @param newq new list of questions
     */
    public void setQuestionsCurrentGame(final ArrayList newq) {
        this.questionsCurrentGame = newq;
    }

    /**
     * Show the current player.
     * @author: jortiz
     * @version: 14/04/2020/1.0
     * @return current player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Changes the current player.
     * @author: jortiz
     * @version: 14/04/2020/1.0
     * @param newp data for the new player
     */
    public void setPlayer(final Player newp) {
        this.player = newp;
    }
}
