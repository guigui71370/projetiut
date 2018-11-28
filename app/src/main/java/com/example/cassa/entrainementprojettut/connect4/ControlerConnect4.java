package com.example.cassa.entrainementprojettut.connect4;

import android.widget.ImageView;


public class ControlerConnect4 {

    private int[] nbCheckersColumn = new int[7];

    public ControlerConnect4(){
    }

    public int insertCheckers(int column){
        //On insert le pion en verifiant les collisions pour une colonne donnée
        nbCheckersColumn[column]++;
        return nbCheckersColumn[column]-1;
    }

    public boolean hasWinner(){
        //On verifie si il y a un gagnant
        //Note : On doit aussi traiter le cas null
        return true;
    }

    public Position calculateCheckersPosition(int levelChosen, ImageView[][] board){
        //On calcule la position ou le pion doit etre placé selon le niveau de difficulté
        Position solution = new Position();
        solution.calculateRowAndColumn(levelChosen,board);
        return solution;
    }
}
