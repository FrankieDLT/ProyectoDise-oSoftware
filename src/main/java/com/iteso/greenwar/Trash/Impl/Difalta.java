package com.iteso.greenwar.Trash.Impl;
import com.iteso.greenwar.Trash.Dificulty;
import com.iteso.greenwar.Trash.Basura;
import org.junit.Test;

/**
 * This class implements the dificulty class with a low level
 * @author FrankDLT
 * @version 06/04/2020/1.0
 * */

public class Difalta extends Dificulty {

    public void SetClass(Basura b) {

        switch(b.getClasification()){

            case "O":  b.setClas("Org");break;
            case "M":  b.setClas("Met");break;
            case "V":  b.setClas("Vid");break;
            case "P":  b.setClas("Pap");break;
            case "PL": b.setClas("Pla");break;
            case "T":  b.setClas("Tex");break;
            case "B":  b.setClas("Bat");break;
            default: b.setClas("ERROR");

        }

    }

    @Test
    public void TestAlt(){
        Basura Test = new Basura();
        Dificulty Dif = new Difalta();
        Test.setClasification("O");
        Dif.SetClass(Test);

        System.out.println(Test.getClas());

    }

}