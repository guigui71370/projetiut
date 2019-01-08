package com.example.cassa.entrainementprojettut.connect4;


import com.example.cassa.entrainementprojettut.connect4.ia.I_Ia;

import java.util.ArrayList;

public class Plateau {

    private char[][] plateau;
    private I_Ia iaDeLaPartie;


    private char cia;
    //private char cjo;

    public Plateau(int levelChosen) {
        plateau = new char[6][7];
        for (int x = 0; x < plateau.length; x++) {
            for (int y = 0; y < plateau[1].length; y++) {
                plateau[x][y] = ' ';
            }
        }
        iaDeLaPartie = FactoryIa.factory(levelChosen);
    }

    public Plateau(Plateau copie) {
        plateau = new char[6][7];
        for (int x = 0; x < plateau.length; x++) {
            for (int y = 0; y < plateau[1].length; y++) {
                plateau[x][y] = copie.plateau[x][y];
            }
        }
        iaDeLaPartie = copie.iaDeLaPartie;
        cia = copie.cia;
    }

    public char getCia() {
        return cia;
    }

    public void setCia(char cia) {
        this.cia = cia;
    }


    public void setColorCase(int column, int row, char c) {
        this.plateau[row][column] = c;
    }


    public int calculateCheckersPosition(int levelChosen) {
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
        boolean test = false;
        final String comparer = "" + r + r + r + r;
        for (int x = 0; x < this.plateau.length && !test; x++) {
            for (int y = 0; y < this.plateau[1].length && !test; y++) {
                if (r == this.plateau[x][y]) {

                    test = verticalDown(y, x, comparer) || horizontalRight(y, x, comparer) || DiagonalRightDown(y, x, comparer) || DiagonalLeftDown(y, x, comparer);
                }


            }
        }


        return test;
    }


    /*
     * parametre: char C la couleur du puissance 4 en 1 coup rechecher
     * resultat: retourne l'indice de la column ou il y a un puissance 4 en 1 coup ou  retourne -1 si aucun puissance 4 trouver
     *
     *
     * */


    public int conect4In1Turn(char c) {
        boolean test = false;
        //int result=-1;
        ArrayList<Integer> result = new ArrayList<Integer>();

        final String chaine1 = "" + c + c + c + " ";
        final String chaine2 = "" + c + c + " " + c;
        final String chaine3 = "" + c + " " + c + c;
        final String chaine4 = " " + c + c + c;
        ;


        for (int x = 0; x < this.plateau.length; x++) {
            for (int y = 0; y < this.plateau[1].length; y++) {
                if (chaine4.charAt(0) == this.plateau[x][y]) {
                    test = verticalDown(y, x, chaine4) || horizontalRight(y, x, chaine4) || DiagonalLeftDown(y, x, chaine4) || DiagonalRightDown(y, x, chaine4);
                    if (test) {
                        result.add(y);
                    }
                }
                if (chaine3.charAt(0) == this.plateau[x][y]) {
                    boolean cond1;
                    boolean cond2;
                    boolean cond3;
                    cond1 = horizontalRight(y, x, chaine3) || DiagonalLeftDown(y, x, chaine3) || DiagonalRightDown(y, x, chaine3);
                    if (cond1) {
                        result.add(y + 1);
                    }
                    cond2 = horizontalRight(y, x, chaine2) || DiagonalLeftDown(y, x, chaine2) || DiagonalRightDown(y, x, chaine2);
                    if (cond2) {
                        result.add(y + 2);
                    }
                    cond3 = horizontalRight(y, x, chaine1) || DiagonalLeftDown(y, x, chaine1) || DiagonalRightDown(y, x, chaine1);
                    if (cond3) {
                        result.add(y + 3);
                    }
                }
            }
        }

        //y--;

        //return result;
      /* if(result==y){
            return result;
        }else */
        if (result.size() == 0) {
            return -1;
        } else {
            int i = 0;
            while (i < result.size()) {

                this.insertCheckers(result.get(i), c);
                if (this.win(c)) {
                    //this.removeCheckers(result.get(i));
                    return result.get(i);
                } else {
                    this.removeCheckers(result.get(i));
                    i++;
                    //return -1;
                }
            }

            return -1;
        }


        //return  result;
    }


