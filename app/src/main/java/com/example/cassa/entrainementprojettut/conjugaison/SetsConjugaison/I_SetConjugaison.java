package com.example.cassa.entrainementprojettut.conjugaison.SetsConjugaison;

import com.example.cassa.entrainementprojettut.conjugaison.Conjugaisons.I_Conjugaison;

public interface I_SetConjugaison {

        I_Conjugaison createASentence();

        String getTempsConjugaison();

        String getSujetConjugaison();

        String getVerbeConjugaison();

        String getComplementConjugaison();

        String getInfinitifConjugaison();

        int getNbEtoiles();
}
