package com.example.cassa.entrainementprojettut.astronomie;

import com.example.cassa.entrainementprojettut.R;

import java.util.ArrayList;

public class Bankplanet {

    private ArrayList<Integer> listplanet=new ArrayList<Integer>();
    private int goodint;

    public  Bankplanet(){

        listplanet.add(R.drawable.mercury);
        listplanet.add(R.drawable.venus);
        listplanet.add(R.drawable.earth);
        listplanet.add(R.drawable.mars);
        listplanet.add(R.drawable.jupiter);
        listplanet.add(R.drawable.saturn);
        listplanet.add(R.drawable.uranus);
        listplanet.add(R.drawable.neptune);
    }


    public int calculeGoodint(){
        int r=(int)(Math.random() * listplanet.size());

        goodint=this.listplanet.get(r);
        return listplanet.get(r);

    }


    public  ArrayList<Integer> calculeotherresponce(){

        ArrayList<Integer> selectioner=new ArrayList<Integer>();
        while (selectioner.size()!=3){
            int r=(int)(Math.random() * listplanet.size());
            if(goodint!=listplanet.get(r) && !selectioner.contains(listplanet.get(r))){
                selectioner.add(listplanet.get(r));
            }
        }

       // goodint=this.listplanet.get(r);
        return selectioner;

    }






}
