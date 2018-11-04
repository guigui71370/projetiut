package com.example.cassa.entrainementprojettut.conjugaison.SetsConjugaison;

import com.example.cassa.entrainementprojettut.conjugaison.Conjugaisons.I_Conjugaison;
import com.example.cassa.entrainementprojettut.conjugaison.Conjugaisons.Phrase;

import static com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil.ListeTemps.PASSESIMPLE;
import static com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil.ListeTemps.PRESENTINDICATIF;

public class SetConjugaisonCE2 implements I_SetConjugaison {
    private I_Conjugaison conjugaison;
    private int groupe;
    private int randomTemps;
    private int nbEtoiles = 4;
    private String temps;

    public SetConjugaisonCE2() {
        this.conjugaison = createASentence();
    }

    public I_Conjugaison getSentence() {
        return conjugaison;
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
        groupe = (int) (1 + (Math.random() * (2))); //1er ou 2e groupe
        randomTemps = (int) (1 + (Math.random() * (2))); //PresentIndicatif ou PasseSimple
        switch (randomTemps){
            case 1:
                temps = PRESENTINDICATIF.getTemps();
                I_Conjugaison iconjugaisonPresentIndicatif= new Phrase(groupe,temps);
                return iconjugaisonPresentIndicatif;
            case 2:
                temps = PASSESIMPLE.getTemps();
                I_Conjugaison iconjugaisonPasseSimple = new Phrase(groupe,temps);
                return iconjugaisonPasseSimple;
            default:
                return null;
        }
    }
}
