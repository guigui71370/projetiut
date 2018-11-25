package com.example.cassa.entrainementprojettut.connect4;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;

import com.example.cassa.entrainementprojettut.R;
import com.example.cassa.entrainementprojettut.gameUtils.GameActivity;

public class Connect4Activity extends GameActivity implements View.OnClickListener {

    private Chronometer chronometer;
    private MediaPlayer playerEvent;

    private int nbYellowAlign;
    private int nbRedAlign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect4);
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
                    launchTimer(Connect4Activity.this,60000,R.id.acivity_addition_pos1_img,R.id.activity_addition_ordi_img);
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    chronometer.start();
                } else {
                    Connect4Activity.this.onStop();
                    dialog.show();
                }
            }
        });

        playerEvent = MediaPlayer.create(Connect4Activity.this,R.raw.envent_sound);
        chronometer = findViewById(R.id.activity_connect4_chrono_chronometer);
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

    @Override
    public void onClick(View view) {
    }
}
