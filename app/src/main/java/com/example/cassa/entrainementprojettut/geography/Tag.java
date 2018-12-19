package com.example.cassa.entrainementprojettut.geography;

/**
 * Created by clement on 12/12/17.
 */

public class Tag {

    private String name;
    private float[] victoryBox =new float[4];
    private int position;


    public float[] getVictoryBox() {
        return victoryBox;
    }

    public String getName() {
        return name;
    }


    public Tag(String name, float xMin, float yMin, float size) {
        this.name = name;
        this.victoryBox[0] = xMin;
        this.victoryBox[1] = xMin + size;
        this.victoryBox[2] = yMin;
        this.victoryBox[3] = yMin + size;
    }

}
