package com.iteso.greenwar;

import com.iteso.greenwar.Trash.Basura;
import com.iteso.greenwar.Trash.DBAnalisis;
import com.iteso.greenwar.Trash.Dificulty;
import com.iteso.greenwar.Trash.Impl.DifBasica;
import com.iteso.greenwar.Trash.Impl.DifMedia;
import com.iteso.greenwar.Trash.Impl.Difalta;
import com.iteso.greenwar.score.CurrentQuestion;
import com.iteso.greenwar.score.ScoreBoard;
import com.iteso.greenwar.score.impl.Score;

/**
 * This class will act as the selection
 * class for the dificulty of the game.
 * @author Juan Carlos
 * @version 06/04/2020/1.0
 * */
public class StartCurrentGameStruct {
    /**
     * Timer.
     * @author Juan Carlos
     * */
    private final int departureTime = 13;
    /**
     * Low tier dificulty quiz.
     * @author Juan Carlos
     * */
    private final int littleQuiz = 20;
    /**
     * Medium tier dificulty quiz.
     * @author Juan Carlos
     * */
    private final int middleQuiz = 35;
    /**
     * High tier dificulty quiz.
     * @author Juan Carlos
     * */
    private final int bigQuiz = 50;

    /**
     * This class will act as the selection.
     * method for the dificulty of the game
     * @author Juan Carlos
     * @version 06/04/2020/1.0
     * @param selectionNumber Number user for the selection
     * @return Dificulty to be used
     * */
    public int chooseQuiz(final int selectionNumber) {
        switch (selectionNumber) {
            case 1:
                return littleQuiz;
                //break; UNREACHABLE
            case 2:
                return middleQuiz;
            //break; UNREACHABLE
            case 3:
                return bigQuiz;
            //break; UNREACHABLE
            default:
                return 0;
        }
    }

    private  Dificulty chooseLevel(final int selectionNumber) {
        Dificulty dificulty;
        switch (selectionNumber) {
            case 1:
                return dificulty = new DifBasica();
            //break; UNREACHABLE
            case 2:
                return dificulty = new DifMedia();
            //break; UNREACHABLE
            case 3:
                return dificulty = new Difalta();
            //break; UNREACHABLE
            default:
                return null;
        }
    }

    public void displayOptions(){
        String Messages = "\n\n\tSeleccione el numero que desea acertar" +
                "\n\t\t1.- 20" +
                "\n\t\t2.- 35" +
                "\n\t\t3.- 50";;
        System.out.println(Messages);
    }

    public void displayLevel(){
        String Messages = "\n\t\t\tBienvenid@ a GreenWar" +
                "\n\n\tSeleccione el nivel ajugar" +
                "\n\t\t1.- Basico" +
                "\n\t\t2.- Medio" +
                "\n\t\t3.- Dificil";
        System.out.println(Messages);
    }

    public void starCurrentGame(int chooseQuiz, int chooseLevel){
        ScoreBoard scoreBoard;
        CurrentQuestion currentQuestion;

        scoreBoard = Score.getInstance();
        currentQuestion = new CurrentQuestion();
        Dificulty dif = chooseLevel(chooseLevel);

        for(int i=1;i<=chooseQuiz;i++){


        }
    }
}
