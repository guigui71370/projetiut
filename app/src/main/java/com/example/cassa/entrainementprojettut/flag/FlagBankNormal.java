package com.example.cassa.entrainementprojettut.flag;

import com.example.cassa.entrainementprojettut.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by LeBoss on 09/01/2018.
 */

public class FlagBankNormal implements I_FlagBank {

    private ArrayList<Flag> mListFlagChoice;
    private ArrayList<Integer> mListPicturesAdresses;
    private ArrayList<String> mListCountriesNames;
    private static String[] mCountries = {"France", "Allemagne", "Italie", "Espagne", "Pays-Bas", "Portugal", "Suisse", "Royaume-Uni", "Belgique", "Russie",
            "Canada", "Etats-Unis", "Brésil", "Chine", "Australie", "Afrique Du Sud", "Japon", "Argentine", "Algérie", "Mexique"};

    private Random rand = new Random();


    public FlagBankNormal(){
        mListCountriesNames = new ArrayList<String>();
        mListPicturesAdresses = new ArrayList<Integer>();
        mListFlagChoice = new ArrayList<Flag>();

        setCountriesPictures();
        setCountriesNames();
        setFlagChoices();
    }


    private void setFlagChoices() {
        //ArrayList pour éviter les doublons
        ArrayList<Integer> usedCountries = new ArrayList<Integer>();
        for(int i=0; i <4;i++){
            int x = random();
            i = checkDuplication(usedCountries, i, x);
        }

        Collections.shuffle(mListFlagChoice);
    }


    private int random() {
        int x = rand.nextInt(20);
        return x;
    }


    private int checkDuplication(ArrayList<Integer> dispo, int i, int x) {
        Flag mFLag = new Flag(mListCountriesNames.get(x), mListPicturesAdresses.get(x));
        if(dispo.contains(x)) {
            i--;
        }else {
            mListFlagChoice.add(mFLag);
            dispo.add(x);
        }
        return i;
    }


    private void setCountriesNames() {
        for (String pays: mCountries){
            mListCountriesNames.add(pays);
        }
    }


    private void setCountriesPictures() {
        //Pays faciles
        mListPicturesAdresses.add(R.drawable.france);
        mListPicturesAdresses.add(R.drawable.allemagne);
        mListPicturesAdresses.add(R.drawable.italie);
        mListPicturesAdresses.add(R.drawable.espagne);
        mListPicturesAdresses.add(R.drawable.pays_bas);
        mListPicturesAdresses.add(R.drawable.portugal);
        mListPicturesAdresses.add(R.drawable.suisse);
        mListPicturesAdresses.add(R.drawable.royaume_uni);
        mListPicturesAdresses.add(R.drawable.belgique);
        mListPicturesAdresses.add(R.drawable.russie);

        //Pays moins facile
        mListPicturesAdresses.add(R.drawable.canada);
        mListPicturesAdresses.add(R.drawable.etats_unis);
        mListPicturesAdresses.add(R.drawable.bresil);
        mListPicturesAdresses.add(R.drawable.chine);
        mListPicturesAdresses.add(R.drawable.australie);
        mListPicturesAdresses.add(R.drawable.afrique_du_sud);
        mListPicturesAdresses.add(R.drawable.japon);
        mListPicturesAdresses.add(R.drawable.argentine);
        mListPicturesAdresses.add(R.drawable.algerie);
        mListPicturesAdresses.add(R.drawable.mexique);
    }


    @Override
    public Flag getFlag(int i) {
        return mListFlagChoice.get(i);
    }

}
