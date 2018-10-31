package com.example.cassa.entrainementprojettut.conjugaison.Conjugaisons;

import static com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonActivity.dao;

public class Sujet {

    String generateSujet(){
        int i = (int) (1 + (Math.random() * (6)));
        /*switch (i){
            case 1:
                return "Je";
            case 2:
                return "Tu";
            case 3:
                return "Il/Elle";
            case 4:
                return "Nous";
            case 5:
                return "Vous";
            case 6:
                return "Ils/Elles";
            default:
                return "Non";
        }*/
        return dao.findSentents(1);
    }
}
