package com.example.cassa.entrainementprojettut.echecs;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
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
        for(int x = 0; x < gridLayout.getRowCount(); x++) {
            for (int y = 0; y < gridLayout.getColumnCount(); y++) {
                ImageView image = new ImageView(this);
                image.setOnClickListener(this);
                image.setImageResource(R.drawable.square);
                image.setImageDrawable(null);
                if((x+y)%2 == 0){
                    image.setBackgroundColor(getResources().getColor(R.color.lightBrown));
                }else{
                    image.setBackgroundColor(getResources().getColor(R.color.brown));
                }
                GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
                layoutParams.width = 75;
                layoutParams.height = 75;
                image.setLayoutParams(layoutParams);
                //Le tag indique la colonne
                image.setTag(R.id.activity_chess_gameBoard_gridLayout,x);
                board[x][y] = image;
                gridLayout.addView(image);
            }
        }
        placePieceAtStart();
    }
    private void placePieceAtStart(){
        Drawable roiNoir = getResources().getDrawable(R.drawable.roinoir);
        Drawable roiBlanc = getResources().getDrawable(R.drawable.roiblanc);
        Drawable reineNoir = getResources().getDrawable(R.drawable.reinenoir);
        Drawable reineBlanche = getResources().getDrawable(R.drawable.reineblanche);
        Drawable fouNoir = getResources().getDrawable(R.drawable.founoir);
        Drawable fouBlanc = getResources().getDrawable(R.drawable.foublanc);
        Drawable cavalierNoir = getResources().getDrawable(R.drawable.cavaliernoir);
        Drawable cavalierBlanc = getResources().getDrawable(R.drawable.cavalierblanc);
        Drawable tourNoir = getResources().getDrawable(R.drawable.tournoir);
        Drawable tourBlanche = getResources().getDrawable(R.drawable.tourblanche);
        Drawable pionNoir = getResources().getDrawable(R.drawable.pionnoir);
        Drawable pionBlanc = getResources().getDrawable(R.drawable.pionblanc);
        board[0][0].setImageDrawable(tourNoir);
        board[0][1].setImageDrawable(cavalierNoir);
        board[0][2].setImageDrawable(fouNoir);
        board[0][3].setImageDrawable(reineNoir);
        board[0][4].setImageDrawable(roiNoir);
        board[0][5].setImageDrawable(fouNoir);
        board[0][6].setImageDrawable(cavalierNoir);
        board[0][7].setImageDrawable(tourNoir);

        board[7][0].setImageDrawable(tourBlanche);
        board[7][1].setImageDrawable(cavalierBlanc);
        board[7][2].setImageDrawable(fouBlanc);
        board[7][3].setImageDrawable(reineBlanche);
        board[7][4].setImageDrawable(roiBlanc);
        board[7][5].setImageDrawable(fouBlanc);
        board[7][6].setImageDrawable(cavalierBlanc);
        board[7][7].setImageDrawable(tourBlanche);

        for(int i = 0; i < gridLayout.getColumnCount(); i++){
            board[1][i].setImageDrawable(pionNoir);
            board[6][i].setImageDrawable(pionBlanc);
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
