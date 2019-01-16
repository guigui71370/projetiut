package com.example.cassa.entrainementprojettut.anglais.Niveau;

import android.util.Log;
import com.example.cassa.entrainementprojettut.database.AppDatabase;
import com.example.cassa.entrainementprojettut.database.EnglishWord;

import java.util.ArrayList;
import java.util.List;

public class Niveau1 implements I_Niveau {
    private AppDatabase base;
    private EnglishWord recherche;
    public Niveau1(AppDatabase database) {
        base=database;
        //database.getEnglishWordDao().addInfinitif(new EnglishWord("is","est"));
    }

    @Override
    public boolean GenerateGame() {
        recherche=base.getEnglishWordDao().findARandomword();
    return false;
    }

    @Override
    public String[] GetGoodReponce() {
        return new String[]{recherche.getTraduction(),recherche.getEnglishWord()};
    }

    @Override
    public List<String[]> GetBadAnswers() {
        List<EnglishWord> result=  base.getEnglishWordDao().getAllWordWhithoutOne(recherche.getEnglishWord());
        List<String[]>rsultats=new ArrayList<>();
        Log.d("size11",result.size()+"");
        for (int i = 0; i < 3; i++) {
            EnglishWord englishWord = result.get(i);
            rsultats.add(new String[]{ englishWord.getTraduction(),englishWord.getEnglishWord()});
        }


        return rsultats;
    }
}
