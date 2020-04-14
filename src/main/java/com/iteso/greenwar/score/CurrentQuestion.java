package com.iteso.greenwar.score;

/**
 * This simple class has methods to set
 * and get to know if the answer is correct.
 * Created with IntelliJ IDEA.
 * @author: jortiz
 * @version: 05/04/2020/1.0
 */
public class CurrentQuestion {
    /**
     * Boolean for the correct answer.
     * @author: jortiz
     * @version: 14/04/2020/1.0
     */
    private boolean hit;

    /**
     * Method that determines if the answer is
     * correct.
     * @author: jortiz
     * @version: 14/04/2020/1.0
     * @return correct or incorrect depending on
     *          the answer
     */
    public boolean isHit() {
        return hit;
    }

    /**
     * Method to change the value of hit.
     * @author: jortiz
     * @version: 14/04/2020/1.0
     * @param isHit new value for hit
     */
    public void setHit(final boolean isHit) {
        hit = isHit;
    }
}
