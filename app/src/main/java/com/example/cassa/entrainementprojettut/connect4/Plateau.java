package com.example.cassa.entrainementprojettut.connect4;





import com.example.cassa.entrainementprojettut.connect4.ia.I_Ia;

import java.util.ArrayList;

public class Plateau {

    private char[][] plateau;
    private I_Ia iaDeLaPartie;
    private char coloruse;//variable utiliser par le min-max pour savoir a qui il doit ajouter le pion

    public char getColoruse() {
        return coloruse;
    }

    public void setColoruse(char coloruse) {
        this.coloruse = coloruse;
    }


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
        this.coloruse=copie.coloruse;
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
        //On calcule la position ou le pion doit etre placÃ© selon le niveau de difficultÃ©
        //I_Ia level=FactoryIa.factory ( levelChosen);
        iaDeLaPartie.calculateColumn(new Plateau(this));
        return iaDeLaPartie.getColumn();


    }

    /*
     *
     * vÃ©rifie si la couleur du joueur passer en paramÃ¨tre a gagnÃ© ou non
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
        for(int i =0;i<7;i++){
            this.insertCheckers(i, c);

            if (this.win(c)) {
                this.removeCheckers(i);
                return i;
            } else {
                this.removeCheckers(i);
            }
        }
        return -1;

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

    public int insertCheckersIa(int column, char color) {
        int i=insertCheckers(column, color);

        if(i==-1) {
            return -1;
        }else {
            this.coloruse=getCouleuropser(this.coloruse);
            return i;
        }
    }

    public int removeCheckers(int column) {
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


    /**
     * Returns the overall score for our board.
     *
     * @return {number}
     */
    private static final int scoreP4=100000;
    public int score() {
        int points = 0;

        int vertical_points = 0;
        int horizontal_points = 0;
        int diagonal_points1 = 0;
        int diagonal_points2 = 0;

        // Board-size: 7x6 (height x width)
        // Array indices begin with 0
        // => e.g. height: 0, 1, 2, 3, 4, 5

        // Vertical points
        // Check each column for vertical score
        //
        // Possible situations
        //  0  1  2  3  4  5  6
        // [x][ ][ ][ ][ ][ ][ ] 0
        // [x][x][ ][ ][ ][ ][ ] 1
        // [x][x][x][ ][ ][ ][ ] 2
        // [x][x][x][ ][ ][ ][ ] 3
        // [ ][x][x][ ][ ][ ][ ] 4
        // [ ][ ][x][ ][ ][ ][ ] 5
        for (int row = 0; row < this.plateau.length - 3; row++) {
            // check for each column
            for (int column = 0; column < this.plateau[1].length; column++) {
                // Rate the column and add to the points
                int score = this.scorePosition(row, column, 1, 0);
                if (score == scoreP4) return scoreP4;
                if (score == -scoreP4) return -scoreP4;
                vertical_points += score;
            }
        }

        // Horizontal points
        // Check each row's score
        //
        // Possible situations
        //  0  1  2  3  4  5  6
        // [x][x][x][x][ ][ ][ ] 0
        // [ ][x][x][x][x][ ][ ] 1
        // [ ][ ][x][x][x][x][ ] 2
        // [ ][ ][ ][x][x][x][x] 3
        // [ ][ ][ ][ ][ ][ ][ ] 4
        // [ ][ ][ ][ ][ ][ ][ ] 5
        for (int row = 0; row <  this.plateau.length; row++) {
            for (int column = 0; column < this.plateau[1].length - 3; column++) {
                int score = this.scorePosition(row, column, 0, 1);
                if (score == scoreP4) return scoreP4;
                if (score == -scoreP4) return -scoreP4;
                horizontal_points += score;
            }
        }



        // Diagonal points 1 (left-bottom)
        //
        // Possible situation
        //  0  1  2  3  4  5  6
        // [x][ ][ ][ ][ ][ ][ ] 0
        // [ ][x][ ][ ][ ][ ][ ] 1
        // [ ][ ][x][ ][ ][ ][ ] 2
        // [ ][ ][ ][x][ ][ ][ ] 3
        // [ ][ ][ ][ ][ ][ ][ ] 4
        // [ ][ ][ ][ ][ ][ ][ ] 5
        for (int row = 0; row <  this.plateau.length - 3; row++) {
            for (int column = 0; column < this.plateau[1].length - 3; column++) {
                int score = this.scorePosition(row, column, 1, 1);
                if (score == scoreP4) return scoreP4;
                if (score == -scoreP4) return -scoreP4;
                diagonal_points1 += score;
            }
        }

        // Diagonal points 2 (right-bottom)
        //
        // Possible situation
        //  0  1  2  3  4  5  6
        // [ ][ ][ ][x][ ][ ][ ] 0
        // [ ][ ][x][ ][ ][ ][ ] 1
        // [ ][x][ ][ ][ ][ ][ ] 2
        // [x][ ][ ][ ][ ][ ][ ] 3
        // [ ][ ][ ][ ][ ][ ][ ] 4
        // [ ][ ][ ][ ][ ][ ][ ] 5
        for (int row = 3; row <  this.plateau.length; row++) {
            for (int column = 0; column <= this.plateau[1].length - 4; column++) {
                int score = this.scorePosition(row, column, -1, +1);
                if (score == scoreP4) return scoreP4;
                if (score == -scoreP4) return -scoreP4;
                diagonal_points2 += score;
            }

        }

        points = horizontal_points + vertical_points + diagonal_points1 + diagonal_points2;
        return points;
    }



    /**
     * Return a score for various positions (either horizontal, vertical or diagonal by moving through our board).
     *
     * @param {number} row
     * @param {number} column
     * @param {number} delta_y
     * @param {number} delta_x
     * @return {number}
     */
    private int scorePosition(int row, int column, int delta_y, int delta_x) {
        int human_points = 0;
        int computer_points = 0;

        // Save winning positions to arrays for later usage
        ArrayList<Integer[]> winning_array_human =new ArrayList<Integer[]>();
        ArrayList<Integer[]> winning_array_cpu =new ArrayList<Integer[]>();

        // Determine score through amount of available chips
        for (int i = 0; i < 4; i++) {
            if (this.plateau[row][column] == getCouleuropser(cia)) {
                winning_array_human.add(new Integer[]{row, column});
                human_points++; // Add for each human chip
            } else if (this.plateau[row][column] == cia) {
                winning_array_cpu.add(new Integer[]{row, column});
                computer_points++; // Add for each computer chip
            }

            // Moving through our board
            row += delta_y;
            column += delta_x;
        }

        // Marking winning/returning score
        if (human_points == 4) {
            //this.game.winning_array = this.game.winning_array_human;
            // Computer won (100000)
            return -scoreP4;
        } else if (computer_points == 4) {
            //this.game.winning_array = this.game.winning_array_cpu;
            // Human won (-100000)
            return scoreP4;
        } else {
            // Return normal points
            return computer_points;
        }
    }


    public  boolean isFinished (int depth,int score) {
        if (depth == 0 || score == scoreP4 || score == -scoreP4 || this.summcheker()==6*7) {
            return true;
        }
        return false;
    }

    public char getCouleuropser(char c){
        if(c=='r')
            return 'y';
        else
            return 'r';

    }
}
