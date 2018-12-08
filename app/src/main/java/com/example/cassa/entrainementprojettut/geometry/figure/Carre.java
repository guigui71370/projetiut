package com.example.cassa.entrainementprojettut.geometry.figure;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.cassa.entrainementprojettut.geometry.FigureProperties;

import java.util.ArrayList;
import java.util.Random;

public class Carre extends Rectangle {

    private final static int NBCOTE = 4;
    private int[] cote;
    public Carre() {
        super();
    }

    public int[] getCote() {
        return generateRandomCote();
    }

    public int[] generateRandomCote(){
        Random r = new Random();
        int randomValues = r.nextInt(11);
        int[] arrayValues = new int[4];
        for(int i=0;i<NBCOTE;i++){
            arrayValues[i] = randomValues;
        }
        return arrayValues;
    }

    @Override
    public int getAire() {
        return 0;
    }

    @Override
    public void draw(Canvas canvas) {
    }

    @Override
    public ArrayList<FigureProperties> getProperties() {
        return null;
    }

    @Override
    public String getName() {
        return "Carré";
    }
}
