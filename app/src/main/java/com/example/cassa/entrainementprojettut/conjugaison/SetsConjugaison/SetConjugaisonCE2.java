package com.example.cassa.entrainementprojettut.conjugaison.SetsConjugaison;

import com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil.ListeTemps;
import com.example.cassa.entrainementprojettut.conjugaison.Conjugaisons.Competence;
import com.example.cassa.entrainementprojettut.conjugaison.Conjugaisons.I_Conjugaison;
import com.example.cassa.entrainementprojettut.conjugaison.Conjugaisons.Phrase;

import java.util.ArrayList;
import java.util.Random;

import static com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil.ListeTemps.PRESENTINDICATIF;

public class SetConjugaisonCE2 implements I_SetConjugaison {
    private I_Conjugaison conjugaison;

    private ArrayList<Competence> listCompetence;

    public SetConjugaisonCE2() {
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
        Competence c1 = new Competence("présent de l'indicatif, verbe du premier groupe", groupe1, ListeTemps.PRESENTINDICATIF);

        // compétence 2
        ArrayList<Integer> groupe2 = new ArrayList<Integer>();
        groupe2.add(new Integer(2));
        Competence c2 = new Competence("présent de l'indicatif, verbe du deuxième groupe", groupe2, ListeTemps.PRESENTINDICATIF);

        // compétence 3
        ArrayList<Integer> groupe3 = new ArrayList<Integer>();
        groupe3.add(new Integer(3));
        Competence c3 = new Competence("présent de l'indicatif, verbe du troisième groupe", groupe3, ListeTemps.PRESENTINDICATIF);



        // ajout des compétences dans la liste
        listCompetence.add(c1);
        listCompetence.add(c2);
        listCompetence.add(c3);


        return new Phrase(randomCompetence());
    }

    //Retourne une competence aléatoire dans une liste de competence
    public Competence randomCompetence(){
        return listCompetence.get(new Random().nextInt(listCompetence.size()));
    }
}
