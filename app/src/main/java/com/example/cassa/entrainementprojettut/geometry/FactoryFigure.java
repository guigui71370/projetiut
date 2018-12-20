package com.example.cassa.entrainementprojettut.geometry;

import com.example.cassa.entrainementprojettut.geometry.figure.Carre;
import com.example.cassa.entrainementprojettut.geometry.figure.Cercle;
import com.example.cassa.entrainementprojettut.geometry.figure.Figure;
import com.example.cassa.entrainementprojettut.geometry.figure.Losange;
import com.example.cassa.entrainementprojettut.geometry.figure.Parallelogramme;
import com.example.cassa.entrainementprojettut.geometry.figure.Quadrilatere;
import com.example.cassa.entrainementprojettut.geometry.figure.Rectangle;
import com.example.cassa.entrainementprojettut.geometry.figure.Trapeze;
import com.example.cassa.entrainementprojettut.geometry.figure.TriangleI;
import com.example.cassa.entrainementprojettut.geometry.figure.TriangleIR;
import com.example.cassa.entrainementprojettut.geometry.figure.TriangleQ;
import com.example.cassa.entrainementprojettut.geometry.figure.TriangleR;

import java.util.Random;

public class FactoryFigure {

    private Random r;

    public FactoryFigure(){
        r = new Random();
    }
    public Figure createFigure() {

        Figure f;
        switch (r.nextInt(5)){
            case 0:
                f = new Carre();
                break;
            case 1:
                f = new Cercle();
                break;
            case 2:
                f = new Rectangle();
                break;
            case 3:
                f = new TriangleI();

                break;
            case 4:
                f = new TriangleR();

                break;
            case 5:
                f = new Losange();
                break;
            case 6:
                f = new Trapeze();
                break;
            case 7:
                f = new Parallelogramme();
                break;
            case 8:
                f = new TriangleIR();
                break;
            case 9:
                f = new TriangleQ();
                break;
            case 10:
                f = new Quadrilatere();
                break;
            default:
                f = null;
                break;



        }
        return f;
    }
}
