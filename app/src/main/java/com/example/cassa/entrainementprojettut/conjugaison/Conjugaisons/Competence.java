package com.example.cassa.entrainementprojettut.conjugaison.Conjugaisons;

import com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil.ListeTemps;

import java.util.ArrayList;

public class Competence {

    private String name;
    private int numberOfTry;
    private int numberToSucced;
    private boolean acquired;
    private ArrayList<Integer> listOfGroup;
    private ListeTemps temps;

    public Competence(String nameCompetence, ListeTemps tempsConjugaison){
        name = nameCompetence;
        numberOfTry = 0;
        numberToSucced = 3;
        acquired = false;
        listOfGroup = new ArrayList<Integer>();
        listOfGroup.add(new Integer(1));
        listOfGroup.add(new Integer(2));
        listOfGroup.add(new Integer(3));
        temps = tempsConjugaison;
    }

    public Competence(String nameCompetence, ArrayList<Integer> listGroup, ListeTemps tempsConjugaison){
        name = nameCompetence;
        numberOfTry = 0;
        numberToSucced = 3;
        acquired = false;
        listOfGroup = listGroup;
        temps = tempsConjugaison;
    }

    public Competence(String nameCompetence, ArrayList<Integer> listGroup, ListeTemps tempsConjugaison, int toSucced){
        name = nameCompetence;
        numberOfTry = 0;
        numberToSucced = toSucced;
        acquired = false;
        listOfGroup = listGroup;
        temps = tempsConjugaison;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfTry() {
        return numberOfTry;
    }

    public int getNumberToSucced() {
        return numberToSucced;
    }

    public ArrayList<Integer> getListOfGroup() {
        return listOfGroup;
    }

    public ListeTemps getTemps() {
        return temps;
    }

    public boolean isAcquired() {
        return acquired;
    }

    public void reset(){
        numberOfTry = 0;
    }

    public void addTry(){
        numberOfTry++;
        if(numberOfTry>=numberToSucced) acquired = true;
    }
}
