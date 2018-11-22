package com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil;

import com.example.cassa.entrainementprojettut.database.AppDatabase;
import com.example.cassa.entrainementprojettut.database.VerbeConjugue;

import java.util.ArrayList;
import java.util.HashMap;

import static com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil.ListeSujet.JE;

public class VerbeConjugueData {
    private AppDatabase database = AppDatabase.getInstanceOfAppDatabase(null);
    private ListeTemps temps;
    public VerbeConjugueData(){
    }
    public ArrayList<VerbeConjugue> getVerbeConjugue(ArrayList<HashMap<String,String>> listTerminaison) {
        ArrayList<VerbeConjugue> listVerbeConjugue = new ArrayList<>();

        //Pour chaque temps
        for (ListeTemps temps: ListeTemps.values()) {
            //Pour chaque verbe a l'infinitif
            for (ListeInfinitif verbe : ListeInfinitif.values()) {
                //On recupere l'id du verbe à l'infinitif pour la foreign key
                int idInfinitif = database.getInfinitifDao().getIdInfinitif(verbe.getVerbe());
                //Pour chaque sujet
                for (ListeSujet sujet : ListeSujet.values()) {
                    //On recupere directement la valeur du sujet pour pouvoir la modifier plus simplement
                    String leSujet = sujet.getSujet();
                    //Pour chaque HashMap<String,String> dans l'ArrayList passé en parametre
                    for (HashMap<String,String> item: listTerminaison) {
                        //Si le verbe correspond à un regex d'une des hashmap
                        if(verbe.getVerbe().toLowerCase().matches(item.get("REGEX"))){
                            //On recupere son radical
                            String radicalVerbe = verbe.getVerbe().substring(0,verbe.getVerbe().length()-item.get("ENDING").length());

                            //Partie en test -> Traiter les informations données par le json

                            //On recupere un tableau de terminaison pour un temps donné
                            String[] listTerminaisons = item.get(temps.getTemps()).split(",");
                            String terminaison = "";
                            //Dans PPRESENT il n'y a qu'une terminaison, si on la recupere on veut qu'elle soit la meme quelque soit le sujet
                            if(temps.getTemps() == item.get("PPRESENT")){
                                //Pour pas avoir de reference sur un null
                                terminaison = listTerminaisons[0];
                            }else{
                                //On recupere dans le tableau la terminaison correspondant au sujet
                                terminaison = listTerminaisons[sujet.ordinal()];
                            }
                            //Si on a une voyelle on met le sujet à J'
                            if(sujet.getSujet().equals(JE.getSujet()) && (verbe.getVerbe().toLowerCase().matches("(a|e|i|o|u|y).*"))){
                                leSujet = ("J'");
                            }
                            //On ajoute le radical du verbe avec sa terminaison
                            listVerbeConjugue.add(new VerbeConjugue(temps.getTemps(), leSujet, radicalVerbe+terminaison,idInfinitif));
                        }
                    }
                }
            }
        }
        return listVerbeConjugue;
    }
}

