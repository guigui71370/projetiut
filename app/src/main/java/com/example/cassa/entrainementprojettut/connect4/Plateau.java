package com.example.cassa.entrainementprojettut.connect4;




import com.example.cassa.entrainementprojettut.connect4.ia.I_Ia;

public class Plateau {

    private char[][] plateau;
    private I_Ia iaDeLaPartie;



    private char cia;
    //private char cjo;

    public Plateau(int levelChosen){
      plateau=new char[6][7];
      for(int x=0;x<plateau.length;x++) {
          for (int y = 0; y < plateau[1].length; y++) {
              plateau[x][y] = ' ';
          }
      }
        iaDeLaPartie=FactoryIa.factory ( levelChosen);
    }

    public Plateau(Plateau copie){
        plateau=new char[6][7];
        for(int x=0;x<plateau.length;x++) {
            for (int y = 0; y < plateau[1].length; y++) {
                plateau[x][y] = copie.plateau[x][y];
            }
        }
        iaDeLaPartie=copie.iaDeLaPartie;
         cia=copie.cia;
    }

    public char getCia() {
        return cia;
    }

    public void setCia(char cia) {
        this.cia = cia;
    }



    public void setColorCase(int column, int row,char c) {
        this.plateau[row][column]=c;
    }



    public int calculateCheckersPosition(int levelChosen){
        //On calcule la position ou le pion doit etre placé selon le niveau de difficulté
        //I_Ia level=FactoryIa.factory ( levelChosen);
        iaDeLaPartie.calculateColumn(new Plateau(this));
        return iaDeLaPartie.getColumn();



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
        boolean test=false;
       /* int x=0;
        int y=0;

        while(x<this.plateau.length && test==false){
            while(y<this.plateau[1].length && test==false){
               y++;
               test=true;
            }
            y=0;
            x++;
        }*/




      for(int x=0;x<this.plateau.length && test==false;x++){
            for(int y=0;y<this.plateau[1].length && test==false;y++){
                if( r==this.plateau[x][y]){
                    test =verticalDown(y,x,r) ||horizontalRight(y,x,r) || DiagonalRightDown(y,x,r)||DiagonalLeftDown(y,x,r);
                }



            }
        }


        return test;
    }



    private boolean verticalDown(int column, int row, char r){

        if(row<this.plateau.length-1 && r==this.plateau[row+1][column]){
            if((row+1)<this.plateau.length-1 && r==this.plateau[row+2][column]){
                if((row+2)<this.plateau.length-1 && r==this.plateau[row+3][column]){
                    return true;//puisanse 4
                }

            }
        }


        return false;
    }





    private boolean horizontalRight(int column, int row, char r){

        if(column<this.plateau[1].length-1 && r==this.plateau[row][column+1]){
            if((column+1)<this.plateau[1].length-1 && r==this.plateau[row][column+2]){
                if((column+2)<this.plateau[1].length-1 && r==this.plateau[row][column+3]){
                    return true;//puisanse 4
                }

            }
        }


        return false;
    }

    private boolean DiagonalRightDown(int column, int row, char r){

        if(row<this.plateau.length-1 && column<this.plateau[1].length-1 && r==this.plateau[row+1][column+1]){
            if((row+1)<this.plateau.length-1  &&  (column+1)<this.plateau[1].length-1 && r==this.plateau[row+2][column+2]){
                if((row+2)<this.plateau.length-1 &&  (column+2)<this.plateau[1].length-1 &&r==this.plateau[row+3][column+3]){
                    return true;//puisanse 4
                }

            }
        }


        return false;
    }



    private boolean DiagonalLeftDown(int column, int row, char r){

        if(row<this.plateau.length-1 && column>0 && r==this.plateau[row+1][column-1]){
            if((row+1)<this.plateau.length-1  &&  (column-1)>0 && r==this.plateau[row+2][column-2]){
                if((row+2)<this.plateau.length-1 &&  (column-2)>0 &&r==this.plateau[row+3][column-3]){
                    return true;//puisanse 4
                }

            }
        }

        return false;
    }


    public int summcheker() {
        int result=0;
        for(int x=0;x<this.plateau.length ;x++) {
            for (int y = 0; y < this.plateau[1].length ; y++) {
                if ('r' == this.plateau[x][y]||'y' == this.plateau[x][y]) {
                    result++;
                }
            }
        }
        return result;
    }

    public int insertCheckers(int column, char color) {
        int result=0;
        boolean test =false;
        for(result=this.plateau.length-1;result>=0 && test==false;result--) {

                if (this.plateau[result][column]==' ') {
                   test=true;
                }
        }



        if(test){

            result++;
            this.setColorCase(column,result,color);
            return result;

        }else {
            return -1;

        }



    }
}
