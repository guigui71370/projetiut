package com.example.cassa.entrainementprojettut.geometry.figure;

import com.example.cassa.entrainementprojettut.geometry.GeometryUtil.FigureProperties;
import com.example.cassa.entrainementprojettut.geometry.GeometryUtil.ListFigure;

import java.util.Random;

public class Rectangle extends Parallelogramme {

    public Rectangle() {
        super();
        changeCote();
        addProperties();
    }

    private void changeCote(){
        Random r = new Random();
        int longueur = r.nextInt(11);
        int largeur = r.nextInt(11);
        for(int i=0;i<this.getCote().length;i++){
            if (i%2 == 0)
                this.getCote()[i] = longueur;
            if (i%2 == 1)
                this.getCote()[i] = largeur;
        }
    }

    private void addProperties()
    {
        for (FigureProperties foo: FigureProperties.values()) {
            if (foo.getFigureName().equals(ListFigure.RECTANGLE.toString())){
                this.properties.add(foo.getProperties());
            }
        }
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

    @Override
    public String getName() {
        return ListFigure.RECTANGLE.toString();
    }
}
