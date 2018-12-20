package com.example.cassa.entrainementprojettut.geometry.figure;

import com.example.cassa.entrainementprojettut.geometry.GeometryUtil.FigureProperties;
import com.example.cassa.entrainementprojettut.geometry.GeometryUtil.ListFigure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class TriangleQ extends Figure {
    private final static int NBCOTE = 3;
    private int[] cote;
    private float hauteur;
    ArrayList<String> properties = new ArrayList<>();

    public TriangleQ(){
        this.cote = generateRandomCote();
        this.hauteur = caculHauteur();
    }

    private float caculHauteur(){
        Arrays.sort(this.cote);
        int petitCote = cote[0];
        int autreCote = cote[1];
        int hypotenuse = cote[2];
        double x = (petitCote*petitCote - autreCote*autreCote + hypotenuse*hypotenuse)/(2*hypotenuse);
        double hauteur = Math.sqrt(hypotenuse*hypotenuse - (x*x));
        return (float) hauteur;
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

    @Override
    public float getAire() {
        return 0;
    }

    @Override
    public float getPerimetre() {
        return this.cote[0] + this.cote[1] + this.cote[2];
    }

    public ArrayList<String> getProperties(){
        return this.properties;
    }


    @Override
    public String getName() {
        return ListFigure.TRIANGLEQ.toString();
    }
}
