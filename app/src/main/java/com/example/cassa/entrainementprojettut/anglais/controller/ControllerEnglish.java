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
        return  game.GetGoodReponce()[1];
    }

    public String[] getTrueanswsers(){

        return  game.GetGoodReponce();

        //return new String[]{"good-bye","aurevoir"};



    }

    public List<String[]> GetFalseAnswsers(){
        String i[]={"22","22"};
        List<String[]> result=new ArrayList<>();
        result.add(i);
        result.add(i);
        result.add(i);

        result=game.GetBadAnswers();


        return result;
    }




}

