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
     * Variable with fixed
     * value 3.
     * @author Juan Carlos
     * */
    private final int three = 3;
    /**
     * Variable with fixed
     * value 4.
     * @author Juan Carlos
     * */
    private final int four = 4;
    /**
     * Variable with fixed
     * value 5.
     * @author Juan Carlos
     * */
    private final int five = 5;
    /**
     * Variable with fixed
     * value 6.
     * @author Juan Carlos
     * */
    private final int six = 6;
    /**
     * Variable with fixed
     * value 7.
     * @author Juan Carlos
     * */
    private final int seven = 7;
    /**
     * This class will act as the selection
     * method for the number of questins
     * of the game.
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
            case three:
                return bigQuiz;
            default:
                return 0;
        }
    }

    /**
     * This class will act as the selection
     * method for the dificulty of the game.
     * @author Juan Carlos
     * @version 06/04/2020/1.0
     * @param selectionNumber Number user for the selection
     * @return Dificulty to be used
     * */
    private  Dificulty chooseLevel(final int selectionNumber) {
        Dificulty dificulty;
        /*switch (selectionNumber) {
            case 1:
                return dificulty = new DifBasica();
            case 2:
                return dificulty = new DifMedia();
            case three:
                return dificulty = new Difalta();
            default:
                return null;
        }*/
        if (selectionNumber == three) {
            dificulty = new Difalta();
        } else if (selectionNumber == 2) {
            dificulty = new DifMedia();
        } else {
            dificulty = new DifBasica();
        }

        return dificulty;

    }

    /**
     * This class will act as the visible menu
     * method for the answer selection.
     * @author Juan Carlos
     * @version 06/04/2020/1.0
     * @param selectionNumber Number user for the selection
     * */
    private  void chooseMenuLevel(final int selectionNumber) {
        String messages =  "";
        switch (selectionNumber) {
            case 1:
                messages = "\n\n\tSeleccione la respuesta"
                        + "\n\t\t1.- Organico"
                        + "\n\t\t2.- Inorganico";
                break;
            case 2:
                messages =  "\n\n\tSeleccione la respuesta"
                        + "\n\t\t1.- Organico"
                        + "\n\t\t2.- Inorganico"
                        + "\n\t\t3.- Reciclable";
                break;
            case three:
                messages = "\n\n\tSeleccione la respuesta"
                        + "\n\t\t1.- Organico"
                        + "\n\t\t2.- Metal"
                        + "\n\t\t3.- Vidrio"
                        + "\n\t\t4.- Papel"
                        + "\n\t\t5.- Plastico"
                        + "\n\t\t6.- Textil"
                        + "\n\t\t7.- Basura Tecnologica";
                break;
            default: messages = "Err"; break;
        }
        System.out.println(messages);
    }

    /**
     * This method will act as the translator
     * for the answer given.
     * @author Juan Carlos
     * @version 06/04/2020/1.0
     * @param selectionNumber Dificulty bben played
     * @param answer Answer given
     * @return object type Basura for answer
     * */
    private  Basura convertAnswer(final int selectionNumber, final int answer) {
        Basura trash = new Basura();
        switch (selectionNumber) {
            case 1:
                switch (answer) {
                    case 1:
                        trash.setClas("Org");
                        break;
                    case 2:
                        trash.setClas("Ino");
                        break;
                    default: trash.setClas("Err"); break;
                }
                break;
            case 2:
                switch (answer) {
                    case 1:
                        trash.setClas("Org");
                        break;
                    case 2:
                        trash.setClas("Ino");
                        break;
                    case three:
                        trash.setClas("Rec");
                        break;
                    default: trash.setClas("Err"); break;
                }
                break;
            case three:
                switch (answer) {
                    case 1:
                        trash.setClas("Org");
                        break;
                    case 2:
                        trash.setClas("Met");
                        break;
                    case three:
                        trash.setClas("Vid");
                        break;
                    case four:
                        trash.setClas("Pap");
                        break;
                    case five:
                        trash.setClas("Pla");
                        break;
                    case six:
                        trash.setClas("Tex");
                        break;
                    case seven:
                        trash.setClas("Bat");
                        break;
                    default: trash.setClas("Err"); break;
                }
                break;
            default: trash.setClas("Err"); break;
        }
        return trash;
    }

    /**
     * This method will act as the menu
     * for the rounds selection.
     * @author Juan Carlos
     * @version 06/04/2020/1.0
     * */
    public void displayOptions() {
        String mes = "\n\n\tSeleccione el numero que desea acertar"
               + "\n\t\t1.- 20"
               + "\n\t\t2.- 35"
               + "\n\t\t3.- 50";
        System.out.println(mes);
    }

    /**
     * This method will act as the menu
     * for the dificulty selection.
     * @author Juan Carlos
     * @version 06/04/2020/1.0
     * */
    public void displayLevel() {
        String messag = "\n\t\t\tBienvenid@ a GreenWar"
               + "\n\n\tSeleccione el nivel ajugar"
               + "\n\t\t1.- Basico"
               + "\n\t\t2.- Medio"
               + "\n\t\t3.- Dificil";
        System.out.println(messag);
    }

    /**
     * This method will act as the main
     * operations center, where it will
     * take objects from the DB and compare
     * them with the answer based on the dificulty.
     * @author Juan Carlos
     * @version 06/04/2020/1.0
     * @param chooseLevel Level to be used
     * @param chooseQuiz Amount of questions
     *                   to be asked
     * @param player User playing the game
     * @throws IOException Posible error
     *                      when loading the DB
     * */
    public void starCurrentGame(final int chooseQuiz,
                                final int chooseLevel,
            final Player player) throws IOException {
        ScoreBoard scoreBoard;
        Dificulty dificulty;
        CurrentQuestion currentQuestion;

        scoreBoard = Score.getInstance();

        int cycle = chooseQuiz(chooseQuiz);
        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= cycle; i++) {
            currentQuestion = new CurrentQuestion();
            dificulty = chooseLevel(chooseLevel);

            DBAnalisis t = new DBAnalisis();
            Dificulty dif;
            Basura quest = t.selectB(new Basura());

            switch (chooseLevel) {
                case 1: dif = new DifBasica();
                        dif.setClass(quest); break;
                case 2: dif = new DifMedia();
                        dif.setClass(quest); break;
                case three:
                        dif = new Difalta();
                        dif.setClass(quest); break;
                default: break;
            }

            System.out.println("\n\t\t\t" + quest.getName());
            //System.out.println("\n\t\t\t Caja de Zapatos");

            chooseMenuLevel(chooseLevel);
            int m = sc.nextInt();
            Basura trash = convertAnswer(chooseLevel, m);

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
