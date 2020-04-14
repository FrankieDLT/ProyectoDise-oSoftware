package com.iteso.greenwar.score;

/**
 * This simple class contains the methods to get or assign player data.
 * Created with IntelliJ IDEA.
 * @author: jortiz
 * @version: 05/04/2020/1.0
 */
public class Player {
    /**
     * Players Name.
     * @author: jortiz
     * @version: 14/04/2020/1.0
     */
    private String nickname;
    /**
     * Score for the player.
     * @author: jortiz
     * @version: 14/04/2020/1.0
     */
    private int finalScore;

    /**
     * Returns the player name.
     * @author: jortiz
     * @version: 14/04/2020/1.0
     * @return players name
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Changes the players name.
     * @author: jortiz
     * @version: 14/04/2020/1.0
     * @param newNickname New name
     */
    public void setNickname(final String newNickname) {
        this.nickname = newNickname;
    }

    /**
     * Returns the players score.
     * @author: jortiz
     * @version: 14/04/2020/1.0
     * @return the players score
     */
    public int getFinalScore() {
        return finalScore;
    }

    /**
     * Changes the players score.
     * @author: jortiz
     * @version: 14/04/2020/1.0
     * @param newFinalScore new score
     */
    public void setFinalScore(final int newFinalScore) {

        this.finalScore = newFinalScore;
    }
}
