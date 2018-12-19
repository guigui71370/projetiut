package com.example.cassa.entrainementprojettut.geometry.setGeometry;

import com.example.cassa.entrainementprojettut.geometry.figure.Figure;

import java.util.Random;

public class SetGeometryLV3 implements I_SetGeometry {


    public SetGeometryLV3(){

    }

    @Override
    public String getFalsePropertie(Figure f) {
        return f.getPropertieLV3();
    }

    @Override
    public String getTruePropertie(Figure f) {
        return f.getFalsePropertieLV3();
    }
}
