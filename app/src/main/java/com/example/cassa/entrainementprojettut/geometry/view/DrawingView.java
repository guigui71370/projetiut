package com.example.cassa.entrainementprojettut.geometry.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.example.cassa.entrainementprojettut.geometry.figure.Figure;

public class DrawingView extends View {

    private Figure figure; // figure qui doit être dessiné
    private Paint paintBord; // premier pinceau à utilisé pour les bords de la view
    private Paint paintInside; // deuxieme pinceau plus petit pour l'intérieur de la view

    public DrawingView(Context context) {
        super(context);
        init();
    }

    public DrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public DrawingView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        // un objet Paint représente le pinceau

        // ici c'est un pinceau de couleur noir et de taille 20
        paintBord = new Paint();
        paintBord.setColor(Color.BLACK);
        paintBord.setStyle(Paint.Style.STROKE);
        paintBord.setStrokeWidth(20);

        // ici c'est un pinceau de couleur noir et de taille 10
        paintInside = new Paint();
        paintInside.setColor(Color.BLACK);
        paintInside.setStyle(Paint.Style.STROKE);
        paintInside.setStrokeWidth(10);

        figure = null;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float width = this.getWidth(); // largeur de la view
        float height = this.getHeight(); // hauteur de la view


        if (figure!=null && figure.getName()=="Quadrilatère") {
            canvas.drawLine(0, 0, 0, this.getHeight(), paintBord);
            canvas.drawLine(0, this.getHeight(), this.getWidth(), this.getHeight(), paintBord);
            canvas.drawLine(this.getWidth(), this.getHeight(), this.getWidth()/2, this.getHeight()*(float)0.75, paintInside);
            canvas.drawLine(this.getWidth()/2, this.getHeight()*(float)0.75, 0, 0, paintInside);
        }
        else if (figure!=null && figure.getName()=="Rectangle") {
            Rect r = new Rect();
            paintBord.setColor(Color.BLACK);
            paintBord.setStyle(Paint.Style.STROKE);
            paintBord.setStrokeWidth(20);
            r.set(0, 0, this.getWidth(), this.getHeight()/2);
            canvas.drawRect(r, paintBord);
        }
        else if (figure!=null && figure.getName()=="Carré") {
            Rect r = new Rect();
            r.set(0, 0, this.getWidth(), this.getHeight());
            canvas.drawRect(r, paintBord);
        }
        else if (figure!=null && figure.getName()=="Parralélogramme") {
            canvas.drawLine(0, 0, 0, this.getHeight()/2, paintBord);
            canvas.drawLine(0, this.getHeight()/2, this.getWidth(), this.getHeight(), paintInside);
            canvas.drawLine(this.getWidth(), this.getHeight(), this.getWidth(), this.getHeight()/2, paintBord);
            canvas.drawLine(this.getWidth(), this.getHeight()/2, 0, 0, paintInside);
        }
        else if (figure!=null && figure.getName()=="Losange") {
            canvas.drawLine(this.getWidth()/2, 0, this.getWidth()/4, this.getHeight()/2, paintInside);
            canvas.drawLine(this.getWidth()/4, this.getHeight()/2, this.getWidth()/2, this.getHeight(), paintInside);
            canvas.drawLine(this.getWidth()/2, this.getHeight(), 3*this.getWidth()/4, this.getHeight()/2, paintInside);
            canvas.drawLine(3*this.getWidth()/4, this.getHeight()/2, this.getWidth()/2, 0, paintInside);
        }
        else if (figure!=null && figure.getName()=="Cercle") {
            canvas.drawCircle(this.getWidth()/2, this.getHeight()/2, this.getWidth()/2-10, paintInside);
        }
        else if (figure!=null && figure.getName()=="TriangleQ") {
            canvas.drawLine(0, height, 3*width/4, 3*height/4, paintInside);
            canvas.drawLine(3*width/4, 3*height/4, width, height, paintInside);
            canvas.drawLine(width, height, 0, height, paintBord);
        }
        else if (figure!=null && figure.getName()=="TriangleI") {
            canvas.drawLine(width/4, height, 3*width/4, height, paintBord);
            canvas.drawLine(3*width/4, height, width/2, 0, paintInside);
            canvas.drawLine(width/2, 0, width/4, height, paintInside);
        }
        else if (figure!=null && figure.getName()=="TriangleR") {
            canvas.drawLine(0, height/2, 0, height, paintBord);
            canvas.drawLine(0, height, width, height, paintBord);
            canvas.drawLine(width, height, 0, height/2, paintInside);
        }
        else if (figure!=null && figure.getName()=="TriangleIR") {
            canvas.drawLine(0, 0, 0, height, paintBord);
            canvas.drawLine(0, height, width, height, paintBord);
            canvas.drawLine(width, height, 0, 0, paintInside);
        }
        else if (figure!=null && figure.getName()=="Trapèze") {
            canvas.drawLine(0, height, width, height, paintBord);
            canvas.drawLine(width, height, 3*width/4, 0, paintInside);
            canvas.drawLine(3*width/4, 0, width/4, 0, paintBord);
            canvas.drawLine(width/4, 0, 0, height, paintInside);
        }
    }

    public void updateFigure(Figure f){
        figure = f;
        postInvalidate();
    }
}
