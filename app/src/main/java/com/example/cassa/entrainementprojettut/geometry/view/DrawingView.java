package com.example.cassa.entrainementprojettut.geometry.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.example.cassa.entrainementprojettut.geometry.figure.Figure;

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
    private Paint paintBord; // pinceau pour les bords de la view
    private Paint paintInside; // pinceau pour l'intérieur de la view
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
        paintInside = new Paint();
        paintInside.setColor(Color.BLACK);
        paintInside.setStyle(Paint.Style.STROKE);
        paintInside.setStrokeWidth(10);

        paintBord = new Paint();
        paintBord.setColor(Color.BLACK);
        paintBord.setStyle(Paint.Style.STROKE);
        paintBord.setStrokeWidth(20);

        paintNumber = new Paint();
        paintNumber.setStyle(Paint.Style.FILL_AND_STROKE);
        paintNumber.setColor(Color.BLUE);
        paintNumber.setTextSize(30);

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
        } else if (figure != null && figure.getName().equals("Carré")) {
            topLeft[0]=35;
            topLeft[1]=35;
            canvas.drawText(String.valueOf(figure.getCote()[0]),width-25,height/2,paintNumber);

            topRight[0]=(int)width-35;
            topRight[1]=35;
            canvas.drawText(String.valueOf(figure.getCote()[1]),width/2,25,paintNumber);

            bottomRight[0]=(int)width-35;
            bottomRight[1]=(int)height-35;
            canvas.drawText(String.valueOf(figure.getCote()[2]),width/2,height,paintNumber);

            bottomLeft[0]=35;
            bottomLeft[1]=(int)height-35;
            canvas.drawText(String.valueOf(figure.getCote()[3]),5,height/2,paintNumber);

            draw4Side(canvas,paintInside,topLeft,topRight,bottomRight,bottomLeft);

        }else if (figure!=null && figure.getName()=="Parralélogramme") {
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

    public void drawCircle(Canvas canvas, Paint paint, float x, float y, int radius) {
        Path.Direction direction = Path.Direction.CW;   //CW pour ClockWise
        Path path = new Path();
        path.addCircle(x,y,radius,direction);
        path.close();

        canvas.drawPath(path, paint);
    }
}