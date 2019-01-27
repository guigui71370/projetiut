
package com.example.cassa.entrainementprojettut.connect4.ia;

import com.example.cassa.entrainementprojettut.connect4.Plateau;

public class Ialevel4 implements I_Ia {
    private int column;
    @Override
    public int getColumn() {
        return column;
    }
    private int depth=2;

    private int score;
    private boolean round;
    private int iterations;
    int rows = 6; // Height
    int columnsboard = 7; // Width
    int result;

    @Override
    public void calculateColumn(Plateau plateau) {
        char joueur;
        if(plateau.getCia()=='r')
            joueur='y';
        else
            joueur='r';


        plateau.setColoruse(plateau.getCia());
        int tab[]=maximizePlay(plateau,depth);
        result=tab[0];


        /*int column=plateau.conect4In1Turn(plateau.getCia());
        int column2=plateau.conect4In1Turn(joueur);
        if(column!=-1){
            this.column=column;

        }else if(column2!=-1){

            this.column=column2;
        }else {

            //Ici on calcul la position que va jouer l'ordinateur selon le plateau
            //On retourne uniquement la colonne que l'ia doit jouer
            // ==> l'IA



            int i = -1;
            while (i == -1) {
                this.column = ((int) (Math.random() * 7));
                i = plateau.insertCheckers(this.column, plateau.getCia());
                if(i!=-1)
                i=verifNedonepasdepuisssan4(i, plateau);

            }
        }*/

    }

    private int verifNedonepasdepuisssan4(int i, Plateau plateau) {

       i=plateau.conect4In1Turn(plateau.getCouleuropser(plateau.getCia()));

       if(i!=-1){
           plateau.removeCheckers(this.column);
           return -1;
       }
       else{
            return 0;
        }

    }




    /**
     * Algorithm
     * Minimax principle
     */
    private int[] maximizePlay (Plateau board,int depth){
        // Call score of our board
        int score = board.score();

        // Break
        if (board.isFinished(depth, score)) return new int[]{-1, score};

        // Column, Score
        int max[] = {-1, -99999};

        // For all possible moves
        for (int column = 0; column < this.columnsboard; column++) {
            Plateau new_board =new Plateau(board); // Create new board
            //System.out.println("debug1 "+coloruse);
            if (new_board.insertCheckersIa(column,board.getColoruse())!=-1) {

                //System.out.println("debug2 "+coloruse);

                this.iterations++; // Debug
                System.out.println("iterations :"+iterations);

                int next_move[] = minimizePlay(new_board, depth - 1); // Recursive calling

                // Evaluate new move
                if (max[0] == -1 || next_move[1] > max[1]) {
                    max[0] = column;
                    max[1] = next_move[1];

                }
            }
        }

        return max;
    }

    private int[] minimizePlay(Plateau board, int depth) {
        int score = board.score();

        if (board.isFinished(depth, score)) return new int[]{-1, score};

        // Column, score
        int min[] = {-1, 99999};

        for (int column = 0; column < this.columnsboard; column++) {
            Plateau new_board =new Plateau(board); // Create new board

            if (new_board.insertCheckersIa(column,board.getColoruse())!=-1) {

                this.iterations++;
                System.out.println("iterations :"+iterations);
                int next_move[] = maximizePlay(new_board, depth - 1);

                if (min[0] == -1 || next_move[1] < min[1]) {
                    min[0] = column;
                    min[1] = next_move[1];
                }

            }
        }
        return min;
    }
}

