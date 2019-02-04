package com.example.cassa.entrainementprojettut.echecs;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;

import android.util.Log;
import android.view.View;

import android.widget.Chronometer;
import android.widget.GridLayout;
import android.widget.ImageView;
import com.example.cassa.entrainementprojettut.R;
import com.example.cassa.entrainementprojettut.gameUtils.GameActivity;



public class ChessActivity extends GameActivity implements View.OnClickListener {

    private GridLayout gridLayout;
    private Chronometer chronometer;

    private ImageView[][] board = new ImageView[8][8];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chess);
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
                    generateNewGame();
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    chronometer.start();
                } else {
                    ChessActivity.this.onStop();
                    dialog.show();
                }
            }
        });

        gridLayout = findViewById(R.id.activity_chess_gameBoard_gridLayout);
        chronometer = findViewById(R.id.activity_chess_chrono_chronometer);
        createGameBoard(gridLayout);
        disableImage();
    }

    private void generateNewGame() {
        enableImage();
        //disableImage();
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
                image.setImageResource(R.drawable.square);
                if((y+x)%2 == 0){
                    image.setColorFilter(Color.WHITE);
                }else{
                    image.setColorFilter(Color.BLACK);
                }
                GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
                layoutParams.width = 75;
                layoutParams.height = 75;
                image.setLayoutParams(layoutParams);
                //Le tag indique la colonne
                image.setTag(R.id.activity_chess_gameBoard_gridLayout,x);
                board[y][x] = image;
                gridLayout.addView(image);
            }
        }
    }

    private void showMenu(){
        String[] menu = new String[1];
        menu[0]= "Niveau 1";
        displayLevelchoice(this,menu);
    }

    @Override
    public void onClick(View view) {
        if (view instanceof ImageView) {
            Log.d("onclick", "onClick: je clique sur une image" );
        }
    }
}
