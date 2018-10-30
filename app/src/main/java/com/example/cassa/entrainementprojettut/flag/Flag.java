package com.example.cassa.entrainementprojettut.flag;

/**
 * Created by prax on 23/11/17.
 */

public class Flag {
   private String mNameCountry;
    /**
     * l'adresse de l'image du drapeau
     */
    private int mRessource;



    public Flag(String name, int pictureAdress){
        if(name != null) {
            this.mNameCountry = name;
            this.mRessource = pictureAdress;
        }
    }

    public int getmRessource(){ return this.mRessource; }

    public String getmNameCountry(){
        return this.mNameCountry;
    }


}
