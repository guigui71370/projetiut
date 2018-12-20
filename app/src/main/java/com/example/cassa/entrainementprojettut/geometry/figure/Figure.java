package com.example.cassa.entrainementprojettut.geometry.figure;
import java.util.ArrayList;

public abstract class Figure {

    abstract int getAire();
    abstract int getPerimetre();


    //Les cotes pas le nombre de côtés
    public abstract int[] getCote();

    public abstract String getPropertieLV1();

    public abstract String getPropertieLV2();

    public abstract String getPropertieLV3();

    public abstract String getFalsePropertieLV1();

    public abstract String getFalsePropertieLV2();

    public abstract String getFalsePropertieLV3();

    public abstract String getName();
}
