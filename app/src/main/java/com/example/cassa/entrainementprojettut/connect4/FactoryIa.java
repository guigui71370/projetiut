package com.example.cassa.entrainementprojettut.connect4;

import com.example.cassa.entrainementprojettut.connect4.ia.I_Ia;
import com.example.cassa.entrainementprojettut.connect4.ia.I_IaFacile;

public class FactoryIa {


    public  static I_Ia factory (int levelChosen){
        I_Ia ia;
        switch (levelChosen){
            //Facile

            case 1:
                ia  = new I_IaFacile();
                //iaFacile.calculateColumn(this.plateau);
                return ia;
            //Difficile
            case 2:
                ia  = new I_IaFacile();
                //iaFacile1.calculateColumn(this.plateau);
                return ia;
            default:
                ia  = new I_IaFacile();
                //iaFacile2.calculateColumn(this.plateau);
                return ia;
        }

    }
}
