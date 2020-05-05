package com.iteso.greenwar.Trash;

import com.iteso.greenwar.score.CurrentQuestion;
import com.iteso.greenwar.score.Player;
import com.iteso.greenwar.score.ScoreBoard;
import com.iteso.greenwar.score.impl.Score;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This class will test the Game
 * ScoreBoard in the project.
 * @author FrankDLT
 * @version 16/04/2020/1.0
 * */
public class ScoreBoardTest {
    /**
     * Variable para probar el ScoreBoard.
     * @author Francisco De La Torre
     * */
    ScoreBoard sbTest = Score.getInstance();
    /**
     * Variable para probar el CurrentQuestion.
     * @author Francisco De La Torre
     * */
    CurrentQuestion cqTest = new CurrentQuestion();
    /**
     * Variable para probar al jugador.
     * @author Francisco De La Torre
     * */
    Player plaTest = new Player();
    /**
     * Variable para probar el manejo
     * de información del jugador.
     * @author Francisco De La Torre
     * */
    Player plaTest2 = new Player();

    /**
     * Este Test es para probar que se
     * añada correctamente el CurrentGameScore.
     * @author FrankDLT
     * @version 16/04/2020/1.0
     * */
    @Test
    public void addCurrentGameScoreTest() {
        sbTest.addCurrentGameScore(cqTest);
        System.out.println(sbTest.getQuestionsCurrentGame().size());
        assertEquals(1, sbTest.getQuestionsCurrentGame().size());
    }

    /**
     * Este Test es para probar que se
     * elimine correctamente el CurrentGameScore.
     * @author FrankDLT
     * @version 16/04/2020/1.0
     * */
    @Test
    public void clearCurrentGameScoreTest() {
        sbTest.addCurrentGameScore(cqTest);
        System.out.println(sbTest.getQuestionsCurrentGame().size());
        sbTest.clearCurrentGameScore();
        System.out.println(sbTest.getQuestionsCurrentGame().size());
        assertEquals(0, sbTest.getQuestionsCurrentGame().size());
    }

    /**
     * Este Test es para probar que se
     * imprima correctamente el CurrentGameScore.
     * @author FrankDLT
     * @version 16/04/2020/1.0
     * */
    @Test
    public void currentScoreTest(){
        sbTest.currentScore();
    }

    /**
     * Este Test es para probar que se
     * devuelva correctamente el CurrentGameScore.
     * @author FrankDLT
     * @version 16/04/2020/1.0
     * */
    @Test
    public void getQuestionsCurrentGameTest(){
        sbTest.addCurrentGameScore(cqTest);
        System.out.println(sbTest.getQuestionsCurrentGame().isEmpty());
        assertEquals(false,
                sbTest.getQuestionsCurrentGame().isEmpty());
    }

    /**
     * Este Test es para probar que se
     * reciva y envie correctamente la
     * información del jugador.
     * @author FrankDLT
     * @version 16/04/2020/1.0
     * */
    @Test
    public void getsetPlayerTest(){
        plaTest.setNickname("TESTING");
        plaTest.setFinalScore(42);
        sbTest.setPlayer(plaTest);
        plaTest2 = sbTest.getPlayer();
        System.out.println("N: " + plaTest2.getNickname()
                + "\nS: " + plaTest2.getFinalScore());
        assertEquals("TESTING", plaTest2.getNickname());
        assertEquals(42, plaTest2.getFinalScore());
    }
}
