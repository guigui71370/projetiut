package com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil;

public enum ListeSujet {

    //ListeSujet
    JE("Je"),
    TU("Tu"),
    IL("Il"),
    NOUS("Nous"),
    VOUS("Vous"),
    ELLES("Elles");

    private String sujet;

    ListeSujet(String sujet){
        this.sujet = sujet;
    }

    public String getSujet(){
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }
}
