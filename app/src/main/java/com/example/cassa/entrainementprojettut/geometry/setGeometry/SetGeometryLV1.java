package com.example.cassa.entrainementprojettut.geometry.setGeometry;

import com.example.cassa.entrainementprojettut.geometry.figure.Figure;

import java.util.Random;

public class SetGeometryLV1 implements I_SetGeometry {


    public SetGeometryLV1(){

    }

    @Override
    public String getFalsePropertie(Figure f) {
        return f.getPropertieLV1();
    }

    @Override
    public String getTruePropertie(Figure f) {
        return f.getFalsePropertieLV1();
    }

}
