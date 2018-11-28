package com.example.cassa.entrainementprojettut.geometry;

import android.content.DialogInterface;
import android.graphics.Canvas;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.example.cassa.entrainementprojettut.R;

import com.example.cassa.entrainementprojettut.gameUtils.GameActivity;
import com.example.cassa.entrainementprojettut.geometry.controller.*;
import com.example.cassa.entrainementprojettut.geometry.figure.Figure;


public class GeometryActivity extends GameActivity implements View.OnClickListener{


    private ControlerFigure ctrlFigure;
    private MediaPlayer playerEvent;
    protected SurfaceView surface;

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

        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                if (levelChosen != 0) {
                    generateFigure();
                    //launchTimer(GeometryActivity.this,60000,R.id.acivity_addition_pos1_img,R.id.playerImage);
                } else {
                    GeometryActivity.this.onStop();
                    dialog.show();
                }
            }
        });

        playerEvent = MediaPlayer.create(GeometryActivity.this,R.raw.envent_sound);

        surface = (SurfaceView) findViewById(R.id.activity_geometry_surfaceView);


    }


    private void generateFigure(){


        surface.getHolder().addCallback(new SurfaceHolder.Callback() {

            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                // Do some drawing when surface is ready
                Canvas canvas = holder.lockCanvas();
                Figure figure = new ControlerFigure().getFigure();
                figure.draw(canvas);
                holder.unlockCanvasAndPost(canvas);
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            }
        });


    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private void showMenu(){
        String[] menu = new String[5];
        menu[0]= getString(R.string.first_year_of_primary_school);
        menu[1]= getString(R.string.second_year_of_primary_school);
        menu[2]= getString(R.string.third_year_of_primary_school);
        menu[3]= getString(R.string.fourth_year_of_primary_school);
        menu[4]= getString(R.string.fifth_year_of_primary_school);
        displayLevelchoice(this,menu);
    }
}
