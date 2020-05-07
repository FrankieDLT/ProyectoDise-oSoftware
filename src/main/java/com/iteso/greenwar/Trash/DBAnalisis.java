package com.iteso.greenwar.Trash;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

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
     * @throws IOException Error en
     * caso de no leer el archivo
     * */
    public Basura selectB(final Basura b) throws IOException {

        ran = ra.nextInt(doscientos);

        /**
         * Linea leida de la Base de Datos.
         *
         * @author Francisco De La Torre
         */
        String linea;

        /**
         * Arreglo que divide la linea en nombre
         * y clase.
         *
         * @author Francisco De La Torre
         */
        String[] basu = new String[2];

        /**
         * Buffer que carga la Base de Datos.
         *
         * @author Francisco De La Torre
         */
        BufferedReader dataBse = null;

        /**
         * Arreglo al que se le carga la Base
         * de Datos.
         *
         * @author Francisco De La Torre
         */
        ArrayList<String> list = new ArrayList<String>();

        /**
         * Dirección del archivo que contiene
         * la Base de Datos.
         *
         * @author Francisco De La Torre
         */

//        URL direcc = getClass().getResource("C:\\\\Desarrollo\\\\DD\\\\ProyectoDise-oSoftware\\\\src\\\\main\\\\java\\\\com\\\\iteso\\\\greenwar\\\\Trash\\\\DB.txt");
//        System.out.println(direcc.getPath());

//        FileReader dB =
//               new FileReader(direcc.getPath());
//
                try {
                   File direcc = new File("C:\\Desarrollo\\DD\\ProyectoDise-oSoftware\\src\\main\\java\\com\\iteso\\greenwar\\Trash\\DB.txt");
                    //File direcc = new File("DB.txt");
                    dataBse = new BufferedReader(new InputStreamReader(new FileInputStream(direcc)));
                    //dataBse = new BufferedReader(dB);
                    // Lectura del fichero
                    while ((linea = dataBse.readLine()) != null) {
                        list.add(linea);
                    }

                    dataBse.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                //dB.close();
        /**
         * Arreglo con el que se trabajan y separan
         * los datos.
         *
         * @author Francisco De La Torre
         */
                String[] myArray = new String[list.size()];
                list.toArray(myArray);


                //basu = myArray[ran].split("|", 1); no funciona
        /**
         * Indice del separador entre nombre
         * y clase en la linea.
         *
         * @author Francisco De La Torre
         */
                 int index = myArray[ran].indexOf("|");
                 basu[0] = myArray[ran].substring(0, index);
                 basu[1] = myArray[ran].substring(index + 1);
                 basu[0].trim();
                 basu[1].trim();

                 b.setName(basu[0]);
                 b.setClasification(basu[1]);

                return b;


    }




}
