package com.example.cassa.entrainementprojettut.geometry.controller;

import com.example.cassa.entrainementprojettut.geometry.figure.*;
import com.example.cassa.entrainementprojettut.geometry.view.DrawingView;

public class ControlerFigure {

    private Figure f;

    public ControlerFigure(){
        f = new Rectangle();
    }

    public void updateDrawingView(DrawingView drawingView){
        drawingView.updateFigure(f);
    }



}
