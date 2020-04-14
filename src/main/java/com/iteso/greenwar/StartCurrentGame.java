package com.iteso.greenwar;

/**
 * This class will act as the selection
 * class for the dificulty of the game.
 * @author Juan Carlos
 * @version 06/04/2020/1.0
 * */
public class StartCurrentGame {
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
            case 0:
                return littleQuiz;
                //break; UNREACHABLE
            case 1:
                return middleQuiz;
            //break; UNREACHABLE
            case 2:
                return bigQuiz;
            //break; UNREACHABLE
            default:
                return 0;
        }
    }
}
