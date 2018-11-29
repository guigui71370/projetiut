package com.example.cassa.entrainementprojettut.connect4;



public class Plateau {

    private char[][] plateau;


    public Plateau(){
      plateau=new char[6][7];
      for(int x=0;x<plateau.length;x++) {
          for (int y = 0; y < plateau[1].length; y++) {
              plateau[x][y] = ' ';
          }
      }
    }

    public void setColorCase(int column, int row,char c) {
        this.plateau[row][column]=c;
    }



    public Position calculateCheckersPosition(int levelChosen){
        //On calcule la position ou le pion doit etre placé selon le niveau de difficulté
        Position solution = new Position();
        solution.calculateRowAndColumn(levelChosen);
        return solution;
    }

    /*
    *
    * vérifie si la couleur du joueur passer en paramètre a gagné ou non
    * faire les traitement sur this.plateau
    *
    *
    *
    * */
    public boolean win(char r) {

        return false;
    }
}
