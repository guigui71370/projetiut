package com.example.cassa.entrainementprojettut.geometry.figure;

import com.example.cassa.entrainementprojettut.geometry.GeometryUtil.FigureProperties;
import com.example.cassa.entrainementprojettut.geometry.GeometryUtil.ListFigure;

import java.util.ArrayList;
import java.util.Random;

public class Quadrilatere extends Figure {
    private final static int NBCOTE = 4;
    private int[] cote;
    ArrayList<String> properties = new ArrayList<>();

    public Quadrilatere(){
        cote = generateRandomCote();
    }

    public int[] getCote() {
        return this.cote;
    }

    @Override
    public String getPropertieLV1() {
        return null;
    }

    @Override
    public String getPropertieLV2() {
        return null;
    }

    @Override
    public String getPropertieLV3() {
        return null;
    }

    @Override
    public String getFalsePropertieLV1() {
        return null;
    }

    @Override
    public String getFalsePropertieLV2() {
        return null;
    }

    @Override
    public String getFalsePropertieLV3() {
        return null;
    }

    private int[] generateRandomCote(){
        Random r = new Random();
        int[] arrayValues = new int[NBCOTE];
        for(int i=0;i<NBCOTE;i++){
            arrayValues[i] = r.nextInt(10)+1;
        }
        return arrayValues;
    }

    public float getAire() {
        return this.cote[0] * this.cote[1];
    }

    @Override
    public float getPerimetre() {
        return this.cote[0] + this.cote[1] + this.cote[2] + this.cote[3];
    }

    public ArrayList<String> getProperties(){
        return this.properties;
    }


    @Override
    public String getName() {
        return ListFigure.QUADRILATERE.toString();
    }
}
