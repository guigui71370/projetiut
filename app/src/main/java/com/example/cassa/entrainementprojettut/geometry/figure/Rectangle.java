package com.example.cassa.entrainementprojettut.geometry.figure;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.cassa.entrainementprojettut.geometry.FigureProperties;

import java.util.ArrayList;

public class Rectangle extends Parralellogramme {

    private int x;
    private int y;
    private ArrayList<FigureProperties> properties;

    public Rectangle() {
        this.x = x;
        this.y = y;
        properties = super.getProperties();
    }

    @Override
    public int getAire() {
        return 0;
    }

    @Override
    public void draw(Canvas canvas) {
        Rect r = new Rect(0, 0, canvas.getWidth(), canvas.getHeight());
        Paint p = new Paint();
        p.setColor(Color.RED);
        p.setStyle(Paint.Style.STROKE);
        canvas.drawRect( r,  p);
    }

    @Override
    public ArrayList<FigureProperties> getProperties() {
        return null;
    }

    @Override
    public String getName() {
        return "Rectangle";
    }
}
