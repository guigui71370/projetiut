package com.example.cassa.entrainementprojettut.geometry.setGeometry;

import com.example.cassa.entrainementprojettut.geometry.figure.Figure;

import java.util.Random;

public class SetGeometryLV1 implements I_SetGeometry {

    Random r;

    public SetGeometryLV1(){
        r = new Random();
    }

    @Override
    public String getPropertie(Figure f) {
        if(r.nextBoolean()){
            return f.getFalsePropertieLV1();
        }
        else return f.getPropertieLV1();

    }

}
