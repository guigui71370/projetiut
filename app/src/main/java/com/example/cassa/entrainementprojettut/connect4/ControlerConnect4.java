package com.example.cassa.entrainementprojettut.connect4;


import com.example.cassa.entrainementprojettut.connect4.ia.I_Ia;


import java.util.Observable;

public class ControlerConnect4 extends Observable {

    private int[] nbCheckersColumn = new int[7];
    private Plateau plateau;
    public ControlerConnect4(int levelchosen){
        plateau=new Plateau(levelchosen);
    }

    public int insertCheckers(int column, char color){
        //On insert le pion en verifiant les collisions pour une colonne donnée
        //retourne -1 si il est imposible placé un pion dans la colonne
        /*  nbCheckersColumn[column]++;
        if(nbCheckersColumn[column]>6){
            nbCheckersColumn[column]--;
            return -1;
        }else {
            plateau.setColorCase(column,6-nbCheckersColumn[column],color);
            return 6-nbCheckersColumn[column];
        }

        */

        return this.plateau.insertCheckers(column,color);
    }
    /*
    *   description: vérifie verifie si il y a un gagnant un gagnant ou non
    *   résultat:
    *           -retourne -1 si la partie est toujours en cour
    *           -retourne 0 si les rouge on gagné
    *           -retourne 1 si les jaune on gagné
    *           -retourne 2 si match nul
    * */
    public int hasWinner(){
        if(plateau.win('y')){
            return 2;
        }else if(plateau.win('r')){
            return 0;
        }else if(summcheker()==(6*7)){
            return 1;
        }else
        return -1;
    }
    private int summcheker(){


        return plateau.summcheker();
    }

    public int calculateCheckersPosition(int levelChosen){
        //On calcule la position ou le pion doit etre placé selon le niveau de difficulté
        return plateau.calculateCheckersPosition(levelChosen);
    }

    public void setPlateauCia(char cia) {
        this.plateau.setCia(cia);
    }
}
