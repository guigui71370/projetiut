package com.example.cassa.entrainementprojettut.conjugaison.SetsConjugaison;

import com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil.ListeTemps;
import com.example.cassa.entrainementprojettut.conjugaison.Conjugaisons.Competence;
import com.example.cassa.entrainementprojettut.conjugaison.Conjugaisons.I_Conjugaison;
import com.example.cassa.entrainementprojettut.conjugaison.Conjugaisons.Phrase;

import java.util.ArrayList;
import java.util.Random;

import static com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil.ListeTemps.PRESENTINDICATIF;

public class SetConjugaisonCM2 implements I_SetConjugaison {
    private I_Conjugaison conjugaison;

    private ArrayList<Competence> listCompetence;

    public SetConjugaisonCM2() {
        listCompetence = new ArrayList<Competence>();
        this.conjugaison = generateConjugaison();
    }

    @Override
    public String getTempsConjugaison() {
        return conjugaison.getTemps();
    }

    @Override
    public String getSujetConjugaison() {
        return conjugaison.getSujet();
    }

    @Override
    public String getVerbeConjugaison() {
        return conjugaison.getVerbe();
    }

    @Override
    public String getComplementConjugaison() {
        return conjugaison.getComplement();
    }

    @Override
    public ArrayList<Competence> getListCompetence(){return listCompetence;}

    public boolean succedCompetence(){
        conjugaison.getCompetence().addTry();
        return conjugaison.getCompetence().isAcquired();
    }

    public void removeCompetence(){
        listCompetence.remove(conjugaison.getCompetence());
    }

    public Competence getCompetence(){
        return conjugaison.getCompetence();
    }

    public String getInfinitifConjugaison(){
        return conjugaison.getInfinitif();
    }

    public void createASentence(){
        conjugaison = new Phrase(randomCompetence());
    }

    private I_Conjugaison generateConjugaison() {

        // compétence 1
        Competence c1 = new Competence("présent de l'indicatif, tous les verbes", ListeTemps.PRESENTINDICATIF);

        // compétence 2
        Competence c2 = new Competence("Futur simple de l'indicatif, tous les verbes", ListeTemps.FUTURSIMPLE);

        // compétence 3
        Competence c3 = new Competence("Imparfait de l'indicatif, tous les verbes", ListeTemps.IMPARFAIT);

        // compétence 4
        Competence c4 = new Competence("Passé simple de l'indicatif, tous les verbes", ListeTemps.PASSESIMPLE);



        // ajout des compétences dans la liste
        listCompetence.add(c1);
        listCompetence.add(c2);
        listCompetence.add(c3);
        listCompetence.add(c4);

        return new Phrase(randomCompetence());
    }

    //Retourne une competence aléatoire dans une liste de competence
    public Competence randomCompetence(){
        return listCompetence.get(new Random().nextInt(listCompetence.size()));
    }
}
