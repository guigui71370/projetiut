package com.example.cassa.entrainementprojettut.histoire.controler;

import com.example.cassa.entrainementprojettut.histoire.factory.factory;


import java.util.List;

public class controleur {
    private factory fact;
    public  controleur(){
        fact=new factory();


    }
    public List<String[]> reponce(int i){

       return fact.factory(i).getReponce();
    }

}
