package com.example.cassa.entrainementprojettut.connect4;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.content.res.TypedArrayUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.cassa.entrainementprojettut.R;
import com.example.cassa.entrainementprojettut.gameUtils.GameActivity;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Connect4Activity extends GameActivity implements View.OnClickListener {

    private GridLayout gridLayout;
    private Chronometer chronometer;
    private MediaPlayer playerEvent;

    private ImageView[][] board = new ImageView[6][7];
    ControlerConnect4 controlerConnect4;
    private int playerColor;
    private int computerColor;



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
                    //launchTimer(Connect4Activity.this,60000,R.id.acivity_addition_pos1_img,R.id.activity_addition_ordi_img);
                    generateNewGame();
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    chronometer.start();
                } else {
                    Connect4Activity.this.onStop();
                    dialog.show();
                }
            }
        });

        gridLayout = findViewById(R.id.gridLayout);
        chronometer = findViewById(R.id.activity_connect4_chrono_chronometer);
        playerEvent = MediaPlayer.create(Connect4Activity.this,R.raw.envent_sound);

        createGameBoard(gridLayout);
        disableImage();
    }

    private void generateNewGame() {
        controlerConnect4 = new ControlerConnect4();
        //disableImage();
        initializePlayer();
    }

    public char coloria;
    public char colorjoueur;
    private void initializePlayer() {
        //Pour la couleur
        switch ((int)(Math.random() * 2)){
            case 0:
                colorjoueur='r';
                playerColor = Color.RED;

                coloria='y';
                computerColor = Color.YELLOW;

                break;
            case 1:
                colorjoueur='y';
                playerColor = Color.YELLOW;
                coloria='r';
                computerColor = Color.RED;
                break;
        }
        //Pour celui qui joue en premier
        switch ((int)(Math.random() * 2)){
            // 0 equivaut au joueur
            case 0:
                enableImage();
                break;
            // 1 equivaut a l'IA
            case 1:
                disableImage();
                iaPlaying();
                break;
        }
    }



    private void disableImage(){
        int i, j;
        for(i=0; i<board.length; i++) {
            for(j=0; j<board[i].length; j++) {
                board[i][j].setEnabled(false);
            }
        }
    }

    private void enableImage(){
        int i, j;
        for(i=0; i<board.length; i++) {
            for(j=0; j<board[i].length; j++) {
                board[i][j].setEnabled(true);
            }
        }
    }

    private void createGameBoard(GridLayout gridLayout) {
        for(int y = 0; y < gridLayout.getRowCount(); y++) {
            for (int x = 0; x < gridLayout.getColumnCount(); x++) {
                 ImageView image = new ImageView(this);
                 image.setOnClickListener(this);
                 image.setImageResource(R.drawable.circle);
                 GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
                 layoutParams.width = 100;
                 layoutParams.height = 100;
                 image.setLayoutParams(layoutParams);
                 //Le tag indique la colonne
                 image.setTag(R.id.gridLayout,x);
                 board[y][x] = image;
                 gridLayout.addView(image);
            }
        }
    }

    private void showMenu(){
        String[] menu = new String[2];
        menu[0]= "Facile";
        menu[1]= "Difficile";

        displayLevelchoice(this,menu);
    }



    @Override
    public void onClick(View view) {
        if (view instanceof ImageView) {
            int column = (int)view.getTag(R.id.gridLayout);
            int row = controlerConnect4.insertCheckers(column,colorjoueur);
            if(row!=-1){

                board[row][column].setColorFilter(playerColor);
                disableImage();
                if(controlerConnect4.hasWinner()==1 ||controlerConnect4.hasWinner()==0){

                    unableLoose();
                    unableScoreMode();
                    chronometer.stop();
                    timeScore = (SystemClock.elapsedRealtime() - chronometer.getBase()) / 1000;
                    initializeScoreValues("puissances 4", levelChosen);
                    showResultScreen(this);

                    showText("partie finie joueur win");
                }else if(controlerConnect4.hasWinner()==2) {
                    showText("match nulle");
                }else {
                    iaPlaying();
                }
            }

        }

        if(controlerConnect4.hasWinner()==2){
            showText("match nulle");
        }


       /* if(controlerConnect4.hasWinner()==1 ||controlerConnect4.hasWinner()==0){
            showText("match nulle");
        }*/
    }

    public void iaPlaying(){
        int column = controlerConnect4.calculateCheckersPosition(levelChosen).getColumn();

        int row = controlerConnect4.insertCheckers(column,coloria);
        while(row==-1){
             column = controlerConnect4.calculateCheckersPosition(levelChosen).getColumn();

             row = controlerConnect4.insertCheckers(column,coloria);
        }
        board[row][column].setColorFilter(computerColor);
        if(controlerConnect4.hasWinner()==1 ||controlerConnect4.hasWinner()==0){
            showText("partie finie ia win");



            showResultScreen(this);
        }else  if(controlerConnect4.hasWinner()==2) {
            showText("match nulle");
        }else {
            enableImage();
        }
        //showText("ia joue");


    }
}
