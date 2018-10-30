package com.example.cassa.entrainementprojettut.flag;

import com.example.cassa.entrainementprojettut.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by LeBoss on 09/01/2018.
 */

public class FlagBankEasy implements I_FlagBank {
    private ArrayList<Flag> mListFlagChoice;
    private ArrayList<Integer> mListPicturesAdress;
    private ArrayList<String> mListCountryNames;
    private static String[] mCountries = {"France", "Allemagne", "Italie", "Espagne", "Pays-Bas",
            "Portugal", "Suisse", "Royaume-Uni", "Belgique", "Russie"};

    private Random rand = new Random();

    public FlagBankEasy(){
        mListCountryNames = new ArrayList<String>();
        mListPicturesAdress = new ArrayList<Integer>();
        mListFlagChoice = new ArrayList<Flag>(4);

        setCountriesPictures();
        setCountriesNames();
        setFlagsChoice();
    }


    private void setFlagsChoice() {
        //ArrayList pour éviter les doublons
        ArrayList<Integer> usedCountries = new ArrayList<Integer>();
        for(int i=0; i <4;i++){
            int x = random();
            i = checkDuplication(usedCountries, i, x);
        }

        Collections.shuffle(mListFlagChoice);
    }


    private int random() {
        int x = rand.nextInt(10);
        return x;
    }


    private int checkDuplication(ArrayList<Integer> dispo, int i, int x) {
        Flag mFLag = new Flag(mListCountryNames.get(x), mListPicturesAdress.get(x));
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
            mListCountryNames.add(pays);
        }
    }


    private void setCountriesPictures() {
        mListPicturesAdress.add(R.drawable.france);
        mListPicturesAdress.add(R.drawable.allemagne);
        mListPicturesAdress.add(R.drawable.italie);
        mListPicturesAdress.add(R.drawable.espagne);
        mListPicturesAdress.add(R.drawable.pays_bas);
        mListPicturesAdress.add(R.drawable.portugal);
        mListPicturesAdress.add(R.drawable.suisse);
        mListPicturesAdress.add(R.drawable.royaume_uni);
        mListPicturesAdress.add(R.drawable.belgique);
        mListPicturesAdress.add(R.drawable.russie);
    }


    @Override
    public Flag getFlag(int i) {
        return mListFlagChoice.get(i);
    }


}

