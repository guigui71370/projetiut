package com.example.cassa.entrainementprojettut.geometry.figure;

import com.example.cassa.entrainementprojettut.geometry.GeometryUtil.FigureProperties;
import com.example.cassa.entrainementprojettut.geometry.GeometryUtil.ListFigure;

import java.util.ArrayList;
import java.util.Random;

public class Carre extends Rectangle {

    protected ArrayList<String> propertiesLV1;
    protected ArrayList<String> propertiesLV2;
    protected ArrayList<String> propertiesLV3;

    protected ArrayList<String> falsePropertiesLV1;
    protected ArrayList<String> falsePropertiesLV2;
    protected ArrayList<String> falsePropertiesLV3;

    Random r;

    public Carre() {
        super();

        r = new Random();

        propertiesLV1 = new ArrayList<String>(super.propertiesLV1);
        propertiesLV1.add(FigureProperties.CARRE_P_1.getProperties());

        propertiesLV2 = new ArrayList<String>(super.propertiesLV2);
        propertiesLV2.add(FigureProperties.CARRE_P_2.getProperties());

        propertiesLV3 = new ArrayList<String>(super.propertiesLV3);
        propertiesLV3.add(FigureProperties.CARRE_P_3.getProperties());

        falsePropertiesLV1 = new ArrayList<String>();
        falsePropertiesLV1.add(FigureProperties.CARRE_FP_0.getProperties());

        falsePropertiesLV2 = new ArrayList<String>();
        falsePropertiesLV2.add(FigureProperties.CARRE_FP_1.getProperties());

        falsePropertiesLV3 = new ArrayList<String>();
        falsePropertiesLV3.add(FigureProperties.CARRE_FP_2.getProperties());
        falsePropertiesLV3.add(FigureProperties.FIGURE_P_2.getProperties() + (this.getAire() + 1 + r.nextInt(5)));


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
        return ListFigure.CARRE.toString();
    }
}
