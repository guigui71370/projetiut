package com.example.cassa.entrainementprojettut.geometry.figure;

import android.graphics.Canvas;

import com.example.cassa.entrainementprojettut.geometry.FigureProperties;

import java.util.ArrayList;

public class Quadrilatere implements Figure {
    @Override
    public int getAire() {
        return 0;
    }

    @Override
    public void draw(Canvas canvas) {

    }

    @Override
    public ArrayList<FigureProperties> getProperties() {
        return null;
    }

    @Override
    public String getName() {
        return "Quadrilatère";
    }
}
