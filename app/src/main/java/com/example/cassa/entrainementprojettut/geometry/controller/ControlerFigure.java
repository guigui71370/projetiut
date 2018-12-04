package com.example.cassa.entrainementprojettut.geometry.controller;

import com.example.cassa.entrainementprojettut.geometry.figure.*;
import com.example.cassa.entrainementprojettut.geometry.view.DrawingView;

import java.util.Random;

public class ControlerFigure {

    private Figure f;
    private Figure lastFigure;

    public ControlerFigure(){

        f = null;
        lastFigure = null;

    }

    public void updateDrawingView(DrawingView drawingView) {
        if (f != null && lastFigure != null) {
            while (f.getName().equals(lastFigure.getName())) {
                f = generateFigure();
            }
        }
        else f = generateFigure();


        drawingView.updateFigure(f);
        lastFigure = f;
    }

    private Figure generateFigure(){
        Random r = new Random();
        int i = r.nextInt(11);
        if (i == 0){
            f = new Carre();
        }
        else if (i == 1){
            f = new Cercle();
        }
        else if (i == 2){
            f = new Losange();
        }
        else if (i == 3){
            f = new Parralellogramme();
        }
        else if (i == 4){
            f = new Quadrilatere();
        }
        else if (i == 5){
            f = new Rectangle();
        }
        else if (i == 6){
            f = new Trapeze();
        }
        else if (i == 7){
            f = new TriangleI();
        }
        else if (i == 8){
            f = new TriangleIR();
        }
        else if (i == 9){
            f = new TriangleQ();
        }
        else if (i == 10){
            f = new TriangleR();
        }
        else f = null;

        return f;
    }


}
