package com.example.cassa.entrainementprojettut.conjugaison;

import com.example.cassa.entrainementprojettut.conjugaison.SetsConjugaison.I_SetConjugaison;

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

        public int getNbEtoiles(){
            return setConjugaison.getNbEtoiles();
        }
    }
