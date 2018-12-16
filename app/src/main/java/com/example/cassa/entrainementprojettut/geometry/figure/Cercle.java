package com.example.cassa.entrainementprojettut.geometry.figure;

import com.example.cassa.entrainementprojettut.geometry.GeometryUtil.FigureProperties;
import com.example.cassa.entrainementprojettut.geometry.GeometryUtil.ListFigure;

import java.util.ArrayList;
import java.util.Random;

public class Cercle extends Figure {
    private int rayon;
    private int diametre = 2 * rayon;
    private ArrayList<String> properties = new ArrayList<>();

    public Cercle(){
        this.rayon = generateRandomRayon();
        addProperties();
    }

    public int getRayon() {
        return this.rayon;
    }

    @Override
    public int[] getCote() {
        int[] arrayValues = new int[1];
        arrayValues[0] = rayon;
        return arrayValues;
    }

    private int generateRandomRayon(){
        Random r = new Random();
        return r.nextInt(11);
    }

    @Override
    public float getAire() {
        double aire = this.rayon*this.rayon*3.14;
        return (float)aire;
    }

    @Override
    public float getPerimetre() {
        double perimetre = this.diametre*3.14;
        return (float)perimetre;
    }

    @Override
    public ArrayList<String> getProperties(){
        return this.properties;
    }

    private void addProperties()
    {
        for (FigureProperties foo: FigureProperties.values()) {
            if (foo.getFigureName().equals(ListFigure.CERCLE.toString())){
                this.properties.add(foo.getProperties());
            }
        }
    }

    @Override
    public String getName() {
        return ListFigure.CERCLE.toString();
    }
}
