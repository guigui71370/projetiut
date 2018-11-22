package com.example.cassa.entrainementprojettut.conjugaison.SetsConjugaison;

import com.example.cassa.entrainementprojettut.conjugaison.Conjugaisons.Competence;
import com.example.cassa.entrainementprojettut.conjugaison.Conjugaisons.I_Conjugaison;

import java.util.ArrayList;

public interface I_SetConjugaison {

        void createASentence();

        String getTempsConjugaison();

        String getSujetConjugaison();

        String getVerbeConjugaison();

        String getComplementConjugaison();

        String getInfinitifConjugaison();

        ArrayList<Competence> getListCompetence();

        Competence getCompetence();

        boolean succedCompetence();

        void removeCompetence();
}
