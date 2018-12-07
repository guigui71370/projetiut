package com.example.cassa.entrainementprojettut.connect4.ia;

import com.example.cassa.entrainementprojettut.connect4.Plateau;

public class I_IaFacile implements I_Ia {
    private int column;

    public void calculateColumn(Plateau plateau){
        //Ici on calcul la position que va jouer l'ordinateur selon le plateau
        //On retourne uniquement la colonne que l'ia doit jouer
        // ==> l'IA
        int i=-1;
        while(i==-1){
            this.column = ((int)(Math.random() * 7));
            i=plateau.insertCheckers(this.column,plateau.getCia());
        }


    }

    public int getColumn() {
        return column;
    }
}
