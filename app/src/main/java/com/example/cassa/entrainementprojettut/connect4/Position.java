package com.example.cassa.entrainementprojettut.connect4;



public class Position {
    private int row;
    private int column;

    public void calculateRowAndColumn(int levelChosen){
        //Ici on calcul la position que va joueur l'ordinateur selon le level et le Plateau
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
