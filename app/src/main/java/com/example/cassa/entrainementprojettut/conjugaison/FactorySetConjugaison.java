package com.example.cassa.entrainementprojettut.conjugaison;

import com.example.cassa.entrainementprojettut.conjugaison.SetsConjugaison.I_SetConjugaison;
import com.example.cassa.entrainementprojettut.conjugaison.SetsConjugaison.SetConjugaisonCE1;
import com.example.cassa.entrainementprojettut.conjugaison.SetsConjugaison.SetConjugaisonCE2;
import com.example.cassa.entrainementprojettut.conjugaison.SetsConjugaison.SetConjugaisonCM1;
import com.example.cassa.entrainementprojettut.conjugaison.SetsConjugaison.SetConjugaisonCM2;
import com.example.cassa.entrainementprojettut.conjugaison.SetsConjugaison.SetConjugaisonCP;

public class FactorySetConjugaison {
    public I_SetConjugaison createSetConjugaison(int difficulty) {
        I_SetConjugaison setConjugaison;
        switch (difficulty){
            case 1:
                setConjugaison=new SetConjugaisonCP();
                break;
            case 2:
                setConjugaison=new SetConjugaisonCE1();
                break;
            case 3:
                setConjugaison=new SetConjugaisonCE2();
                break;
            case 4:
                setConjugaison=new SetConjugaisonCM1();
                break;
            default:
                setConjugaison=new SetConjugaisonCM2();
                break;
        }
        return setConjugaison;
    }
}
