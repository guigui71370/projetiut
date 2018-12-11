package com.example.cassa.entrainementprojettut.geometry.GeometryUtil;

public enum FigureProperties {
    //Quadrilatere
    QUADRILATERE_P_ONE(ListFigure.QUADRILATERE.toString(),"Je suis un quadrilatère"),
    QUADRILATERE_P_TWO(ListFigure.QUADRILATERE.toString(),"J'ai 4 côtés");

    private String properties;
    private String name;

    FigureProperties(String name, String properties){
        this.name = name;
        this.properties = properties;
    }

    public String getFigureName(){
        return this.name;
    }
    public String getProperties(){
        return this.properties;
    }
}
