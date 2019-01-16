package com.example.cassa.entrainementprojettut.anglais.mot;

import com.example.cassa.entrainementprojettut.database.AppDatabase;
import com.example.cassa.entrainementprojettut.database.EnglishWord;

public class AddwordDatabase {
    private static AppDatabase database = AppDatabase.getInstanceOfAppDatabase(null);

    public static int database_ajout(){
        database.getEnglishWordDao().removeAllword();
        int iteration=0;
        for (EnglishWord2 word : EnglishWord2.values()) {
            database.getEnglishWordDao().addInfinitif(new EnglishWord(word.getEnglishWord(),word.getTraduction(),word.getIdWord()));
            iteration++;
        }
        return iteration;
    }
}
