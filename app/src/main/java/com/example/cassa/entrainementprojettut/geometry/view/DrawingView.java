package com.example.cassa.entrainementprojettut.geometry.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.example.cassa.entrainementprojettut.geometry.GeometryUtil.ListFigure;
import com.example.cassa.entrainementprojettut.geometry.figure.Figure;

import java.util.Arrays;

//x est represente par l'indice 0, et y par l'indice 1
/* memo :
 *          x
 *   |------------->
 *   |
 *  y|
 *   |
 *   |
 *   \/
 * */
//On laisse 35 de place par rapport au bord pour noter les cotes

public class DrawingView extends View {

    private Figure figure; // figure qui doit être dessiné
    private Paint paintInside; // pinceau pour les bords de la view
    private Paint paintBord; // pinceau pour l'intérieur de la view
    private Paint paintNumber; // pinceau pour les cotes

    int[] topMiddle = new int[2];
    int[] topLeft = new int[2];
    int[] topRight = new int[2];
    int[] bottomLeft = new int[2];
    int[] bottomRight = new int[2];

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
        paintBord = new Paint();
        paintBord.setColor(Color.BLACK);
        paintBord.setStyle(Paint.Style.STROKE);
        paintBord.setStrokeWidth(5);

        paintInside = new Paint();
        paintInside.setColor(Color.WHITE);
        paintInside.setStyle(Paint.Style.FILL);
        paintInside.setStrokeWidth(10);

        paintNumber = new Paint();
        paintNumber.setStyle(Paint.Style.FILL_AND_STROKE);
        paintNumber.setColor(Color.parseColor("#db0d0d"));
        paintNumber.setTextSize(30);

        figure = null;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float width = this.getWidth(); // largeur de la view
        float height = this.getHeight(); // hauteur de la view

        if (figure!=null && figure.getName().equals(ListFigure.QUADRILATERE.toString())) {
            canvas.drawLine(0, 0, 0, this.getHeight(), paintBord);
            canvas.drawLine(0, this.getHeight(), this.getWidth(), this.getHeight(), paintBord);
            canvas.drawLine(this.getWidth(), this.getHeight(), this.getWidth()/2, this.getHeight()*(float)0.75, paintBord);
            canvas.drawLine(this.getWidth()/2, this.getHeight()*(float)0.75, 0, 0, paintBord);
        }

