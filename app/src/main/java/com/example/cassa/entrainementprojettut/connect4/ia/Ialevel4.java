package com.example.cassa.entrainementprojettut.connect4.ia;

import com.example.cassa.entrainementprojettut.connect4.Plateau;

public class Ialevel4 implements I_Ia {
    private int column;
    @Override
    public int getColumn() {
        return column;
    }

    @Override
    public void calculateColumn(Plateau plateau) {
        char joueur;
        if(plateau.getCia()=='r')
            joueur='y';
        else
            joueur='r';



        int column=plateau.conect4In1Turn(plateau.getCia());
        int column2=plateau.conect4In1Turn(joueur);
        if(column!=-1){
            this.column=column;

        }else if(column2!=-1){

            this.column=column2;
        }else {

            //Ici on calcul la position que va jouer l'ordinateur selon le plateau
            //On retourne uniquement la colonne que l'ia doit jouer
            // ==> l'IA
            int i = -1;
            while (i == -1) {
                this.column = ((int) (Math.random() * 7));
                i = plateau.insertCheckers(this.column, plateau.getCia());
            }
        }

    }
}
