package com.example.cassa.entrainementprojettut.echecs;

import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;

import android.util.Log;
import android.view.View;

import android.widget.Chronometer;
import android.widget.GridLayout;
import android.widget.ImageView;
import com.example.cassa.entrainementprojettut.R;
import com.example.cassa.entrainementprojettut.echecs.pion.Piece;
import com.example.cassa.entrainementprojettut.echecs.plateau.Case;
import com.example.cassa.entrainementprojettut.echecs.plateau.Echiquier;
import com.example.cassa.entrainementprojettut.gameUtils.GameActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ChessActivity extends GameActivity implements View.OnClickListener {

    private GridLayout gridLayout;
    private Chronometer chronometer;

    private ImageView[][] board = new ImageView[8][8];
    private Echiquier echiquier = new Echiquier();
    private List<Case> mouvementDernierePieceClique = new ArrayList<>();
   // private ImageView derniereImageClique = new ImageView(this);

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
                image.setTag(new int[]{x,y});
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
        board[0][0].setTag(new int[]{0,0});
        board[0][1].setImageDrawable(cavalierNoir);
        board[0][1].setTag(new int[]{0,1});
        board[0][2].setImageDrawable(fouNoir);
        board[0][2].setTag(new int[]{0,2});
        board[0][3].setImageDrawable(reineNoir);
        board[0][3].setTag(new int[]{0,3});
        board[0][4].setImageDrawable(roiNoir);
        board[0][4].setTag(new int[]{0,4});
        board[0][5].setImageDrawable(fouNoir);
        board[0][5].setTag(new int[]{0,5});
        board[0][6].setImageDrawable(cavalierNoir);
        board[0][6].setTag(new int[]{0,6});
        board[0][7].setImageDrawable(tourNoir);
        board[0][7].setTag(new int[]{0,7});

        board[7][0].setImageDrawable(tourBlanche);
        board[7][0].setTag(new int[]{7,0});
        board[7][1].setImageDrawable(cavalierBlanc);
        board[7][1].setTag(new int[]{7,1});
        board[7][2].setImageDrawable(fouBlanc);
        board[7][2].setTag(new int[]{7,2});
        board[7][3].setImageDrawable(reineBlanche);
        board[7][3].setTag(new int[]{7,3});
        board[7][4].setImageDrawable(roiBlanc);
        board[7][4].setTag(new int[]{7,4});
        board[7][5].setImageDrawable(fouBlanc);
        board[7][5].setTag(new int[]{7,5});
        board[7][6].setImageDrawable(cavalierBlanc);
        board[7][6].setTag(new int[]{7,6});
        board[7][7].setImageDrawable(tourBlanche);
        board[7][7].setTag(new int[]{7,7});

        for(int i = 0; i < gridLayout.getColumnCount(); i++){
            board[1][i].setImageDrawable(pionNoir);
            board[1][i].setTag(new int[]{1,i});
            board[6][i].setImageDrawable(pionBlanc);
            board[6][i].setTag(new int[]{6,i});
        }
    }

    private void showMenu(){
        String[] menu = new String[1];
        menu[0]= "Niveau 1";
        displayLevelchoice(this,menu);
    }

    private int[] getBoardDoubleIndiceFromOneIndice(String coordonnee){
        HashMap<String, int[]> translateCoordonnee = new HashMap<>();
        String[] coords = {
                "a8","b8","c8","d8","e8","f8","g8","h8",
                "a7","b7","c7","d7","e7","f7","g7","h7",
                "a6","b6","c6","d6","e6","f6","g6","h6",
                "a5","b5","c5","d5","e5","f5","g5","h5",
                "a4","b4","c4","d4","e4","f4","g4","h4",
                "a3","b3","c3","d3","e3","f3","g3","h3",
                "a2","b2","c2","d2","e2","f2","g2","h2",
                "a1","b1","c1","d1","e1","f1","g1","h1"
        };
        int ligne = 0;
        int colonne = 0;
        for (String foo : coords) {
            translateCoordonnee.put(foo, new int[]{ligne,colonne});
            colonne++;
            if(colonne == 8){
                colonne = 0;
                ligne += 1;
            }
        }
        return translateCoordonnee.get(coordonnee);
    }

    private int getBoardOneIndiceFromDoubleIndice(int[] coordonnee){
        return (coordonnee[0] * 8)  + coordonnee[1];
    }

    private void resetBackground(){
        for(int x = 0; x < gridLayout.getRowCount(); x++) {
            for (int y = 0; y < gridLayout.getColumnCount(); y++) {
                if((x+y)%2 == 0){
                    board[x][y].setBackgroundColor(getResources().getColor(R.color.lightBrown));
                }else{
                    board[x][y].setBackgroundColor(getResources().getColor(R.color.brown));
                }
            }
        }
    }

    @Override
    public void onClick(View view) {
        if (view instanceof ImageView) {
            resetBackground();

            int[] doubleCoordonnee = (int[]) view.getTag();
            Log.d("case", "onClick: je clique sur une la case au double coordonnee : " + String.valueOf(doubleCoordonnee[0]) + "," + String.valueOf(doubleCoordonnee[1]));
            view.setBackgroundColor(getResources().getColor(R.color.pink));

            int position = getBoardOneIndiceFromDoubleIndice(doubleCoordonnee);
            Log.d("coordonnee", "case numero : " + position);

            Piece pieceCorrespondante =  echiquier.getBoard()[position].getPiece();
            Log.d("echiquier", "onClick: piece a la coordonnee clique : " + pieceCorrespondante.getClass().getSimpleName());

            List<Case> listMouvementPossibles = new ArrayList<>();
            listMouvementPossibles.addAll(pieceCorrespondante.getPossibleMoves(position,echiquier.getBoard()));

            for (Case foo: listMouvementPossibles) {
                Log.d("mouvementPossible", "onClick: cases de deplacement possible : " + foo.getCoord());
                doubleCoordonnee = getBoardDoubleIndiceFromOneIndice(foo.getCoord());
                board[doubleCoordonnee[0]][doubleCoordonnee[1]].setBackgroundColor(getResources().getColor(R.color.black));
            }
        }
    }
}
