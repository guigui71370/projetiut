package com.example.cassa.entrainementprojettut.connect4;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;

import android.support.v7.app.AlertDialog;
import android.view.View;

import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.cassa.entrainementprojettut.MainActivity;
import com.example.cassa.entrainementprojettut.R;
import com.example.cassa.entrainementprojettut.gameUtils.GameActivity;



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
        music = R.raw.bensound_smile;
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
        controlerConnect4 = new ControlerConnect4(levelChosen);
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
        controlerConnect4.setPlateauCia(coloria);

        //Pour celui qui joue en premier
        switch ((int)(Math.random() * 2)){
            // 0 equivaut au joueur
            case 0:
                showTextdurration("Vous commencez à jouer",2000);
                enableImage();
                break;
            // 1 equivaut a l'IA
            case 1:
                showTextdurration("L'ordinateur commence à jouer",2000);
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
        String[] menu = new String[4];
        menu[0]= "Niveau 1";
        menu[1]= "Niveau 2";
        menu[2]= "Niveau 3";
        menu[3]= "Niveau 4";

        displayLevelchoice(this,menu);
    }



    @Override
    public void onClick(View view) {
        if (view instanceof ImageView) {
            int column = (int)view.getTag(R.id.gridLayout);
            int row = controlerConnect4.insertCheckers(column,colorjoueur);
            if(row!=-1){

                final  ImageView t=board[row][column];

                handlers.postDelayed(new Runnable() {
                    @Override
                    public void run(){
                        t.setColorFilter(playerColor);
                        //enableImage();
                    }
                },20);



                disableImage();
                if(controlerConnect4.hasWinner()==1 ||controlerConnect4.hasWinner()==0){
                    final Connect4Activity win=this;
                    handlers.postDelayed(new Runnable() {

                        @Override
                        public void run(){
                            unableLoose();
                            unableScoreMode();
                            chronometer.stop();
                            timeScore = (SystemClock.elapsedRealtime() - chronometer.getBase()) / 1000;
                            initializeScoreValues("Puissance 4", levelChosen);
                            showResultScreen(win);
                        }},2000);

                    showTextdurration("Vous avez gagné",2000);
                }else if(controlerConnect4.hasWinner()==2) {
                    final Connect4Activity nulls=this;
                    handlers.postDelayed(new Runnable(){
                        @Override
                        public void run() {
                            showNullSreen(nulls);
                        }
                    },2000);
                }else {

                    iaPlaying();
                }
            }

        }

       /* if(controlerConnect4.hasWinner()==2){
            showTextdurration("match nulle",2000);
        }*/


       /* if(controlerConnect4.hasWinner()==1 ||controlerConnect4.hasWinner()==0){
            showText("match nulle");
        }*/
    }


    protected  final  Handler handlers = new Handler();
    public void iaPlaying(){
        int column = controlerConnect4.calculateCheckersPosition(levelChosen);

        int row = controlerConnect4.insertCheckers(column,coloria);

        final  ImageView t=board[row][column];
        final Connect4Activity etat=this;
        handlers.postDelayed(new Runnable() {
            @Override
            public void run(){
                t.setColorFilter(computerColor);
                //enableImage();
                if(controlerConnect4.hasWinner()==1 ||controlerConnect4.hasWinner()==0){
                    showTextdurration("L'ordinateur a gagné",2000);

                    handlers.postDelayed(new Runnable(){
                        @Override
                        public void run() {
                            showLooseScreen(etat);
                        }
                    },5000);
                }else  if(controlerConnect4.hasWinner()==2) {
                    handlers.postDelayed(new Runnable(){
                        @Override
                        public void run() {
                            showNullSreen(etat);

                        }
                    },2000);
                    showTextdurration("match nul",2000);
                }else {
                    enableImage();
                }

            }
        },1000);




        //showText("ia joue");


    }



    protected void showNullSreen(final Activity activity) {
        if(!activity.isFinishing()) {

            final boolean[] canLeave = {false};
            if (scoreMode != null) {
                handler.removeCallbacks(scoreMode);
            }

            levelChosen = 0;

            AlertDialog.Builder mBuilder = new AlertDialog.Builder(activity);

            View resultView = getLayoutInflater().inflate(R.layout.resultat_popup, null);

            Button replayButton = resultView.findViewById(R.id.resultat_popup_rejouer_btn);
            Button menuButton = resultView.findViewById(R.id.resultat_popup_menu_btn);
            TextView mTextViewMessage = resultView.findViewById(R.id.resultat_popup_messace_textView);

            mBuilder.setView(resultView);
            dialog = mBuilder.create();
            dialog.show();

            //On prend les caracs de l'écran
            WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
            Window window = dialog.getWindow();
            lp.copyFrom(window.getAttributes());

            //On l'applique au dialogue
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            window.setAttributes(lp);


            mTextViewMessage.setText("Dommage, match nul");

            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialogInterface) {
                    if (canLeave[0] == true) {
                        dialog.dismiss();

                    } else {
                        dialog.show();
                    }

                }
            });
            replayButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    canLeave[0] = true;
                    activity.recreate();
                    dialog.dismiss();

                }
            });
            menuButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    canLeave[0] = true;
                    Intent additionIntent = new Intent(activity, MainActivity.class);
                    startActivity(additionIntent);
                    activity.finish();

                }
            });
        }
    }
}
