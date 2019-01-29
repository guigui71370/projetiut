package com.example.cassa.entrainementprojettut.geometry.figure;

import android.util.Log;

import com.example.cassa.entrainementprojettut.geometry.GeometryUtil.FigureProperties;
import com.example.cassa.entrainementprojettut.geometry.GeometryUtil.ListFigure;

import java.util.ArrayList;
import java.util.Random;

public class TriangleI extends TriangleQ {

    protected ArrayList<String> propertiesLV1;
    protected ArrayList<String> propertiesLV2;
    protected ArrayList<String> propertiesLV3;

    protected ArrayList<String> falsePropertiesLV1;
    protected ArrayList<String> falsePropertiesLV2;
    protected ArrayList<String> falsePropertiesLV3;

    int petitCote;
    int base;
    Random r;

    public TriangleI(){

        r = new Random();
        changeCote();
        propertiesLV1 = new ArrayList<String>();
        propertiesLV1.add(FigureProperties.TRIANGLEI_P_1.getProperties());

        propertiesLV2 = new ArrayList<String>();
        propertiesLV2.add(FigureProperties.TRIANGLEI_P_2.getProperties());
        propertiesLV2.add(FigureProperties.FIGURE_P_1.getProperties() + getPerimetre());

        propertiesLV3 = new ArrayList<String>();
        propertiesLV3.add(FigureProperties.TRIANGLEI_P_3.getProperties());

        falsePropertiesLV1 = new ArrayList<String>();
        falsePropertiesLV1.add(FigureProperties.TRIANGLEI_FP_1.getProperties());

        falsePropertiesLV2 = new ArrayList<String>();
        falsePropertiesLV2.add(FigureProperties.TRIANGLEI_FP_2.getProperties());
        falsePropertiesLV2.add(FigureProperties.FIGURE_P_1.getProperties() + (getPerimetre()+1+ r.nextInt(4)));

        falsePropertiesLV3 = new ArrayList<String>();
        falsePropertiesLV3.add(FigureProperties.TRIANGLEI_FP_3.getProperties());
    }
    private void changeCote(){
        do {
             petitCote = r.nextInt(6) + 5;
             base = r.nextInt(6) + 5;
            this.getCote()[0] = petitCote;
            this.getCote()[1] = petitCote;
            this.getCote()[2] = base;
        }while(petitCote==base);
    }

    @Override
    public String getName() {
        return ListFigure.TRIANGLEI.toString();
    }


    @Override
    public String getPropertieLV1() {
        String s = propertiesLV1.get(r.nextInt(propertiesLV1.size()));
        Log.d("geom88TRU",s);
        return s;
    }

    @Override
    public String getPropertieLV2() {
        String s = propertiesLV2.get(r.nextInt(propertiesLV2.size()));
        Log.d("geom88TRU",s);
        return   s;
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


