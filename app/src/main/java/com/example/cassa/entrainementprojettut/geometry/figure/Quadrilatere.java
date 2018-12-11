package com.example.cassa.entrainementprojettut.geometry.figure;

import android.util.Log;

import com.example.cassa.entrainementprojettut.geometry.GeometryUtil.FigureProperties;
import com.example.cassa.entrainementprojettut.geometry.GeometryUtil.ListFigure;

import java.util.ArrayList;
import java.util.Random;

import static android.content.ContentValues.TAG;

public class Quadrilatere extends Figure {
    private final static int NBCOTE = 4;
    private int[] cote;
    ArrayList<String> properties = new ArrayList<>();

    public Quadrilatere(){
        cote = generateRandomCote();
        addProperties();
    }

    public int[] getCote() {
        return this.cote;
    }

    private int[] generateRandomCote(){
        Random r = new Random();
        int[] arrayValues = new int[NBCOTE];
        for(int i=0;i<NBCOTE;i++){
            arrayValues[i] = r.nextInt(11);
        }
        return arrayValues;
    }

    @Override
    public float getAire() {
        return this.cote[0] * this.cote[1];
    }

    @Override
    public float getPerimetre() {
        return this.cote[0] + this.cote[1] + this.cote[2] + this.cote[3];
    }

    @Override
    public ArrayList<String> getProperties(){
        return this.properties;
    }

    private void addProperties() {
        for (FigureProperties foo: FigureProperties.values()) {
            if (foo.getFigureName().equals(ListFigure.QUADRILATERE.toString())){
                properties.add(foo.getProperties());
            }
        }
    }

    @Override
    public String getName() {
        return ListFigure.QUADRILATERE.toString();
    }
}
