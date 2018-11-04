package com.example.cassa.entrainementprojettut.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface ScoreDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addScore(Score score);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateScore(Score score);

    @Query("SELECT * FROM Score")
    List<Score> getAllScore();

    @Query("SELECT value FROM Score WHERE gameName = :gameName AND difficulty = :difficulty")
    long findScoreForAGame(String gameName, int difficulty);
}
