package com.iteso.greenwar.score;

/**
 * This simple class contains the methods to get or assign player data.
 * Created with IntelliJ IDEA.
 * @author: jortiz
 * @version: 05/04/2020/1.0
 */
public class Player {
    private String nickname;
    private int finalScore;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String newNickname) {
        this.nickname = newNickname;
    }

    public int getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(int newFinalScore) {
        this.finalScore = newFinalScore;
    }
}
