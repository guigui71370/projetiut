package com.example.cassa.entrainementprojettut.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "EnglishWord")
public class EnglishWord {
    @PrimaryKey(autoGenerate = true)
    int idWord;

    @NonNull
    String Word;
    @NonNull
    String traduction;


    public EnglishWord(String Word, String traduction) {
        this.Word = Word;

        this.traduction = traduction;
    }


    public int getIdWord() {
        return idWord;
    }

    public void setIdWord(int idWord) {
        this.idWord = idWord;
    }

    @NonNull
    public String getEnglishWord() {
        return Word;
    }

    public void setEnglishWord(@NonNull String englishWord) {
        this.Word = englishWord;
    }

    @NonNull
    public String getTraduction() {
        return traduction;
    }

    public void setTraduction(@NonNull String traduction) {
        this.traduction = traduction;
    }
}
