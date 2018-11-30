package com.example.cassa.entrainementprojettut.connect4.ia;
public class I_IaFacile implements I_Ia {
    private int column;

    public void calculateColumn(char[][] plateau){
        //Ici on calcul la position que va jouer l'ordinateur selon le plateau
        //On retourne uniquement la colonne que l'ia doit jouer
        // ==> l'IA
        this.column = ((int)(Math.random() * 7));
    }

    public int getColumn() {
        return column;
    }
}
