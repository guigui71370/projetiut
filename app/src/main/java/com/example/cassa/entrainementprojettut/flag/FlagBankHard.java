package com.example.cassa.entrainementprojettut.flag;

import com.example.cassa.entrainementprojettut.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by LeBoss on 09/01/2018.
 */

public class FlagBankHard implements I_FlagBank {
    private ArrayList<Flag> mListFlagChoice;
    private ArrayList<Integer> mListPictureAdress;
    private ArrayList<String> mListCountryNames;
    private static String[] mCountries = {"France","Allemagne","Italie","Espagne","Pays-Bas","Portugal","Suisse","Royaume-Uni","Belgique", "Russie",
            "Canada", "Etats-Unis", "Brésil", "Chine", "Australie", "Afrique Du Sud", "Japon", "Argentine", "Algérie", "Mexique",
            "Autriche", "Maroc", "Tunisie", "Turquie", "Nouvelle-Zélande", "Inde", "Pérou", "Corée Du Sud", "Egypte", "Chili"};

    private Random rand = new Random();


    public FlagBankHard(){
        mListCountryNames = new ArrayList<String>();
        mListPictureAdress = new ArrayList<Integer>();
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
        int x = rand.nextInt(30);
        return x;
    }


    private int checkDuplication(ArrayList<Integer> dispo, int i, int x) {
        Flag mFLag = new Flag(mListCountryNames.get(x), mListPictureAdress.get(x));
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
        //Pays faciles
        mListPictureAdress.add(R.drawable.france);
        mListPictureAdress.add(R.drawable.allemagne);
        mListPictureAdress.add(R.drawable.italie);
        mListPictureAdress.add(R.drawable.espagne);
        mListPictureAdress.add(R.drawable.pays_bas);
        mListPictureAdress.add(R.drawable.portugal);
        mListPictureAdress.add(R.drawable.suisse);
        mListPictureAdress.add(R.drawable.royaume_uni);
        mListPictureAdress.add(R.drawable.belgique);
        mListPictureAdress.add(R.drawable.russie);

        //Pays moins facile
        mListPictureAdress.add(R.drawable.canada);
        mListPictureAdress.add(R.drawable.etats_unis);
        mListPictureAdress.add(R.drawable.bresil);
        mListPictureAdress.add(R.drawable.chine);
        mListPictureAdress.add(R.drawable.australie);
        mListPictureAdress.add(R.drawable.afrique_du_sud);
        mListPictureAdress.add(R.drawable.japon);
        mListPictureAdress.add(R.drawable.argentine);
        mListPictureAdress.add(R.drawable.algerie);
        mListPictureAdress.add(R.drawable.mexique);

        //Pays difficiles
        mListPictureAdress.add(R.drawable.autriche);
        mListPictureAdress.add(R.drawable.maroc);
        mListPictureAdress.add(R.drawable.tunisie);
        mListPictureAdress.add(R.drawable.turquie);
        mListPictureAdress.add(R.drawable.nouvelle_zelande);
        mListPictureAdress.add(R.drawable.inde);
        mListPictureAdress.add(R.drawable.perou);
        mListPictureAdress.add(R.drawable.coree_cu_sud);
        mListPictureAdress.add(R.drawable.egypte);
        mListPictureAdress.add(R.drawable.chili);
    }


    @Override
    public Flag getFlag(int i) {
        return mListFlagChoice.get(i);
    }

}
