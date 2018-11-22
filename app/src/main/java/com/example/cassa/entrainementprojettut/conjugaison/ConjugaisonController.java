package com.example.cassa.entrainementprojettut.conjugaison;

import com.example.cassa.entrainementprojettut.conjugaison.Conjugaisons.Competence;
import com.example.cassa.entrainementprojettut.conjugaison.SetsConjugaison.I_SetConjugaison;

import java.util.ArrayList;

public class ConjugaisonController {

    private I_SetConjugaison setConjugaison;


    public ConjugaisonController(int diff) {
        FactorySetConjugaison factorySetOperation =new FactorySetConjugaison();
        setConjugaison=factorySetOperation.createSetConjugaison(diff);
    }

    public String getTempsConjugaison(){
            return setConjugaison.getTempsConjugaison();
        }

    public String getSujetConjugaison(){
        return setConjugaison.getSujetConjugaison();
    }

    public String getVerbeConjugaison(){
            return setConjugaison.getVerbeConjugaison();
        }

    public String getComplementConjugaison() {
            return setConjugaison.getComplementConjugaison();
    }

    public String getInfinitifConjugaison() {
            return setConjugaison.getInfinitifConjugaison();
        }

    public ArrayList<Competence> getListCompetence(){
        return setConjugaison.getListCompetence();
    }

    public Competence getCompetence(){
        return setConjugaison.getCompetence();
    }

    public void nextSentence(){
        setConjugaison.createASentence();
    }

    public boolean succedCompetence(){
        return setConjugaison.succedCompetence();
    }

    public void removeCompetence(){
        setConjugaison.removeCompetence();
    }
}
