package com.example.cassa.entrainementprojettut.geometry.figure;

import android.graphics.Canvas;
import com.example.cassa.entrainementprojettut.geometry.FigureProperties;

import java.util.ArrayList;

public interface Figure {

    public int getAire();

    public void draw(Canvas canvas);

    public ArrayList<FigureProperties> getProperties();

    String getName();
}
