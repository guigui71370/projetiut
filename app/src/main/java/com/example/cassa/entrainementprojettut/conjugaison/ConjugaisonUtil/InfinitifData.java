package com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil;

import com.example.cassa.entrainementprojettut.database.Infinitif;

import java.util.ArrayList;

import static com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil.ListeInfinitif.ACHETER;
import static com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil.ListeInfinitif.AIMER;
import static com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil.ListeInfinitif.APPELER;
import static com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil.ListeInfinitif.BALAYER;
import static com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil.ListeInfinitif.CEDER;
import static com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil.ListeInfinitif.CELEBRER;
import static com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil.ListeInfinitif.CLAMECER;
import static com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil.ListeInfinitif.COUDRE;
import static com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil.ListeInfinitif.EMPLOYER;
import static com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil.ListeInfinitif.FINIR;
import static com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil.ListeInfinitif.GRANDIR;
import static com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil.ListeInfinitif.JETER;
import static com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil.ListeInfinitif.MANGER;
import static com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil.ListeInfinitif.MOUDRE;
import static com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil.ListeInfinitif.OUVRIR;
import static com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil.ListeInfinitif.POUVOIR;
import static com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil.ListeInfinitif.RESOUDRE;
import static com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil.ListeInfinitif.VOIR;

public class InfinitifData {
    public InfinitifData(){
    }

    public ArrayList<Infinitif> getInfinitif() {
        ArrayList<Infinitif> listInfinitif = new ArrayList<>();
        //1er Groupe
        listInfinitif.add(new Infinitif(AIMER.getVerbe(),AIMER.getGroupe(), "mon frere"));
        listInfinitif.add(new Infinitif(MANGER.getVerbe(),MANGER.getGroupe(), "un gateau"));
        listInfinitif.add(new Infinitif(CEDER.getVerbe(),CEDER.getGroupe(), "un morceau de chocolat"));
        listInfinitif.add(new Infinitif(CELEBRER.getVerbe(),CELEBRER.getGroupe(), "un marriage"));
        listInfinitif.add(new Infinitif(APPELER.getVerbe(),APPELER.getGroupe(), "mon grand-père"));
        listInfinitif.add(new Infinitif(ACHETER.getVerbe(),ACHETER.getGroupe(), "un cadeau"));
        listInfinitif.add(new Infinitif(EMPLOYER.getVerbe(),EMPLOYER.getGroupe(), "une femme de ménage"));
        listInfinitif.add(new Infinitif(BALAYER.getVerbe(),BALAYER.getGroupe(),"la poussière"));
        listInfinitif.add(new Infinitif(JETER.getVerbe(),JETER.getGroupe(),"les poubelles"));
        listInfinitif.add(new Infinitif(CLAMECER.getVerbe(),CLAMECER.getGroupe(),"violemment"));

        //2e Groupe
        listInfinitif.add(new Infinitif(FINIR.getVerbe(),FINIR.getGroupe(), "mon goûter"));
        listInfinitif.add(new Infinitif(GRANDIR.getVerbe(),GRANDIR.getGroupe(), "beaucoup"));

        //3e Groupe
        listInfinitif.add(new Infinitif(VOIR.getVerbe(),VOIR.getGroupe(), "un chat"));
        listInfinitif.add(new Infinitif(POUVOIR.getVerbe(),POUVOIR.getGroupe(), "soulever des montagnes"));
        listInfinitif.add(new Infinitif(OUVRIR.getVerbe(),OUVRIR.getGroupe(), "les cadeaux"));
        listInfinitif.add(new Infinitif(MOUDRE.getVerbe(),MOUDRE.getGroupe(), "du café"));
        listInfinitif.add(new Infinitif(COUDRE.getVerbe(),COUDRE.getGroupe(), "un pull"));
        listInfinitif.add(new Infinitif(RESOUDRE.getVerbe(),RESOUDRE.getGroupe(), "une énigme"));

        return listInfinitif;
    }
}
