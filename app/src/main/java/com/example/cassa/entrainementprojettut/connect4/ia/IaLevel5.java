package com.example.cassa.entrainementprojettut.connect4.ia;

import android.util.Log;
import com.example.cassa.entrainementprojettut.connect4.Plateau;

public class IaLevel5 implements I_Ia {

    private int depth;
    private int score;
    private boolean round;
    private int iterations;
    int rows = 6; // Height
    int columnsboard = 7; // Width
    int result;
    char coloruse;
    public IaLevel5(){
        depth = 4; // Search depth
        score = 100000; // Win/loss score
        round = false; // false: Human, true: Computer
        iterations = 0;


    }


    @Override
    public int getColumn() {
        return result;
    }

    @Override
    public void calculateColumn(Plateau plateau) {
        iterations=0;
        this.coloruse=plateau.getCia();
        int tab[]=maximizePlay(plateau,depth);
        result=tab[0];
        Log.d("ia5","iterations :"+iterations);
        Log.d("ia5","score :"+tab[1]);
        Log.d("ia5","columns :"+result);
        Log.d("ia5","columns :"+result);


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

            if (new_board.insertCheckers(column,coloruse)!=-1) {
                coloruse=new_board.getCouleuropser(coloruse);
                this.iterations++; // Debug

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

            if (new_board.insertCheckers(column,coloruse)!=-1) {
                coloruse=new_board.getCouleuropser(coloruse);

                this.iterations++;

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
