package com.example.cassa.entrainementprojettut.gameUtils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;

import com.example.cassa.entrainementprojettut.MainActivity;
import com.example.cassa.entrainementprojettut.database.DAOscore;

/**
 * Created by prax on 16/01/2018.
 */

public class ActivityUtil extends AppCompatActivity {
    protected int music = 0;
    protected MediaPlayer bgPlayer;

    protected void startBackgroundMusic(Context activityContext, int idMusic) {

        if (idMusic != 0) {
            if (bgPlayer != null) {
                bgPlayer.stop();
            }

            bgPlayer = MediaPlayer.create(activityContext, idMusic);
            bgPlayer.setLooping(true);
            bgPlayer.start();

        }
    }
    protected float getScreenWidth(){
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.x;
    }
    protected float getScreenHeight(){
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.y;
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (bgPlayer != null) {
            bgPlayer.stop();
        }
    }

    @Override
    public void onBackPressed(){
        if (bgPlayer != null) {
            bgPlayer.stop();
        }
        Intent back = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(back);
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bgPlayer != null) {
            bgPlayer.stop();
        }

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (bgPlayer != null) {
            bgPlayer.start();
        }
    }

    @Override
    protected void onResume() {
        if(bgPlayer != null){
            startBackgroundMusic(this, music);
        }
        super.onResume();
    }
}
