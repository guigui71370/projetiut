package com.example.cassa.entrainementprojettut.anglais.controller;

import com.example.cassa.entrainementprojettut.anglais.Niveau.FactoryGameNiveau;
import com.example.cassa.entrainementprojettut.anglais.Niveau.I_Niveau;
import com.example.cassa.entrainementprojettut.database.AppDatabase;

import java.util.ArrayList;
import java.util.List;

public class ControllerEnglish {
    I_Niveau game;
    public ControllerEnglish(int diff, final AppDatabase database){
        game=FactoryGameNiveau.generateGameNiveau(diff,database);
        game.GenerateGame();
    }


    public String getQuestion(){
        return "aurevoir";
    }

    public String[] getTrueanswsers(){
        return new String[]{"good-bye","aurevoir"};
    }

    public List<String[]> GetFalseAnswsers(){
        String i[]={"22","22"};
        ArrayList<String[]> result=new ArrayList<>();
        result.add(i);
        result.add(i);
        result.add(i);
        return result;
    }




}

