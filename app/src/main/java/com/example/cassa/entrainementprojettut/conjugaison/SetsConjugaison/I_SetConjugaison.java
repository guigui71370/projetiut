package com.example.cassa.entrainementprojettut.conjugaison.SetsConjugaison;

import com.example.cassa.entrainementprojettut.conjugaison.Conjugaisons.I_Conjugaison;

public interface I_SetConjugaison {

        I_Conjugaison createASentence();

        I_Conjugaison getSentence();

        String getSujetConjugaison();

        String getVerbeConjugaison();

        String getTempsConjugaison();

        String getInfinitifConjugaison();

        int getNbEtoiles();
}
