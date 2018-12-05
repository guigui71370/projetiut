package com.example.cassa.entrainementprojettut.geometry;

import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import com.example.cassa.entrainementprojettut.R;

import com.example.cassa.entrainementprojettut.gameUtils.GameActivity;
import com.example.cassa.entrainementprojettut.geometry.controller.*;
import com.example.cassa.entrainementprojettut.geometry.figure.Figure;
import com.example.cassa.entrainementprojettut.geometry.view.DrawingView;


public class GeometryActivity extends GameActivity implements View.OnClickListener{


    private ControlerFigure ctrlFigure;
    private MediaPlayer playerEvent;
    protected DrawingView drawingView;
    private Chronometer chronometer;
    private Button trueAnswer;
    private Button falseAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geometry);
        showMenu();
        initializeGame();
        music = R.raw.bensound_retrosoul;
        if(isSong()){
            startBackgroundMusic(this,music);
        }

        playerEvent = MediaPlayer.create(GeometryActivity.this,R.raw.envent_sound);
        drawingView = (DrawingView) findViewById(R.id.activity_geometry_drawing);

        trueAnswer = findViewById(R.id.activity_geometry_button_true);
        falseAnswer = findViewById(R.id.activity_geometry_button_false);


        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                if (levelChosen != 0) {
                    ctrlFigure = new ControlerFigure();
                    generateFigure();
                    activateButtons();
                    //launchTimer(GeometryActivity.this,60000,R.id.acivity_addition_pos1_img,R.id.playerImage);
                } else {
                    GeometryActivity.this.onStop();
                    dialog.show();
                }
            }
        });


    }

    private void activateButtons() {

        trueAnswer.setEnabled(true);
        falseAnswer.setEnabled(true);
        trueAnswer.setOnClickListener(this);
        falseAnswer.setOnClickListener(this);

    }


    private void generateFigure(){

        ctrlFigure.updateDrawingView(drawingView);


    }


    @Override
    public void onClick(View v) {
        ctrlFigure.updateDrawingView(drawingView);

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private void showMenu(){
        String[] menu = new String[3];
        menu[0]= "NIV1";
        menu[1]= "NIV2";
        menu[2]= "NIV3";
        displayLevelchoice(this,menu);
    }
}
