package com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil;

public enum ListeTemps {
    //ListeTemps
    PRESENTINDICATIF("Présent de l'indicatif"),
    PASSESIMPLE("Passé Simple"),
    FUTURSIMPLE("Futur Simple"),
    IMPARFAIT("Imparfait");
    private String temps;

    ListeTemps(String temps){
        this.temps = temps;
    }

    public String getTemps(){
        return temps;
    }
}
