package com.example.cassa.entrainementprojettut.conjugaison.SetsConjugaison;

import com.example.cassa.entrainementprojettut.conjugaison.Conjugaisons.I_Conjugaison;
import com.example.cassa.entrainementprojettut.conjugaison.Conjugaisons.Present;

public class SetConjugaisonCM1 implements I_SetConjugaison {
    private I_Conjugaison conjugaison;
    private String groupe = "Groupe1";
    private int nbEtoiles = 5;

    public SetConjugaisonCM1() {
        this.conjugaison = createASentence();
    }

    public I_Conjugaison getSentence() {
        return conjugaison;
    }

    @Override
    public String getSujetConjugaison() {
        return conjugaison.getSujet();
    }

    @Override
    public String getVerbeConjugaison() {
        return conjugaison.getVerbe();
    }

    @Override
    public String getTempsConjugaison() {
        return conjugaison.getTemps();
    }

    public int getNbEtoiles() {
        return nbEtoiles;
    }

    public String getInfinitifConjugaison(){
        return conjugaison.getInfinitif();
    }

    public I_Conjugaison createASentence() {
        return generateConjugaison();
    }

    private I_Conjugaison generateConjugaison() {
        I_Conjugaison iconjugaison = new Present(groupe);
        return iconjugaison;
    }
}
