package com.iteso.greenwar.Trash;

import com.iteso.greenwar.Trash.Impl.DifBasica;
import com.iteso.greenwar.Trash.Impl.DifMedia;
import com.iteso.greenwar.Trash.Impl.Difalta;
import org.junit.Test;

import java.io.IOException;

/**
 * This class will test the database
 * in the project.
 * @author FrankDLT
 * @version 16/04/2020/1.0
 * */
public class DBAnalisisTest {
    /**
     * Clase para realizar las pruebas de
     * DBAnalisis.
     *
     * @author Francisco De La Torre
     */
    DBAnalisis t = new DBAnalisis();

    /**
     * Metodo para probar los valores aleatorios.
     * @author Francisco De La Torre
     * @throws IOException Error en
     *      caso de no leer el archivo
     * */

    @Test
    public void testH() throws IOException {
        Basura test = t.selectB(new Basura());
        System.out.println("Name: " + test.getName()
                + "\nClass: " + test.getClasification());
    }

    /**
     * Metodo para probar la asignación
     * aleatoria con baja dificultad.
     * @author Francisco De La Torre
     * @throws IOException Error en
     *          caso de no leer el archivo
     * */
    @Test
    public void testLoDif() throws IOException {
        Basura test = t.selectB(new Basura());
        Dificulty dif = new DifBasica();
        dif.setClass(test);
        System.out.println("Name: " + test.getName()
                + "\nClass: " + test.getClasification()
                + "\nType: " + test.getClas());
    }

    /**
     * Metodo para probar la asignación
     * aleatoria con media dificultad.
     * @author Francisco De La Torre
     * @throws IOException Error en
     *         caso de no leer el archivo
     * */
    @Test
    public void testMedDif() throws IOException {
        Basura test = t.selectB(new Basura());
        Dificulty dif = new DifMedia();
        dif.setClass(test);
        System.out.println("Name: " + test.getName()
                + "\nClass: " + test.getClasification()
                + "\nType: " + test.getClas());
    }

    /**
     * Metodo para probar la asignación
     * aleatoria con alta dificultad.
     * @author Francisco De La Torre
     * @throws IOException Error en
     *         caso de no leer el archivo
     * */
    @Test
    public void testHiDif() throws IOException {
        Basura test = t.selectB(new Basura());
        Dificulty dif = new Difalta();
        dif.setClass(test);
        System.out.println("Name: " + test.getName()
                + "\nClass: " + test.getClasification()
                + "\nType: " + test.getClas());
    }


}