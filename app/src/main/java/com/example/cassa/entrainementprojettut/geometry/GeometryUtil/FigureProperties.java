package com.example.cassa.entrainementprojettut.geometry.GeometryUtil;

public enum FigureProperties {

    //Carre
    CARRE_P_ONE(ListFigure.CARRE.toString(),"Je possède quatre angles droits"),

    //Cercle
    CERCLE_P_ONE(ListFigure.CERCLE.toString(),"Mon diamètre est le double de mon rayon"),

    //Losange
    LOSANGE_P_ONE(ListFigure.LOSANGE.toString(),"Tous mes côtés sont égaux"),

    //Parallelogramme
    PARALLELOGRAMME_P_ONE(ListFigure.PARALELLOGRAMME.toString(),"Mes diagonales se coupent en leurs milieux"),
    PARALLELOGRAMME_P_TWO(ListFigure.PARALELLOGRAMME.toString(),"J'ai quatres côtés opposés parrallèles"),

    //Quadrilatere
    QUADRILATERE_P_ONE(ListFigure.QUADRILATERE.toString(),"Je suis un quadrilatère"),
    QUADRILATERE_P_TWO(ListFigure.QUADRILATERE.toString(),"J'ai quatre côtés"),

    //Rectangle
    RECTANGLE_P_ONE(ListFigure.RECTANGLE.toString(),"Je possède quatre angles droits"),

    //Trapeze
    TRAPEZE_P_ONE(ListFigure.TRAPEZE.toString(),"J'ai deux côtés opposés parrallèles"),

    //TriangleI
    TRIANGLEI_P_ONE(ListFigure.TRIANGLEI.toString(),"J'ai deux côtés de même longueur"),

    //TriangleIR
    TRIANGLEIR_P_ONE(ListFigure.TRIANGLEIR.toString(),"J'ai un angle droit"),

    //TriangleQ
    TRIANGLEQ_P_ONE(ListFigure.TRIANGLEQ.toString(),"J'ai trois côtés"),
    TRIANGLEQ_P_TWO(ListFigure.TRIANGLEQ.toString(),"La somme de mes angles est de 180°"),

    //TriangleR
    TRIANGLER_P_ONE(ListFigure.TRIANGLEIR.toString(),"J'ai un angle droit");


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
