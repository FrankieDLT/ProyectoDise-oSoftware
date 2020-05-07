package com.iteso.greenwar.Trash;

import com.iteso.greenwar.StartCurrentGameStruct;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This class will test the Game
 * geneartor in the project.
 * @author FrankDLT
 * @version 16/04/2020/1.0
 * */
public class StarGameTests {
    /**
     * Variable para probar.
     * @author Francisco De La Torre
     * */
    StartCurrentGameStruct testStar
            = new StartCurrentGameStruct();

    /**
     * Variable para probar.
     * @author Francisco De La Torre
     * */
    Basura basuTest = new Basura();

    /**
     * Este Test es para probar que se
     * imprima correctamente las opciones
     * de cuantas preguntas se harán.
     * @author FrankDLT
     * @version 16/04/2020/1.0
     * */
    @Test
    public void displayOptTest() {
        testStar.displayOptions();
    }

    /**
     * Este Test es para probar que se
     * imprima correctamente las opciones
     * de dificultad que se tomará.
     * @author FrankDLT
     * @version 16/04/2020/1.0
     * */
    @Test
    public void displayLevelTest() {
        testStar.displayLevel();
    }

    /**
     * Este Test es para probar que se
     * recive la información de dificultad y
     * clasificación correctamente.
     * Este ejemplo usa la dificultad baja y
     * espera el tipo Organico.
     * @author FrankDLT
     * @version 16/04/2020/1.0
     * */
    @Test
    public void convertAnswerTestLowOrg() {
        basuTest = testStar.convertAnswer(1,1);
        System.out.println("Type: " + basuTest.getClas());
        assertEquals("Org", basuTest.getClas());
    }

    /**
     * Este Test es para probar que se
     * recive la información de dificultad y
     * clasificación correctamente.
     * Este ejemplo usa la dificultad media y
     * espera el tipo Reciclable.
     * @author FrankDLT
     * @version 16/04/2020/1.0
     * */
    @Test
    public void convertAnswerTestMedRec() {
        basuTest = testStar.convertAnswer(2,3);
        System.out.println("Type: " + basuTest.getClas());
        assertEquals("Rec", basuTest.getClas());
    }

    /**
     * Este Test es para probar que se
     * recive la información de dificultad y
     * clasificación correctamente.
     * Este ejemplo usa la dificultad alta y
     * espera el tipo Basura Electronica.
     * @author FrankDLT
     * @version 16/04/2020/1.0
     * */
    @Test
    public void convertAnswerTestHighBat() {
        basuTest = testStar.convertAnswer(3,7);
        System.out.println("Type: " + basuTest.getClas());
        assertEquals("Bat", basuTest.getClas());
    }

}
