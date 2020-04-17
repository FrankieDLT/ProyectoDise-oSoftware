package com.iteso.greenwar;

import com.iteso.greenwar.Trash.Basura;
import com.iteso.greenwar.Trash.DBAnalisis;
import com.iteso.greenwar.Trash.Dificulty;
import com.iteso.greenwar.Trash.Impl.DifBasica;
import com.iteso.greenwar.Trash.Impl.DifMedia;
import com.iteso.greenwar.Trash.Impl.Difalta;
import com.iteso.greenwar.score.CurrentQuestion;
import com.iteso.greenwar.score.Player;
import com.iteso.greenwar.score.ScoreBoard;
import com.iteso.greenwar.score.impl.Score;

import java.io.IOException;
import java.util.Scanner;

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
            case 2:
                return middleQuiz;
            case 3:
                return bigQuiz;
            default:
                return 0;
        }
    }

    private  Dificulty chooseLevel(final int selectionNumber) {
        Dificulty dificulty;
        switch (selectionNumber) {
            case 1:
                return dificulty = new DifBasica();
            case 2:
                return dificulty = new DifMedia();
            case 3:
                return dificulty = new Difalta();
            default:
                return null;
        }
    }

    private  void chooseMenuLevel(final int selectionNumber) {
        String Messages =  "";
        switch (selectionNumber) {
            case 1:
                Messages = "\n\n\tSeleccione la respuesta" +
                        "\n\t\t1.- Organico" +
                        "\n\t\t2.- Inorganico";
                break;
            case 2:
                Messages =  "\n\n\tSeleccione la respuesta" +
                        "\n\t\t1.- Organico" +
                        "\n\t\t2.- Inorganico" +
                        "\n\t\t3.- Reciclable";
                break;
            case 3:
                Messages = "\n\n\tSeleccione la respuesta" +
                        "\n\t\t1.- Organico" +
                        "\n\t\t2.- Metal" +
                        "\n\t\t3.- Vidrio" +
                        "\n\t\t4.- Papel" +
                        "\n\t\t5.- Plastico" +
                        "\n\t\t6.- Textil" +
                        "\n\t\t7.- Basura Tecnologica";
                break;
        }
        System.out.println(Messages);
    }

    private  Basura convertAnswer(final int selectionNumber, final int answer) {
        Basura trash = new Basura();
        switch (selectionNumber) {
            case 1:
                switch (answer){
                    case 1:
                        trash.setClas("Org");
                        break;
                    case 2:
                        trash.setClas("Ino");
                        break;
                }
                break;
            case 2:
                switch (answer){
                    case 1:
                        trash.setClas("Org");
                        break;
                    case 2:
                        trash.setClas("Ino");
                        break;
                    case 3:
                        trash.setClas("Rec");
                        break;
                }
                break;
            case 3:
                switch (answer){
                    case 1:
                        trash.setClas("Org");
                        break;
                    case 2:
                        trash.setClas("Met");
                        break;
                    case 3:
                        trash.setClas("Vid");
                        break;
                    case 4:
                        trash.setClas("Pap");
                        break;
                    case 5:
                        trash.setClas("Pla");
                        break;
                    case 6:
                        trash.setClas("Tex");
                        break;
                    case 7:
                        trash.setClas("Bat");
                        break;
                }
                break;
        }
        return trash;
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

    public void starCurrentGame(int chooseQuiz, int chooseLevel,Player player) throws IOException {
        ScoreBoard scoreBoard;
        Dificulty dificulty;
        CurrentQuestion currentQuestion;

        scoreBoard = Score.getInstance();

        int cycle = chooseQuiz(chooseQuiz);
        Scanner sc = new Scanner(System.in);

        for(int i=1;i<=cycle;i++) {
            currentQuestion = new CurrentQuestion();
            dificulty = chooseLevel(chooseLevel);

            DBAnalisis t = new DBAnalisis();
            Dificulty dif;
            Basura quest = t.selectB(new Basura());

            switch(chooseLevel){
                case 1: dif = new DifBasica();
                        dif.setClass(quest); break;
                case 2: dif = new DifMedia();
                        dif.setClass(quest); break;
                case 3:
                        dif = new Difalta();
                        dif.setClass(quest); break;
                default: break;
            }

            System.out.println("\n\t\t\t"+ quest.getName());
            //System.out.println("\n\t\t\t Caja de Zapatos");

            chooseMenuLevel(chooseLevel);
            int m = sc.nextInt();
            Basura trash = convertAnswer(chooseLevel,m);

            //String DataText = "Org";
            boolean isHit = (trash.getClas().equals(quest.getClas()));
            //boolean isHit = (trash.getClas().equals(DataText));
            currentQuestion.setHit(isHit);
            scoreBoard.addCurrentGameScore(currentQuestion);
            scoreBoard.setPlayer(player);

        }
        scoreBoard.currentScore();
        //scoreBoard.finalScore();

    }
}
