package com.iteso.greenwar.Trash.Impl;
import com.iteso.greenwar.Trash.Basura;
import com.iteso.greenwar.Trash.Dificulty;
import org.junit.Test;

/**
 * This class implements the dificulty class with a medium level.
 * @author FrankDLT
 * @version 06/04/2020/1.0
 * */

public class DifMedia extends Dificulty {

    /**
     * Metodo para asignar valor de la
     * clasificación por dificultad.
     * @author Francisco De La Torre
     * @param b basura a la que se le asignará
     *          el valor
     * */
    public void setClass(final Basura b) {

        if (b.getClasification().compareTo("M") == 0
                | b.getClasification().compareTo("V") == 0
                    | b.getClasification().compareTo("P") == 0) {
                        b.setClas("Rec");

        } else if (b.getClasification().compareTo("O") != 0) {
                b.setClas("Ino");
            } else {
                b.setClas("Org");
            }


    }





}
