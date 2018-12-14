package com.example.cassa.entrainementprojettut.geometry.figure;

import com.example.cassa.entrainementprojettut.geometry.GeometryUtil.FigureProperties;
import com.example.cassa.entrainementprojettut.geometry.GeometryUtil.ListFigure;

public class Parallelogramme extends Quadrilatere{

    public Parallelogramme(){
        super();
        addProperties();
    }

    private void addProperties(){
        for (FigureProperties foo: FigureProperties.values()) {
            if (foo.getFigureName().equals(ListFigure.PARALELLOGRAMME.toString())){
                this.properties.add(foo.getProperties());
            }
        }
    }

    public String getName() {
        return ListFigure.PARALELLOGRAMME.toString();
    }
}
