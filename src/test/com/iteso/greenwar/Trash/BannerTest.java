package com.iteso.greenwar.Trash;

import com.iteso.greenwar.banner.impl.BannerSimpleObserver;
import org.junit.Test;

/**
 * This class will test the Game
 * Banners in the project.
 * @author FrankDLT
 * @version 16/04/2020/1.0
 * */
public class BannerTest {
    /**
     * Variable para probar.
     * @author Francisco De La Torre
     * */
    BannerSimpleObserver bannerTest
            = new BannerSimpleObserver();

    /**
     * Este Test es para probar que se
     * imprima correctamente el Banner.
     * @author FrankDLT
     * @version 16/04/2020/1.0
     * */
    @Test
    public void displayTest() {
        bannerTest.display();
    }

    /**
     * Este Test es para probar que se
     * imprima correctamente el Score.
     * @author FrankDLT
     * @version 16/04/2020/1.0
     * */
    @Test
    public void scoreUpdateTest() {
        bannerTest.scoreUpdate(0,  0, 0, true);
    }


}
