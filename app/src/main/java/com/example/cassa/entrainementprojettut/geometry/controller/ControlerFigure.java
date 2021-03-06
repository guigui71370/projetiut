package com.example.cassa.entrainementprojettut.geometry.controller;

import com.example.cassa.entrainementprojettut.geometry.FactoryFigure;
import com.example.cassa.entrainementprojettut.geometry.FactorySetGeometry;
import com.example.cassa.entrainementprojettut.geometry.figure.Figure;
import com.example.cassa.entrainementprojettut.geometry.setGeometry.I_SetGeometry;
import com.example.cassa.entrainementprojettut.geometry.view.DrawingView;

public class ControlerFigure {

    private Figure f;
    private Figure lastFigure;
    private I_SetGeometry set;
    FactoryFigure ff;

    public ControlerFigure(int levelChosen){
        f = null;
        lastFigure = null;
        set = new FactorySetGeometry().createSetGeometry(levelChosen);
        ff = new FactoryFigure();
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
        f = ff.createFigure();
        return f;
    }

    public String getName(){
        return f.getName();
    }

    public String getTruePropertie(){
        String truePropertie = set.getTruePropertie(f);
        //Log.d("geom88TRU",truePropertie);
        return truePropertie;
    }

    public String getFalsePropertie(){
        return set.getFalsePropertie(f);
    }
}
