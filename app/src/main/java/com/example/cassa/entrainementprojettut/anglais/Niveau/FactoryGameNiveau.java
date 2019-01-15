package com.example.cassa.entrainementprojettut.anglais.Niveau;

import com.example.cassa.entrainementprojettut.database.AppDatabase;

public class FactoryGameNiveau {

    public static I_Niveau generateGameNiveau(int level, AppDatabase database){

        switch (level){
            case 1:
                return new Niveau1(database);
            case 2:
                return new NIVEAU2(database);
            case 3:
                return null;
            case 4:
                return new Niveau4(database);
            default:
                return null;

        }


    }
}
