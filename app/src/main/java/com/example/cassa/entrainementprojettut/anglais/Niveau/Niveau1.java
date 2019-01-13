package com.example.cassa.entrainementprojettut.anglais.Niveau;

import com.example.cassa.entrainementprojettut.database.AppDatabase;
import com.example.cassa.entrainementprojettut.database.EnglishWord;

import java.util.List;

public class Niveau1 implements I_Niveau {
    AppDatabase base;

    public Niveau1(AppDatabase database) {
        base=database;
        database.getEnglishWordDao().addInfinitif(new EnglishWord("is","est"));
    }

    @Override
    public boolean GenerateGame() {
        base.getInfinitifDao().findARandomInfinitif(3);
        return false;
    }

    @Override
    public String[] GetGoodReponce() {
        return new String[0];
    }

    @Override
    public List<String[]> GetBadAnswers() {
        return null;
    }
}
