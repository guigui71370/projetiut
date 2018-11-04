package com.example.cassa.entrainementprojettut.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface VerbeConjugueDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addVerbeConjugue(VerbeConjugue verbeConjugue);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateVerbeConjugue(VerbeConjugue verbeConjugue);

    @Query("SELECT * FROM VerbeConjugue")
    List<VerbeConjugue> getAllVerbeConjugue();

    @Query("DELETE FROM VerbeConjugue")
    void removeAllVerbeConjugue();

    //Renvoi le verbeConjugue au temps, au sujet et à l'infinitif donné
    @Query("SELECT verbeConjugue FROM VerbeConjugue V JOIN INFINITIF I ON V.infinitifId = I.idInfinitif " +
            "WHERE temps= :temps AND sujet = :sujet AND I.infinitifVerbe= :infinitif")
    String findVerbeConjugue(String temps, String sujet, String infinitif);


}
