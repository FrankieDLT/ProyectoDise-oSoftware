package com.iteso.greenwar.banner.impl;

import com.iteso.greenwar.banner.Observer;
import com.iteso.greenwar.banner.Subject;

import java.util.ArrayList;

/**
 * This abstract class is implementing the Singleton pattern for managing game results.
 * Created with IntelliJ IDEA.
 * @author: jortiz
 * @version: 09/04/2020/1.0
 */
public class Display implements Subject {
    private final ArrayList observers;
    private int turnIs;
    private int totalTurnsAre;
    private float markIs;
    private boolean isHit;

    public Display() {
        this.observers = new ArrayList();
    }

    public void startRegisterRecords(Observer observer){
        observers.add(observer);
    }

    public void finishRegisterRecords(Observer observer){

    }
    public void notifyRegisterRecords(){
        for(Object observer1 : observers){
            Observer observer = (Observer) observer1;
            observer.scoreUpdate(this.turnIs, this.totalTurnsAre, this.markIs, this.isHit);

        }

    }
    public void setScore(int turn, int totalTurns, float mark, boolean hit) {
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
 observer.scoreUpdate(this.homeTeam, this.awayTeam, this.homeGoals, this.awayGoals);
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
