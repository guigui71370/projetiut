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

    private Figure figure;
    private Paint paint;

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
        paint = new Paint();
        figure = null;
    }

    @Override
    protected void onDraw(Canvas canvas) {


        if (figure!=null && figure.getName()=="Rectangle") {
            Rect r = new Rect();
            paint.setColor(Color.BLACK);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(20);
            r.set(0, 0, this.getWidth(), this.getHeight());
            canvas.drawRect(r, paint);
        }
        else{
            canvas.drawColor(Color.YELLOW);

        }
    }


    public void updateFigure(Figure f){
        figure = f;
        postInvalidate();
    }

}
