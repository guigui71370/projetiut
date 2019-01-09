package com.example.cassa.entrainementprojettut.connect4;

import com.example.cassa.entrainementprojettut.connect4.ia.I_Ia;
import com.example.cassa.entrainementprojettut.connect4.ia.IaLevel1;
import com.example.cassa.entrainementprojettut.connect4.ia.IaLevel5;
import com.example.cassa.entrainementprojettut.connect4.ia.Ialevel2;
import com.example.cassa.entrainementprojettut.connect4.ia.Ialevel3;
import com.example.cassa.entrainementprojettut.connect4.ia.Ialevel4;

public class FactoryIa {


    public  static I_Ia factory (int levelChosen){
        I_Ia ia;
        switch (levelChosen){
            //Facile

            case 1:
                ia  = new IaLevel1();
                //iaFacile.calculateColumn(this.plateau);
                return ia;
            case 2:
                ia  = new Ialevel2();
                //iaFacile1.calculateColumn(this.plateau);
                return ia;
            case 3:
                ia  = new Ialevel3();
                //iaFacile1.calculateColumn(this.plateau);
                return ia;

            //Difficile
            case 4:
                ia  = new Ialevel4();
                //iaFacile1.calculateColumn(this.plateau);
                return ia;
            case 5:
                ia  = new IaLevel5();
                //iaFacile1.calculateColumn(this.plateau);
                return ia;
            default:
                ia  = new IaLevel1();
                //iaFacile2.calculateColumn(this.plateau);
                return ia;
        }

    }
}
