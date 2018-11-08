package com.example.cassa.entrainementprojettut.conjugaison.Conjugaisons;

import com.example.cassa.entrainementprojettut.database.AppDatabase;

import java.util.ArrayList;
import java.util.Random;

import static com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil.ListeSujet.ELLES;
import static com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil.ListeSujet.IL;
import static com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil.ListeSujet.JE;
import static com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil.ListeSujet.NOUS;
import static com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil.ListeSujet.TU;
import static com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil.ListeSujet.VOUS;

public class Phrase implements I_Conjugaison {
    private String sujet;
    private String verbe;
    private int groupeVerbe;
    private String complement;
    private String infinitif;
    private String temps;
    private Competence competence;
    private AppDatabase db = AppDatabase.getInstanceOfAppDatabase(null);

    public Phrase(Competence c){
        this.competence = c;
        this.temps = this.competence.getTemps().getTemps();
        this.groupeVerbe = randomGroup();
        this.infinitif = generateVerbeInfinitif(this.groupeVerbe);
        this.sujet = generateSujet();
        this.complement = getComplementInfinitif(this.infinitif);
        this.verbe = getVerbeConjugue(this.temps,this.sujet,this.infinitif);
    }

    @Override
    public String getTemps() {
        return temps;
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
    public String getComplement() {
        return complement;
    }

    @Override
    public String getInfinitif(){
        return infinitif;
    }

    @Override
    public Competence getCompetence() {return competence;}

    @Override
    public int getGroupeVerbe() {
        return groupeVerbe;
    }

    //Renvoi un verbe à l'infinitif du groupe donné
    private String generateVerbeInfinitif(int groupe){
        String randomInfinitif = db.getInfinitifDao().findARandomInfinitif(groupe);
        return randomInfinitif;
    }

    private String generateSujet(){
        int indice = (int) (1 + (Math.random() * (6)));
        switch (indice){
            case 1:
                if(getInfinitif().toLowerCase().matches("(a|e|i|o|u|y).*")) {
                    return "J'";
                }
                return JE.getSujet();
            case 2:
                return TU.getSujet();
            case 3:
                return IL.getSujet();
            case 4:
                return NOUS.getSujet();
            case 5:
                return VOUS.getSujet();
            case 6:
                return ELLES.getSujet();
            default:
                return "NON";
        }
    }

    //Renvoi un complement de l'infinitif donné
    private String getComplementInfinitif(String infinitif){
        String complement = db.getInfinitifDao().findComplementInfinitif(infinitif);
        return complement;
    }

    //Renvoi le verbe conjugué au temps donné pour un sujet donné
    private String getVerbeConjugue(String temps, String sujet, String infinitif) {
        String verbeConjugue = db.getVerbeConjugueDao().findVerbeConjugue(temps,sujet,infinitif);
        return verbeConjugue;
    }

    //Retourne un numero de groupe aléatoire dans une liste de groupe
    public int randomGroup(){
        ArrayList<Integer> list = competence.getListOfGroup();
        return list.get(new  Random().nextInt(list.size())).intValue();
    }
}
