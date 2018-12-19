package com.example.cassa.entrainementprojettut.geometry.figure;

import com.example.cassa.entrainementprojettut.geometry.GeometryUtil.FigureProperties;
import com.example.cassa.entrainementprojettut.geometry.GeometryUtil.ListFigure;

public class Carre extends Losange {

    public Carre() {
        super();
        addProperties();
    }

    private void addProperties(){
        for (FigureProperties foo: FigureProperties.values()) {
            if (foo.getFigureName().equals(ListFigure.CARRE.toString())){
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
        return ListFigure.CARRE.toString();
    }
}
