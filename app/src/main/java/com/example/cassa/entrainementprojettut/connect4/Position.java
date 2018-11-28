package com.example.cassa.entrainementprojettut.connect4;

import android.widget.ImageView;

public class Position {
    private int row;
    private int column;

    public void calculateRowAndColumn(int levelChosen,ImageView[][] board){
        //Ici on calcul la position que va joueur l'ordinateur selon le level et le plateau
        // ==> l'IA
        this.row = 0;
        this.column = 0;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
