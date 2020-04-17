package com.iteso.greenwar.score;

import com.iteso.greenwar.banner.impl.BannerSimpleObserver;
import com.iteso.greenwar.banner.impl.Display;

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
        int countTurns = 1, countHits = 0;
        int marks=0;
        Display display = new  Display(); //Subject
        BannerSimpleObserver bannerSimpleObserver = new BannerSimpleObserver();
        display.finishRegisterRecords(bannerSimpleObserver);

        CurrentQuestion cQ;

        for (int i=0;i < questionsCurrentGame.size();i++){

            cQ = (CurrentQuestion) questionsCurrentGame.get(i);

            countHits = (cQ.isHit()== true)?countHits+1:countHits;
            marks = (countHits * 100)/countTurns;

            System.out.println("\tPorcentajes del juego:");
            display.setScore(countTurns,questionsCurrentGame.size(),marks,cQ.isHit());

            countTurns++;
        }
        player.setFinalScore(marks);
        System.out.println("\n\n\t\tFin del juego" +
                "\n\tJugador: "+player.getNickname()+
                "\n\tRecord: "+player.getFinalScore()+"%");
    }

    /**
     * Show the score after the game has ended.
     * @author: jortiz
     * @version: 14/04/2020/1.0
     */
    public void finalScore() {

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
