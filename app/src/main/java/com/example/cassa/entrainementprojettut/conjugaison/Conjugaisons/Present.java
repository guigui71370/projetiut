package com.example.cassa.entrainementprojettut.conjugaison.Conjugaisons;

import static com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonActivity.dao;

public class Present extends Sujet implements I_Conjugaison {

    private String groupe;
    private String sujet;
    private String infinitif;
    private String verbe;
    private String temps="Present de l'indicatif";



    private  int idverbe;
    private int idvbconj;
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
    public int getIdverbe() {
        return idverbe;
    }

    public int getIdvbconj() {
        return idvbconj;
    }
    //Renvoi un verbe à l'infinitif du groupe donné
    private String generateVerbeInfinitif(String groupe){
        return "Voir";
    }

    //Renvoi le verbe conjugué au temps et au sujet donné
    private String getVerbeConjugue(String infinitif, String temps, String sujet) {


        this.idverbe=dao.findidvbinf(1);
        this.idvbconj =dao.findvbcid(1);

        return dao.findvbc(1);
       // return "Vois";
    }

    @Override
    public String displayResult() {
        return verbe;
    }

}
