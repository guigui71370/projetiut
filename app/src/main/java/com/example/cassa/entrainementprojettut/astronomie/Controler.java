package com.example.cassa.entrainementprojettut.astronomie;

import android.content.Context;

import java.util.ArrayList;

class Controler {

    private Context context;
    private int list   []=new int[4];
    Bankplanet bank;

    Controler(Context context){
        this.context = context;
        bank = new Bankplanet();
    }

    int calculGoodanswer(){
        int r = (int)(Math.random() * 4);
           list[r] = bank.calculeGoodint();
           return  list[r];
    }

    int[] reponseshufle(){
        ArrayList<Integer> test = bank.calculeotherresponce();
        while (test.size()>0){
            int r=(int)(Math.random() * 4);
            if(list[r]==0){
                list[r] = test.get(0);
                test.remove(0);
            }
        }
        return  list;
    }
}
