package com.iteso.greenwar.banner.impl;

import com.iteso.greenwar.banner.Observer;
import com.iteso.greenwar.banner.Subject;

import java.util.ArrayList;

/**
 * This abstract class is implementing the
 * Singleton pattern for managing game results.
 * Created with IntelliJ IDEA.
 * @author: jortiz
 * @version: 09/04/2020/1.0
 */
public class Display implements Subject {
    /**
     * List of Observers.
     * @author: jortiz
     * @version: 14/04/2020/1.0
     */
    private final ArrayList observers;
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
     * Show the list to the observers.
     * @author: jortiz
     * @version: 14/04/2020/1.0
     */
    public Display() {
        this.observers = new ArrayList();
    }

    /**
     * Method used to registed new highest scores.
     * @author: jortiz
     * @version: 14/04/2020/1.0
     * @param observer Oberver for this action
     */
    public void startRegisterRecords(final Observer observer) {

        observers.add(observer);
    }

    /**
     * Method to record new highest scores.
     * @author: jortiz
     * @version: 14/04/2020/1.0
     * @param observer Oberver for this action
     */
    public void finishRegisterRecords(final Observer observer) {

    }
    /**
     * Method that notifies about newly registered.
     * @author: jortiz
     * @version: 14/04/2020/1.0
     */
    public void notifyRegisterRecords() {
        for (Object observer1 : observers) {
            Observer observer = (Observer) observer1;
            observer.scoreUpdate(this.turnIs,
                    this.totalTurnsAre, this.markIs, this.isHit);

        }

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
    public void setScore(final int turn, final int totalTurns,
                         final float mark, final boolean hit) {
        this.turnIs = turn;
        this.totalTurnsAre = totalTurns;
        this.markIs = mark;
        this.isHit = hit;
        notifyRegisterRecords();
    }
}

/**
 public JamaiconScoresSubject(){
 observers = new ArrayList();
 }


 public void registerObserver(Observer observer) {
 observers.add(observer);
 }

 public void removeObserver(Observer observer) {
 observers.remove(observers.indexOf(observer));
 }


 public void notifyObservers() {
 for (Object observer1 : observers) {
 Observer observer = (Observer) observer1;
 observer.scoreUpdate(this.homeTeam, this.awayTeam,
 this.homeGoals, this.awayGoals);
 }
 }



 public void setScore( String home, String away, int hg, int ag){
 this.homeTeam = home;
 this.awayTeam =  away;
 this.homeGoals = hg;
 this.awayGoals = ag;
 notifyObservers();
 }
 ***/
