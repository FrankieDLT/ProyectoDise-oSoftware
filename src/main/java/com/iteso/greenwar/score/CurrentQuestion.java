package com.iteso.greenwar.score;

/**
 * This simple class has methods to set and get to know if the answer is correct.
 * Created with IntelliJ IDEA.
 * @author: jortiz
 * @version: 05/04/2020/1.0
 */
public class CurrentQuestion {
    private boolean Hit;

    public boolean isHit() {
        return Hit;
    }

    public void setHit(boolean isHit) {
        Hit = isHit;
    }
}
