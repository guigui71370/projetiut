package com.example.cassa.entrainementprojettut.geometry;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import com.example.cassa.entrainementprojettut.R;
import com.example.cassa.entrainementprojettut.gameUtils.GameActivity;
import com.example.cassa.entrainementprojettut.geometry.controller.ControlerFigure;
import com.example.cassa.entrainementprojettut.geometry.figure.Figure;
import com.example.cassa.entrainementprojettut.geometry.view.DrawingView;

import java.util.Random;

public class GeometryActivity extends GameActivity implements View.OnClickListener{

    private ControlerFigure ctrlFigure;
    private MediaPlayer playerEvent;
    protected DrawingView drawingView;
    private TextView properties;
    private TextView name;
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
        drawingView = findViewById(R.id.activity_geometry_drawing);

        properties = findViewById(R.id.activity_geometry_textview_propertie);
        name = findViewById(R.id.activity_geometry_textview_figurename);
        trueAnswer = findViewById(R.id.activity_geometry_button_true);
        falseAnswer = findViewById(R.id.activity_geometry_button_false);


        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                if (levelChosen != 0) {
                    ctrlFigure = new ControlerFigure();
                    generateFigure();
                    activateButtons();
                    //launchGhost(GeometryActivity.this,60000,R.id.activity_geometry_imageview_ghost);
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
        setProperties();
        setName();
    }

    public void setName(){
        name.setText(ctrlFigure.getName());
    }

    public void setProperties(){
        Random r = new Random();
        int nbProperties = ctrlFigure.getProperties().size();
        int i = r.nextInt(nbProperties);
        properties.setText(ctrlFigure.getProperties().get(i));
    }

    @Override
    public void onClick(View v) {
        generateFigure();
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
