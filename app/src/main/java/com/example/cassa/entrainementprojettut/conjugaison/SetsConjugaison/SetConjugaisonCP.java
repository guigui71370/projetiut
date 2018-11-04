package com.example.cassa.entrainementprojettut.conjugaison.SetsConjugaison;

import com.example.cassa.entrainementprojettut.conjugaison.Conjugaisons.I_Conjugaison;
import com.example.cassa.entrainementprojettut.conjugaison.Conjugaisons.Phrase;

import static com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil.ListeTemps.PRESENTINDICATIF;

public class SetConjugaisonCP implements I_SetConjugaison {

    private I_Conjugaison conjugaison;
    private int groupe;
    private int nbEtoiles = 2;
    private String temps;

    public SetConjugaisonCP() {
        this.conjugaison = createASentence();
    }

    @Override
    public String getTempsConjugaison() {
        return conjugaison.getTemps();
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
    public String getComplementConjugaison() {
        return conjugaison.getComplement();
    }

    @Override
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
        groupe = 1; //1er groupe
        temps = PRESENTINDICATIF.getTemps(); //Au present de l'indicatif
        I_Conjugaison iconjugaison = new Phrase(groupe,temps);
        return iconjugaison;
    }
}
