package com.iteso.greenwar.Trash;

import com.iteso.greenwar.Trash.Basura;
import com.iteso.greenwar.Trash.Dificulty;
import com.iteso.greenwar.Trash.Impl.DifBasica;
import com.iteso.greenwar.Trash.Impl.DifMedia;
import com.iteso.greenwar.Trash.Impl.Difalta;
import org.junit.Test;


/**
 * This class will test the
 * dificulty classes in the project.
 * @author FrankDLT
 * @version 16/04/2020/1.0
 * */
public class DificultyTest {
    /**
     * Metodo para probar la asignación.
     * @author Francisco De La Torre
     * */
    @Test
    public void testBasic() {
        Basura test = new Basura();
        Dificulty dif = new DifBasica();
        test.setClasification("O");
        dif.setClass(test);

        System.out.println(test.getClas());

    }

    /**
     * Metodo para probar la asignación.
     * @author Francisco De La Torre
     * */
    @Test
    public void testMed() {
        Basura test = new Basura();
        Dificulty dif = new DifMedia();
        test.setClasification("O");
        dif.setClass(test);

        System.out.println(test.getClas());

    }


    /**
     * Metodo para probar la asignación.
     * @author Francisco De La Torre
     * */
    @Test
    public void testAlta() {
        Basura test = new Basura();
        Dificulty dif = new Difalta();
        test.setClasification("O");
        dif.setClass(test);

        System.out.println(test.getClas());

    }


}