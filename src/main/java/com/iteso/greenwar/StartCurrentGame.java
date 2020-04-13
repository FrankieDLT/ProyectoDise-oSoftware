package com.iteso.greenwar;

public class StartCurrentGame {
    private final int departureTime = 13;
    private final int littleQuiz = 20;
    private final int middleQuiz = 35;
    private final int bigQuiz = 50;

    public int chooseQuiz(int selectionNumber){
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
