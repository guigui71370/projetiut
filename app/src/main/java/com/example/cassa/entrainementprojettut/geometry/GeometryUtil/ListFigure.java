package com.example.cassa.entrainementprojettut.geometry.GeometryUtil;

import android.support.annotation.NonNull;

public enum ListFigure {
    //Note : Trop chiant les accents :'(

    CARRE("Carré"),
    CERCLE("Cercle"),
    LOSANGE("Losange"),
    PARALELLOGRAMME("Parallélogramme"),
    QUADRILATERE("Quadrilatère"),
    RECTANGLE("Rectangle"),
    TRAPEZE("Trapèze"),
    TRIANGLEI("Triangle Isocèle"),
    TRIANGLEIR("Triangle Isocèle Rectangle"),
    TRIANGLEQ("Triangle Quelconque"),
    TRIANGLER("Triangle Rectangle");

    private String name;
    ListFigure(String name){
        this.name = name;
    }

    @Override
    @NonNull
    public String toString() {
        return this.name;
    }
}
