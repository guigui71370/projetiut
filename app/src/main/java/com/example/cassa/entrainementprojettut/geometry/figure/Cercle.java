package com.example.cassa.entrainementprojettut.geometry.figure;

import com.example.cassa.entrainementprojettut.geometry.GeometryUtil.FigureProperties;
import com.example.cassa.entrainementprojettut.geometry.GeometryUtil.ListFigure;

import java.util.ArrayList;
import java.util.Random;

public class Cercle extends Figure {
    private int rayon;
    private int diametre = 2 * rayon;

    protected ArrayList<String> propertiesLV1;
    protected ArrayList<String> propertiesLV2;
    protected ArrayList<String> propertiesLV3;

    protected ArrayList<String> falsePropertiesLV1;
    protected ArrayList<String> falsePropertiesLV2;
    protected ArrayList<String> falsePropertiesLV3;

    Random r;

    public Cercle() {

        r = new Random();

        propertiesLV1 = new ArrayList<String>();
        propertiesLV1.add(FigureProperties.CERCLE_P_0.getProperties());

        propertiesLV2 = new ArrayList<String>();
        propertiesLV2.add(FigureProperties.CERCLE_P_1.getProperties());

        propertiesLV3 = new ArrayList<String>();
        propertiesLV3.add(FigureProperties.CERCLE_P_2.getProperties());
        propertiesLV3.add(FigureProperties.CERCLE_P_3.getProperties() + this.getAire());

        falsePropertiesLV1 = new ArrayList<String>();
        falsePropertiesLV1.add(FigureProperties.CERCLE_FP_0.getProperties());

        falsePropertiesLV2 = new ArrayList<String>();
        falsePropertiesLV2.add(FigureProperties.CERCLE_FP_1.getProperties());

        falsePropertiesLV3 = new ArrayList<String>();
        falsePropertiesLV3.add(FigureProperties.CERCLE_FP_2.getProperties());
        falsePropertiesLV3.add(FigureProperties.CERCLE_FP_3.getProperties());



        this.rayon = generateRandomRayon();
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
        return ListFigure.CERCLE.toString();
    }
}
