package com.iteso.greenwar.Trash;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * This class will act as a database from
 * which an object type "Basura".
 * will be drawn to be played with
 * @author FrankDLT
 * @version 14/04/2020/1.0
 * */
public class DBAnalisis {

        /**
         * Número aleatorio.
         *
         * @author Francisco De La Torre
         */
        private Random ra = new Random();
        /**
         * Número para la elección.
         *
         * @author Francisco De La Torre
         */
        private int ran = 0;

        /**
         * Tope del Número aleatorio.
         *
         * @author Francisco De La Torre
         */
        private final int doscientos = 200;

    /**
     * This method recieves a object and changes its name and its
     * type to a certain one depending on the type
     * of trash selected by a random number.
     * @author FrankDLT
     * @version 06/04/2020/1.0
     * @param b Basura a llenar de datos
     * @return b Basura con datos
     * */
    public Basura selectB(final Basura b) throws FileNotFoundException {

        ran = ra.nextInt(doscientos);
        /**
         * Array that collect the object data.
         *
         * @author Francisco De La Torre
         */
        String[] bdObject = new String[3];

        Scanner dataBase =
                new Scanner(new File("DB.txt"))
                        .useDelimiter(",\\s*");


        return null;
    }


        

}
