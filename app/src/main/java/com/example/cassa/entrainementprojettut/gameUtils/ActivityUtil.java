package com.example.cassa.entrainementprojettut.gameUtils;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;

import com.example.cassa.entrainementprojettut.MainActivity;

/**
 * Created by prax on 16/01/2018.
 */

public class ActivityUtil extends AppCompatActivity {
    protected static boolean song=true;
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

    public static boolean isSong() {
        return song;
    }

    public static  void setSong(boolean song) {
        ActivityUtil.song = song;
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
      if(!this.getClass().equals(MainActivity.class)) {

          if (bgPlayer != null) {
              bgPlayer.stop();
          }
          Intent back = new Intent(getApplicationContext(), MainActivity.class);

          startActivity(back);

      }else {
          MainActivity.setPlayerName("") ;


      }
        super.onBackPressed();

/*
       new AlertDialog.Builder(this)
               .setTitle("Really Exit?")
               .setMessage("Are you sure you want to exit?")
               .setNegativeButton(android.R.string.no, null)
               .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                   public void onClick(DialogInterface arg0, int arg1) {
                       //ActivityUtil.super.onBackPressed();
                       finish();
                   }
               }).create().show();*/
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