    private boolean verticalDown(int column, int row, String comparer) {
        String atester = "" + this.plateau[row][column];
        if (row < this.plateau.length - 1) {
            atester += this.plateau[row + 1][column];
            if ((row + 1) < this.plateau.length - 1) {
                atester += this.plateau[row + 2][column];
                if ((row + 2) < this.plateau.length - 1) {
                    atester += this.plateau[row + 3][column];
                    return comparer.equals(atester);//puisanse 4
                }
            }
        }
        return false;
    }


    private boolean horizontalRight(int column, int row, char r) {

        if (column < this.plateau[1].length - 1 && r == this.plateau[row][column + 1]) {
            if ((column + 1) < this.plateau[1].length - 1 && r == this.plateau[row][column + 2]) {
                if ((column + 2) < this.plateau[1].length - 1 && r == this.plateau[row][column + 3]) {
                    return true;//puisanse 4
                }
            }
        }
        return false;
    }


    private boolean horizontalRight(int column, int row, String comparer) {
        String atester = "" + this.plateau[row][column];
        if (column < this.plateau[1].length - 1) {
            atester += this.plateau[row][column + 1];
            if ((column + 1) < this.plateau[1].length - 1) {
                atester += this.plateau[row][column + 2];
                if ((column + 2) < this.plateau[1].length - 1) {
                    atester += this.plateau[row][column + 3];
                    return comparer.equals(atester);//puisanse 4
                }
            }
        }
        return false;
    }

    private boolean DiagonalRightDown(int column, int row, String comparer) {
        String atester = "" + this.plateau[row][column];
        if (row < this.plateau.length - 1 && column < this.plateau[1].length - 1) {
            atester += this.plateau[row + 1][column + 1];
            if ((row + 1) < this.plateau.length - 1 && (column + 1) < this.plateau[1].length - 1) {
                atester += this.plateau[row + 2][column + 2];
                if ((row + 2) < this.plateau.length - 1 && (column + 2) < this.plateau[1].length - 1) {
                    atester += this.plateau[row + 3][column + 3];
                    return comparer.equals(atester);//puisanse 4
                }
            }
        }
        return false;
    }


    private boolean DiagonalLeftDown(int column, int row, String comparer) {
        String atester = "" + this.plateau[row][column];
        if (row < this.plateau.length - 1 && column > 0) {
            atester += this.plateau[row + 1][column - 1];
            if ((row + 1) < this.plateau.length - 1 && (column - 1) > 0) {
                atester += this.plateau[row + 2][column - 2];
                if ((row + 2) < this.plateau.length - 1 && (column - 2) > 0) {
                    atester += this.plateau[row + 3][column - 3];
                    return comparer.equals(atester);//puisanse 4
                }
            }
        }
        return false;
    }


    public int summcheker() {
        int result = 0;
        for (int x = 0; x < this.plateau.length; x++) {
            for (int y = 0; y < this.plateau[1].length; y++) {
                if ('r' == this.plateau[x][y] || 'y' == this.plateau[x][y]) {
                    result++;
                }
            }
        }
        return result;
    }

    public int insertCheckers(int column, char color) {
        int result = 0;
        boolean test = false;
        for (result = this.plateau.length - 1; result >= 0 && !test; result--) {

            if (this.plateau[result][column] == ' ') {
                test = true;
            }
        }
        if (test) {

            result++;
            this.setColorCase(column, result, color);
            return result;

        } else {
            return -1;

        }

    }

    private int removeCheckers(int column) {
        int result = 0;
        boolean test = false;
        for (result = this.plateau.length - 1; result >= 0 && !test; result--) {

            if (this.plateau[result][column] == ' ') {
                test = true;
            }
        }
        if (test) {

            result += 2;
            this.setColorCase(column, result, ' ');
            return result;

        } else {
            return -1;

        }

    }
}
