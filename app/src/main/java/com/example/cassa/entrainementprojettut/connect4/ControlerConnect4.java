package com.example.cassa.entrainementprojettut.connect4;




public class ControlerConnect4 {

    private int[] nbCheckersColumn = new int[7];
    private Plateau plateau;
    public ControlerConnect4(){
        plateau=new Plateau();
    }

    public int insertCheckers(int column, char color){
        //On insert le pion en verifiant les collisions pour une colonne donnée
        //retourne -1 si il est imposible placé un pion dans la colonne
        nbCheckersColumn[column]++;
        if(nbCheckersColumn[column]>6){
            nbCheckersColumn[column]--;
            return -1;
        }else {
            plateau.setColorCase(column,6-nbCheckersColumn[column],color);
            return 6-nbCheckersColumn[column];
        }

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

        if(summRow()==(6*7)){
            return 2;
        }else if(plateau.win('r')){
            return 0;
        }else if(plateau.win('j')){
            return 1;
        }else




        return -1;
    }
    private int summRow(){
        int result =0;
        for(int i=0;i<this.nbCheckersColumn.length;i++)
        result=this.nbCheckersColumn[i]+result;
        return result;
    }

    public Position calculateCheckersPosition(int levelChosen){
        //On calcule la position ou le pion doit etre placé selon le niveau de difficulté
        return plateau.calculateCheckersPosition(levelChosen);
    }
}
