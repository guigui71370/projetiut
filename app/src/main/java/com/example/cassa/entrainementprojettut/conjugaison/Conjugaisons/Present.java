package com.example.cassa.entrainementprojettut.conjugaison.Conjugaisons;

public class Present extends Sujet implements I_Conjugaison {

    private String groupe;
    private String sujet;
    private String infinitif;
    private String verbe;
    private String temps="Present de l'indicatif";

    public Present(String groupe){
        this.groupe = groupe;
        this.sujet = generateSujet();
        this.infinitif = generateVerbeInfinitif(groupe);
        this.verbe = getVerbeConjugue(infinitif,temps,sujet);
    }

    @Override
    public String getSujet() {
        return sujet;
    }

    @Override
    public String getVerbe() {
        return verbe;
    }

    @Override
    public String getTemps() {
        return temps;
    }

    @Override
    public String getInfinitif(){
        return infinitif;
    }

    //Renvoi un verbe à l'infinitif du groupe donné
    private String generateVerbeInfinitif(String groupe){
        return "Voir";
    }

    //Renvoi le verbe conjugué au temps et au sujet donné
    private String getVerbeConjugue(String infinitif, String temps, String sujet) {
        return "Vois";
    }

    @Override
    public String displayResult() {
        return verbe;
    }

}
