package com.example.cassa.entrainementprojettut.geometry.setGeometry;

import com.example.cassa.entrainementprojettut.geometry.figure.Figure;

import java.util.Random;

public class SetGeometryLV3 implements I_SetGeometry {

    Random r;

    public SetGeometryLV3(){
        r = new Random();
    }

    @Override
    public String getPropertie(Figure f) {
        if(r.nextBoolean()){
            return f.getFalsePropertieLV3();
        }
        else return f.getPropertieLV3();

    }
}
