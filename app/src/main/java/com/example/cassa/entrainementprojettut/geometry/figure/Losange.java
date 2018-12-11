package com.example.cassa.entrainementprojettut.geometry.figure;

import android.util.Log;

import com.example.cassa.entrainementprojettut.geometry.GeometryUtil.FigureProperties;
import com.example.cassa.entrainementprojettut.geometry.GeometryUtil.ListFigure;

import java.util.Random;

import static android.content.ContentValues.TAG;

public class Losange extends Parallelogramme{

    public Losange() {
        super();
        changeCote();
        addProperties();
    }

    private void changeCote(){
        Random r = new Random();
        int sameValues = r.nextInt(11);
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
    public String getName() {
        return ListFigure.LOSANGE.toString();
    }
}
