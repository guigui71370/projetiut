package com.example.cassa.entrainementprojettut.playerUtils;

/**
 * Created by clement on 07/02/18.
 */

public class Score {

    private String gameName;
    private String playerName;
    private long value;
    private int difficulty;

    public Score(String gameName, String playerName, long value, int difficulty) {
        this.gameName = gameName;
        this.playerName = playerName;
        this.value = value;
        this.difficulty = difficulty;
    }

    public Score() {
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return "Score{" +
                "gameName='" + gameName + '\'' +
                ", playerName='" + playerName + '\'' +
                ", value=" + value +
                ", difficulty=" + difficulty +
                '}';
    }

    public String standardDisplay(){
        return playerName+": "+value;
    }
}
