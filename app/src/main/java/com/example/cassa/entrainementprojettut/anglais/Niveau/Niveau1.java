package com.example.cassa.entrainementprojettut.anglais.Niveau;

import com.example.cassa.entrainementprojettut.database.AppDatabase;
import com.example.cassa.entrainementprojettut.database.EnglishWord;

import java.util.ArrayList;
import java.util.List;

public class Niveau1 implements I_Niveau {
    private AppDatabase base;
    private EnglishWord recherche;
    public Niveau1(AppDatabase database) {
        base=database;
        database.getEnglishWordDao().addInfinitif(new EnglishWord("is","est"));
    }

    @Override
    public boolean GenerateGame() {
        recherche=base.getEnglishWordDao().findARandomword();
    return false;
    }

    @Override
    public String[] GetGoodReponce() {
        return new String[]{recherche.getEnglishWord(),recherche.getTraduction()};
    }

    @Override
    public List<String[]> GetBadAnswers() {
        List<EnglishWord> result=  base.getEnglishWordDao().getAllWordWhithoutOne(recherche.getEnglishWord());
        List<String[]>rsultats=new ArrayList<>();
        for (EnglishWord englishWord : result) {
            rsultats.add(new String[]{englishWord.getEnglishWord(), englishWord.getTraduction()});
        }


        return rsultats;
    }
}
