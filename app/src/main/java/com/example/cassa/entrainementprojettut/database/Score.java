package com.example.cassa.entrainementprojettut.database;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

@Entity(primaryKeys = {"gameName","difficulty"})

public class Score {

    @NonNull
    String gameName;
    int difficulty;
    long value;
    String playerName;

    public Score(String playerName, long value, String gameName, int difficulty) {
        this.playerName = playerName;
        this.value = value;
        this.gameName = gameName;
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return
                "Niveau " + difficulty +
                ": Le joueur " + playerName+
                " a obtenu un de score  "+ value ;

    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

}
