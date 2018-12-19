package com.example.cassa.entrainementprojettut.geometry.figure;

import com.example.cassa.entrainementprojettut.geometry.GeometryUtil.FigureProperties;
import com.example.cassa.entrainementprojettut.geometry.GeometryUtil.ListFigure;

import java.util.Random;

public class Losange extends Parallelogramme{

    public Losange() {
        super();
        changeCote();
        addProperties();
    }

    private void changeCote(){
        Random r = new Random();
        int sameValues = r.nextInt(10)+1;
        for(int i=0;i<this.getCote().length;i++){
            this.getCote()[i] = sameValues;
        }
    }

    private void addProperties() {
        for (FigureProperties foo: FigureProperties.values()) {
            if (foo.getFigureName().equals(ListFigure.LOSANGE.toString())){
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
        return ListFigure.LOSANGE.toString();
    }
}
