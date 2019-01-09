package com.example.cassa.entrainementprojettut.connect4.ia;

import com.example.cassa.entrainementprojettut.connect4.Plateau;

public class IaLevel5 implements I_Ia {

    private int depth;
    private int score;
    private boolean round;
    private int iterations;
    int rows = 6; // Height
    int columns = 7; // Width
    char coloruse;
    public IaLevel5(){
        depth = 4; // Search depth
        score = 100000; // Win/loss score
        round = false; // false: Human, true: Computer
        iterations = 0;


    }


    @Override
    public int getColumn() {
        return 0;
    }

    @Override
    public void calculateColumn(Plateau plateau) {
        this.coloruse=plateau.getCia();
        columns=maximizePlay(plateau,depth)[0];
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
        for (int column = 0; column < this.columns; column++) {
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

        for (int column = 0; column < this.columns; column++) {
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
