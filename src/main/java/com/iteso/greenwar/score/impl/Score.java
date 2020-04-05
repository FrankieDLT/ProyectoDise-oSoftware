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
public class Score extends ScoreBoard {

    private static ScoreBoard uniqueInstance;

    private Score(){
        questionsCurrentGame = new ArrayList();
        player = new Player();
    }

    public static ScoreBoard getInstance(){
        if(uniqueInstance==null){
            uniqueInstance = new Score();
        }
        return uniqueInstance;
    }

    public static void clearCurrentGame(){
        uniqueInstance = null;
    }
}
