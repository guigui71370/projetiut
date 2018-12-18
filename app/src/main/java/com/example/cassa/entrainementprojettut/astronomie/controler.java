package com.example.cassa.entrainementprojettut.astronomie;

import android.content.Context;
import android.content.res.Resources;

import com.example.cassa.entrainementprojettut.R;

import java.util.ArrayList;



public class controler {


    private Context context;
    private int list   []=new int[4];
    Bankplanet banck;
    public controler(Context context){
        this.context=context;
        banck=new Bankplanet();
    }
    public int calculGoodanswer(){
        int r=(int)(Math.random() * 4);
           list[r]=banck.calculeGoodint();

           return  list[r];

    }

    public int[]reponceshufle(){
        ArrayList<Integer> test=banck.calculeotherresponce();
         while ( test.size()>0){
             int r=(int)(Math.random() * 4);
             if(list[r]==0){
                 list[r]=test.get(0);
                 test.remove(0);
             }

         }


        return  list;
    }

  //  String test=   context.getResources().getResourceEntryName(R.drawable.mercury);


}
