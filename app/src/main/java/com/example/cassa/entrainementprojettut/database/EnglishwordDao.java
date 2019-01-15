package com.example.cassa.entrainementprojettut.database;

import android.arch.persistence.room.*;

import java.util.List;

@Dao
public interface EnglishwordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addInfinitif(EnglishWord Word);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateInfinitif(EnglishWord Word);

    @Query("SELECT * FROM EnglishWord")
    List<EnglishWord> getAllWord();

    @Query("SELECT * FROM EnglishWord Where Word = :exclude ORDER BY RANDOM() LIMIT 3")
    List<EnglishWord> getAllWordWhithoutOne(String exclude);
    @Query("SELECT * FROM EnglishWord ORDER BY RANDOM() LIMIT 1")
    EnglishWord findARandomword();



}
