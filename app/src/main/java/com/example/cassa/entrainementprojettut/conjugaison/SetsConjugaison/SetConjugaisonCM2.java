package com.example.cassa.entrainementprojettut.conjugaison.SetsConjugaison;

import com.example.cassa.entrainementprojettut.conjugaison.Conjugaisons.I_Conjugaison;
import com.example.cassa.entrainementprojettut.conjugaison.Conjugaisons.Present;

public class SetConjugaisonCM2 implements I_SetConjugaison{
    private I_Conjugaison conjugaison;
    private String groupe = "Groupe1";
    private int nbEtoiles = 6;

    public SetConjugaisonCM2() {
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

    @Override
    public int getNbEtoiles() {
        return nbEtoiles;
    }

    public String getInfinitifConjugaison(){
        return conjugaison.getInfinitif();
    }
    @Override
    public int getidinf() {
        return this.conjugaison.getIdverbe();
    }

    @Override
    public int getidvbc() {
        return this.conjugaison.getIdvbconj();
    }
    public I_Conjugaison createASentence() {
        return generateConjugaison();
    }

    private I_Conjugaison generateConjugaison() {
        I_Conjugaison iconjugaison = new Present(groupe);
        return iconjugaison;
    }
}
