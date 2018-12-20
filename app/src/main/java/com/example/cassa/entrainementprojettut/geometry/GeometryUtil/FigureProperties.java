package com.example.cassa.entrainementprojettut.geometry.GeometryUtil;

public enum FigureProperties {

    //Carre
    CARRE_P_1("Je suis un carré"),
    CARRE_P_2("Je possède 4 angles droits et 4 cotés égaux"),
    CARRE_P_3("Je possède des diagonales perpendiculaires qui se coupent en leur milieu"),

    CARRE_FP_0("Je suis un héxagone"),
    CARRE_FP_1("Je possède 4 angles droits et 2 cotés égaux"),
    CARRE_FP_2("Je possède aucun angle droit mais tous mes cotés sont égaux"),

    //Cercle
    CERCLE_P_0("Je suis un cercle"),
    CERCLE_P_1("Mon diamètre est le double de mon rayon"),
    CERCLE_P_2("Le rayon est la distance entre un point du cercle et le centre du cercle ."),
    CERCLE_P_3("Deux points situés sur un même cercle sont situés à égale distance du centre du cercle."),
    CERCLE_P_4("Deux points situés sur un même cercle sont situés à égale distance du centre du cercle."),


    CERCLE_FP_0("Je suis un ovale"),
    CERCLE_FP_1("Mon rayon est le double de mon diamètre"),
    CERCLE_FP_2("Un point su cercle peut être plus éloingné du centre qu'un autre point de ce même cercle"),
    CERCLE_FP_3("Le diamètre est la distance entre un point du cercle et le centre du cercle ."),

    //Losange
    LOSANGE_P_0("Je suis un losange"),
    LOSANGE_P_1("Je possède quatre cotées égaux"),

    LOSANGE_FP_1("Je possède quatre angles droits"),

    //Parallelogramme
    PARALLELOGRAMME_P_ONE(ListFigure.PARALELLOGRAMME.toString()),
    PARALLELOGRAMME_P_TWO(ListFigure.PARALELLOGRAMME.toString()),

    //Quadrilatere
    QUADRILATERE_P_ONE(ListFigure.QUADRILATERE.toString()),
    QUADRILATERE_P_TWO(ListFigure.QUADRILATERE.toString()),

    //Rectangle
    RECTANGLE_P_0("Je suis un rectangle"),
    RECTANGLE_P_1("J'ai quatre angles droits"),
    RECTANGLE_P_2("J'ai mes côtés opposés de même longueur"),
    RECTANGLE_P_3("Mes diagonales se coupent en leurs milieux"),


    RECTANGLE_FP_0("Je suis un carré"),
    RECTANGLE_FP_1("Tous mes cotés sont de la même longueurs"),
    RECTANGLE_FP_2("Mes diagonales sont perpendiculaires"),

    //Trapeze
    TRAPEZE_P_ONE(ListFigure.TRAPEZE.toString()),

    //TriangleI
    TRIANGLEI_P_1("J'ai deux côté de la même longueur"),
    TRIANGLEI_P_2("Je suis un triangle isocèle"),
    TRIANGLEI_P_3("Je suis non équilatéral"),

    TRIANGLEI_FP_1("J'ai trois côté de la même longueur"),
    TRIANGLEI_FP_2("J'ai aucun côté de la même longueur"),
    TRIANGLEI_FP_3("Je possède un angle droit"),

    //TriangleIR
    TRIANGLEIR_P_ONE(ListFigure.TRIANGLEIR.toString()),

    //TriangleQ
    TRIANGLEQ_P_ONE(ListFigure.TRIANGLEQ.toString()),
    TRIANGLEQ_P_TWO(ListFigure.TRIANGLEQ.toString()),

    //TriangleR
    TRIANGLER_P_1("Je possède un angle droit"),
    TRIANGLER_P_2("Je sui un triangle rectangle"),
    TRIANGLER_P_3("Mon aire est égale à la moité d'un rectangle qui a deux côté de même longueurs que les miens"),

    TRIANGLER_FP_1("Je sui un triangle isocèle rectangle"),
    TRIANGLER_FP_2("Je possède deux angles droits"),
    TRIANGLER_FP_3("Mon aire est incalculable"),


    //GENERAL
    FIGURE_P_1("Mon périmètre est égale à "),
    FIGURE_P_2("Mon aire est égale à ");



    private String properties;

    FigureProperties(String name){
        this.properties = properties;
    }
    public String getProperties(){
        return this.properties;
    }
}
