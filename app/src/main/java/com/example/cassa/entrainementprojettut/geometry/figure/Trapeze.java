package com.example.cassa.entrainementprojettut.geometry.figure;

import com.example.cassa.entrainementprojettut.geometry.GeometryUtil.FigureProperties;
import com.example.cassa.entrainementprojettut.geometry.GeometryUtil.ListFigure;

public class Trapeze extends Quadrilatere {

    public Trapeze(){
        super();
        addProperties();
    }

    private void addProperties() {
        for (FigureProperties foo : FigureProperties.values()) {
            if (foo.getFigureName().equals(ListFigure.TRAPEZE.toString())) {
                this.properties.add(foo.getProperties());
            }
        }
    }

    @Override
    public String getName() {
        return ListFigure.TRAPEZE.toString();
    }
}
