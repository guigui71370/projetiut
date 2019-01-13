package com.example.cassa.entrainementprojettut.anglais.controller;

import java.util.ArrayList;
import java.util.List;

public class ControllerEnglish {

    public ControllerEnglish(int diff){

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
