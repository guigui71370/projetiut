package com.example.cassa.entrainementprojettut.echecs.ia;

public class minmax {

    private int depth;
    private int score;
    private boolean round;
    private int iterations;

    public minmax(int depth, int iterations) {
        this.depth = depth;
        this.score = 1000000000;
        this.iterations = iterations;
    }





    private int[] maximizePlay (int[] board, int depth){
        // Call score of our board
        //int score = board.score();

        // Break
        //if (board.isFinished(depth, score)) return new int[]{-1, score};

        // Column, Score
        int max[] = {-1, -99999};

        // For all possible moves
        double v = 1;
        for (int column = 0; column < v; column++) {//mouvement jouer
            int[] new_board =new int[1]; // Create new board
            //System.out.println("debug1 "+coloruse);
            if (true/*new_board.insertCheckersIa(column,board.getColoruse())!=-1*/) {

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

    private int[] minimizePlay(int[] board, int depth) {
        //int score = board.score();

        //if (board.isFinished(depth, score)) return new int[]{-1, score};

        // Column, score
        int min[] = {-1, 99999};

        double v = 0;
        for (int column = 0; column < v; column++) {//mouvement jouer
            int[] new_board =new int[1]; // Create new board

            if (true/*new_board.insertCheckersIa(column,board.getColoruse())!=-1*/) {

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
