package com.example.cassa.entrainementprojettut.geometry.figure;
import java.util.ArrayList;

public abstract class Figure {

    abstract float getAire();
    abstract float getPerimetre();

    //Les cotes pas le nombre de côtés
    public abstract int[] getCote();

    public abstract ArrayList<String> getProperties();

    public abstract String getName();
}
