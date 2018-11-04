package com.example.cassa.entrainementprojettut.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface InfinitifDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addInfinitif(Infinitif infinitif);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateInfinitif(Infinitif infinitif);

    @Query("SELECT * FROM Infinitif")
    List<Infinitif> getAllInfinitif();

    @Query("SELECT idInfinitif FROM Infinitif WHERE infinitifVerbe = :infinitif")
    int getIdInfinitif(String infinitif);

    @Query("DELETE FROM Infinitif")
    void removeAllInfinitif();

    @Query("SELECT groupe FROM Infinitif WHERE infinitifVerbe = :infinitif LIMIT 1")
    int getGroupeInfinitif(String infinitif);

    //Renvoi aléatoirement un verbe à l'infinitif pour le groupe donné
    @Query("SELECT infinitifVerbe FROM infinitif WHERE groupe = :groupe ORDER BY RANDOM() LIMIT 1")
    String findARandomInfinitif(int groupe);

    //Renvoi aléatoirement un complément pour l'infinitif donné
    @Query("SELECT complement FROM infinitif WHERE infinitifVerbe = :infinitif ORDER BY RANDOM() LIMIT 1")
    String findComplementInfinitif(String infinitif);
}
