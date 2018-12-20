package com.example.cassa.entrainementprojettut.geometry.figure;

import com.example.cassa.entrainementprojettut.geometry.GeometryUtil.FigureProperties;
import com.example.cassa.entrainementprojettut.geometry.GeometryUtil.ListFigure;

import java.util.ArrayList;
import java.util.Random;

public class Rectangle extends Parallelogramme {

    protected ArrayList<String> propertiesLV1;
    protected ArrayList<String> propertiesLV2;
    protected ArrayList<String> propertiesLV3;

    protected ArrayList<String> falsePropertiesLV1;
    protected ArrayList<String> falsePropertiesLV2;
    protected ArrayList<String> falsePropertiesLV3;

    Random r;
    int longueur;
    int largeur;

    public Rectangle() {
        super();
        changeCote();

        propertiesLV1 = new ArrayList<String>();
        propertiesLV1.add(FigureProperties.RECTANGLE_P_0.getProperties());

        propertiesLV2 = new ArrayList<String>();
        propertiesLV2.add(FigureProperties.RECTANGLE_P_1.getProperties());
        propertiesLV2.add(FigureProperties.RECTANGLE_P_2.getProperties());
        propertiesLV2.add(FigureProperties.FIGURE_P_1.getProperties() + getPerimetre());

        propertiesLV3 = new ArrayList<String>();
        propertiesLV3.add(FigureProperties.RECTANGLE_P_3.getProperties());
        propertiesLV3.add(FigureProperties.FIGURE_P_2.getProperties() + this.getAire());

        falsePropertiesLV1 = new ArrayList<String>();
        falsePropertiesLV1.add(FigureProperties.RECTANGLE_FP_0.getProperties());

        falsePropertiesLV2 = new ArrayList<String>();
        falsePropertiesLV2.add(FigureProperties.RECTANGLE_FP_1.getProperties());
        falsePropertiesLV2.add(FigureProperties.FIGURE_P_1.getProperties() + getPerimetre()
                + (this.getPerimetre() + 1 + r.nextInt(5)));

        falsePropertiesLV3 = new ArrayList<String>();
        falsePropertiesLV3.add(FigureProperties.RECTANGLE_FP_2.getProperties());
        falsePropertiesLV3.add(FigureProperties.FIGURE_P_2.getProperties()
                + this.getAire() + 1 + r.nextInt(5));


    }

    private void changeCote(){
        longueur = r.nextInt(11);
        largeur = r.nextInt(11);
        for(int i=0;i<this.getCote().length;i++){
            if (i%2 == 0)
                this.getCote()[i] = longueur;
            if (i%2 == 1)
                this.getCote()[i] = largeur;
        }
    }

    @Override
    public float getAire() {
        return largeur*longueur;
    }

    @Override
    public float getPerimetre() {
        return largeur*2 + 2*longueur;
    }

    @Override
    public String getPropertieLV1() {
        return propertiesLV1.get(r.nextInt(propertiesLV1.size()));
    }

    @Override
    public String getPropertieLV2() {
        return propertiesLV2.get(r.nextInt(propertiesLV2.size()));
    }

    @Override
    public String getPropertieLV3() {
        return propertiesLV3.get(r.nextInt(propertiesLV3.size()));
    }

    @Override
    public String getFalsePropertieLV1() {
        return falsePropertiesLV1.get(r.nextInt(falsePropertiesLV1.size()));
    }

    @Override
    public String getFalsePropertieLV2() {
        return falsePropertiesLV2.get(r.nextInt(falsePropertiesLV2.size()));
    }

    @Override
    public String getFalsePropertieLV3() {
        return falsePropertiesLV3.get(r.nextInt(falsePropertiesLV3.size()));
    }

    @Override
    public String getName() {
        return ListFigure.RECTANGLE.toString();
    }
}
