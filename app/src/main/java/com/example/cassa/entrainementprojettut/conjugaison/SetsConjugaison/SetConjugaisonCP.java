package com.example.cassa.entrainementprojettut.conjugaison.SetsConjugaison;

import com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil.ListeTemps;
import com.example.cassa.entrainementprojettut.conjugaison.Conjugaisons.Competence;
import com.example.cassa.entrainementprojettut.conjugaison.Conjugaisons.I_Conjugaison;
import com.example.cassa.entrainementprojettut.conjugaison.Conjugaisons.Phrase;

import java.util.ArrayList;
import java.util.Random;

import static com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil.ListeTemps.PRESENTINDICATIF;

public class SetConjugaisonCP implements I_SetConjugaison {
    private I_Conjugaison conjugaison;

    private ArrayList<Competence> listCompetence;

    public SetConjugaisonCP() {
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
        ArrayList<Integer> groupe1 = new ArrayList<Integer>();
        groupe1.add(new Integer(1));
        Competence c1 = new Competence("présent de l'indicatif, verbe du premier groupe", groupe1, ListeTemps.PRESENTINDICATIF,5);

        // ajout des compétences dans la liste
        listCompetence.add(c1);


        return new Phrase(randomCompetence());
    }

    //Retourne une competence aléatoire dans une liste de competence
    public Competence randomCompetence(){
        return listCompetence.get(new Random().nextInt(listCompetence.size()));
    }
}
