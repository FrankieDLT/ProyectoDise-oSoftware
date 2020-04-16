package com.iteso.greenwar.Trash.Impl;
import com.iteso.greenwar.Trash.Dificulty;
import com.iteso.greenwar.Trash.Basura;
import org.junit.Test;

/**
 * This class implements the dificulty class with a high level.
 * @author FrankDLT
 * @version 06/04/2020/1.0
 * */

public class Difalta extends Dificulty {

    /**
     * Metodo para asignar valor de la
     * clasificación por dificultad.
     * @author Francisco De La Torre
     * @param b basura a la que se le asignará
     *          el valor
     * */
    public void setClass(final Basura b) {

        switch (b.getClasification()) {

            case "O":  b.setClas("Org"); break;
            case "M":  b.setClas("Met"); break;
            case "V":  b.setClas("Vid"); break;
            case "P":  b.setClas("Pap"); break;
            case "PL": b.setClas("Pla"); break;
            case "T":  b.setClas("Tex"); break;
            case "B":  b.setClas("Bat"); break;
            default: b.setClas("ERROR");

        }

    }



}
