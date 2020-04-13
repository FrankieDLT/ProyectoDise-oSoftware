package com.iteso.greenwar.Trash.Impl;
import com.iteso.greenwar.Trash.Basura;
import com.iteso.greenwar.Trash.Dificulty;
import com.iteso.greenwar.Trash.Basura;
import org.junit.Test;

/**
 * This class implements the dificulty class with a low level
 * @author FrankDLT
 * @version 06/04/2020/1.0
 * */

public class DifBasica extends Dificulty {

    @Override
    public void SetClass(Basura b) {
            if(b.getClasification().compareTo("O")!=0){
                b.setClas("Ino");
            } else {
                b.setClas("Org");
            }
    }


    @Test
    public void TestBasic(){
        Basura Test = new Basura();
        Dificulty Dif = new DifBasica();
        Test.setClasification("O");
        Dif.SetClass(Test);

        System.out.println(Test.getClas());

    }

}