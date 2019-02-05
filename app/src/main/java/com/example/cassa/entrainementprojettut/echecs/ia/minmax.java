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
}
