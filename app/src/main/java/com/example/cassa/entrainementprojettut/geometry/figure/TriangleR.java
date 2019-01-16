package com.example.cassa.entrainementprojettut.geometry.figure;

import com.example.cassa.entrainementprojettut.geometry.GeometryUtil.FigureProperties;
import com.example.cassa.entrainementprojettut.geometry.GeometryUtil.ListFigure;

import java.util.ArrayList;
import java.util.Random;

public class TriangleR extends TriangleQ {


    protected ArrayList<String> propertiesLV1;
    protected ArrayList<String> propertiesLV2;
    protected ArrayList<String> propertiesLV3;

    protected ArrayList<String> falsePropertiesLV1;
    protected ArrayList<String> falsePropertiesLV2;
    protected ArrayList<String> falsePropertiesLV3;

    int petitCote;
    int autreCote;
    Random r;

    public TriangleR(){
        r = new Random();

        changeCote();

        propertiesLV1 = new ArrayList<String>();
        propertiesLV1.add(FigureProperties.TRIANGLER_P_1.getProperties());

        propertiesLV2 = new ArrayList<String>();
        propertiesLV2.add(FigureProperties.TRIANGLER_P_2.getProperties());
        propertiesLV2.add(FigureProperties.FIGURE_P_1.getProperties() + getPerimetre());

        propertiesLV3 = new ArrayList<String>();
        propertiesLV3.add(FigureProperties.TRIANGLER_P_3.getProperties());

        falsePropertiesLV1 = new ArrayList<String>();
        falsePropertiesLV1.add(FigureProperties.TRIANGLER_FP_1.getProperties());

        falsePropertiesLV2 = new ArrayList<String>();
        falsePropertiesLV2.add(FigureProperties.TRIANGLER_FP_2.getProperties());
        propertiesLV2.add(FigureProperties.FIGURE_P_1.getProperties() + (getPerimetre())
                + r.nextInt(4));

        falsePropertiesLV3 = new ArrayList<String>();
        falsePropertiesLV3.add(FigureProperties.TRIANGLER_FP_3.getProperties());
    }


    private void changeCote(){
        do {
             petitCote = r.nextInt(6) + 5;
             autreCote = r.nextInt(6) + 5;
            int hypothenuse = (int) Math.round(Math.sqrt(petitCote * petitCote + autreCote * autreCote) * 1000) / 1000;
            this.getCote()[0] = petitCote;
            this.getCote()[1] = autreCote;
            this.getCote()[2] = hypothenuse;
        }while(petitCote==autreCote);
    }

    @Override
    public String getName() {
        return ListFigure.TRIANGLER.toString();
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
}