        else if (figure!=null && figure.getName().equals(ListFigure.TRIANGLEIR.toString())) {
            canvas.drawLine(0, 0, 0, height, paintBord);
            canvas.drawLine(0, height, width, height, paintBord);
            canvas.drawLine(width, height, 0, 0, paintBord);
        }
        else if (figure!=null && figure.getName().equals(ListFigure.TRAPEZE.toString())) {
            canvas.drawLine(0, height, width, height, paintBord);
            canvas.drawLine(width, height, 3*width/4, 0, paintBord);
            canvas.drawLine(3*width/4, 0, width/4, 0, paintBord);
            canvas.drawLine(width/4, 0, 0, height, paintBord);
        }
        else if (figure!=null && figure.getName().equals(ListFigure.PARALELLOGRAMME.toString())) {
            canvas.drawLine(0, 0, 0, this.getHeight()/2, paintBord);
            canvas.drawLine(0, this.getHeight()/2, this.getWidth(), this.getHeight(), paintBord);
            canvas.drawLine(this.getWidth(), this.getHeight(), this.getWidth(), this.getHeight()/2, paintBord);
            canvas.drawLine(this.getWidth(), this.getHeight()/2, 0, 0, paintBord);
        }
        else if (figure!=null && figure.getName().equals(ListFigure.LOSANGE.toString())) {
            canvas.drawLine(this.getWidth() / 2, 0, this.getWidth() / 4, this.getHeight() / 2, paintBord);
            canvas.drawLine(this.getWidth() / 4, this.getHeight() / 2, this.getWidth() / 2, this.getHeight(), paintBord);
            canvas.drawLine(this.getWidth() / 2, this.getHeight(), 3 * this.getWidth() / 4, this.getHeight() / 2, paintBord);
            canvas.drawLine(3 * this.getWidth() / 4, this.getHeight() / 2, this.getWidth() / 2, 0, paintBord);
        }
        else if (figure!=null && figure.getName().equals(ListFigure.TRIANGLEQ.toString())) {
            canvas.drawLine(0, height, 3*width/4, 3*height/4, paintBord);
            canvas.drawLine(3*width/4, 3*height/4, width, height, paintBord);
            canvas.drawLine(width, height, 0, height, paintBord);
        }
        //----------------------------------------------------------
        if (figure!=null && figure.getName().equals(ListFigure.RECTANGLE.toString())) {
            topLeft[0]=35;
            topLeft[1]=35;

            topRight[0]=topLeft[0] + (figure.getCote()[0] * 34);
            topRight[1]=topLeft[1];

            bottomRight[0]=topRight[0];
            bottomRight[1]=topRight[1] + (figure.getCote()[1] * 34);

            bottomLeft[0]=topLeft[0];
            bottomLeft[1]=bottomRight[1];

            draw4Side(canvas, paintBord, topLeft,topRight,bottomRight,bottomLeft);
            draw4Side(canvas, paintInside, topLeft,topRight,bottomRight,bottomLeft);

            //Les côtes :
            canvas.drawText(String.valueOf(figure.getCote()[0]) + " m",(figure.getCote()[0] * 34)/2,30,paintNumber);
            canvas.drawText(String.valueOf(figure.getCote()[1]),0,(figure.getCote()[1] * 34)/2,paintNumber);
            canvas.drawText("m",0,(figure.getCote()[1] * 34)/2 + 30,paintNumber);

        } else if (figure != null && figure.getName().equals(ListFigure.CARRE.toString())) {
            topLeft[0]=35;
            topLeft[1]=35;

            topRight[0]=topLeft[0] + (figure.getCote()[0] * 34);
            topRight[1]=topLeft[1];

            bottomRight[0]=topRight[0];
            bottomRight[1]=topRight[1] + (figure.getCote()[0] * 34);

            bottomLeft[0]=topLeft[0];
            bottomLeft[1]=bottomRight[0];

            draw4Side(canvas, paintBord, topLeft,topRight,bottomRight,bottomLeft);
            draw4Side(canvas, paintInside, topLeft,topRight,bottomRight,bottomLeft);

            //Les côtes :
            canvas.drawText(String.valueOf(figure.getCote()[0]) + " m",(figure.getCote()[0] * 34)/2,30,paintNumber);
            canvas.drawText(String.valueOf(figure.getCote()[0]),0,(figure.getCote()[0] * 34)/2,paintNumber);
            canvas.drawText("m",0,(figure.getCote()[0] * 34)/2 + 30,paintNumber);

        }
        else if (figure!=null && figure.getName().equals(ListFigure.CERCLE.toString())) {
            canvas.drawCircle(this.getWidth()/2, this.getHeight()/2, (figure.getCote()[0] * 34)/2 , paintBord);
            canvas.drawCircle(this.getWidth()/2, this.getHeight()/2, (figure.getCote()[0] * 34)/2 , paintInside);
            canvas.drawText("r = "+String.valueOf(figure.getCote()[0]) + " m",width/2,height/2-10,paintNumber);
            paintBord.setStrokeWidth(3);
            canvas.drawLine(width/2, height/2, width/2 + (figure.getCote()[0] * 34)/2, height/2, paintBord);
            paintBord.setStrokeWidth(5);

        }
        else if (figure!=null && figure.getName().equals(ListFigure.TRIANGLEI.toString())) {
            int[] cote =  figure.getCote();
            Arrays.sort(cote);
            int petitCote = cote[0];
            int autreCote = cote[1];
            int hypotenuse = cote[2];
            double x = (petitCote*petitCote - autreCote*autreCote + hypotenuse*hypotenuse)/(2*hypotenuse);
            double hauteur = Math.sqrt(hypotenuse*hypotenuse - (x*x));

            topMiddle[0]=(int)width/2;
            topMiddle[1]=35;

            bottomRight[0]= (int)width/2 + hypotenuse*34/2;
            bottomRight[1]= (int) (35 + hauteur*34);

            bottomLeft[0]=(int)width/2 - hypotenuse*34/2;
            bottomLeft[1]=(int) (35 + hauteur*34);

            draw3Side(canvas, paintBord, topMiddle,bottomLeft,bottomRight);
            draw3Side(canvas, paintInside, topMiddle,bottomLeft,bottomRight);

            //Les côtes :
            canvas.drawText(String.valueOf(hypotenuse),width/2,(int)(hauteur * 34)+63,paintNumber);
            canvas.drawText("m",width/2+35,(int)(hauteur * 34)+63,paintNumber);
            canvas.drawText(String.valueOf(petitCote),bottomRight[0] - hypotenuse*34/3.5f,(int)(hauteur * 34)/2,paintNumber);
            canvas.drawText("m",bottomRight[0]+30 - hypotenuse*34/3.5f,(int)(hauteur * 34)/2,paintNumber);

        }
        else if (figure!=null && figure.getName().equals(ListFigure.TRIANGLER.toString())) {
            int[] cote =  figure.getCote();
            Arrays.sort(cote);
            int petitCote = cote[0];
            int autreCote = cote[1];
            int hypotenuse = cote[2];

            topMiddle[0]=35;
            topMiddle[1]=35;

            bottomRight[0]= 35 + autreCote * 34;
            bottomRight[1]= 35 + petitCote * 34;

            bottomLeft[0]=35;
            bottomLeft[1]=35 + petitCote * 34;

            draw3Side(canvas, paintBord, topMiddle,bottomLeft,bottomRight);
            draw3Side(canvas, paintInside, topMiddle,bottomLeft,bottomRight);

            //Les côtes :
            canvas.drawText(String.valueOf(figure.getCote()[0]) + " m",(autreCote * 34)/2,70 + petitCote*34,paintNumber);
            canvas.drawText(String.valueOf(figure.getCote()[0]),0,(petitCote * 34)/2,paintNumber);
            canvas.drawText("m",0,(petitCote * 34)/2 + 30,paintNumber);
        }
    }

    public void updateFigure(Figure f) {
        figure = f;
        postInvalidate();
    }

    public void draw3Side(Canvas canvas, Paint paint, int[] topMiddle, int[] bottomLeft, int[] bottomRight) {
        Path path = new Path();
        path.moveTo(topMiddle[0],topMiddle[1]); //On se place au 1er point (topMiddle)
        path.lineTo(bottomLeft[0],bottomLeft[1]); // On trace une ligne jusqu'au 2nd point (bottomLeft)
        path.lineTo(bottomRight[0],bottomRight[1]); // On trace une ligne jusqu'au 3e point (bottomRight)
        path.lineTo(topMiddle[0],topMiddle[1]); // On revient au 1er point
        path.close();

        canvas.drawPath(path, paint);
    }

    public void draw4Side(Canvas canvas, Paint paint, int[] topLeft, int[] topRight, int[] bottomRight, int[] bottomLeft) {
        Path path = new Path();
        path.moveTo(topLeft[0],topLeft[1]);
        path.lineTo(topRight[0],topRight[1]);
        path.lineTo(bottomRight[0],bottomRight[1]);
        path.lineTo(bottomLeft[0],bottomLeft[1]);
        path.lineTo(topLeft[0],topLeft[1]);
        path.close();

        canvas.drawPath(path, paint);
    }
}