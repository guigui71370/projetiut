package com.example.cassa.entrainementprojettut.conjugaison.Conjugaisons;

public interface I_Conjugaison {
    String getTemps();
    String getSujet();
    String getVerbe();
    int getGroupeVerbe();
    String getComplement();
    String getInfinitif();
    Competence getCompetence();
}
