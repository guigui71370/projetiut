package com.example.cassa.entrainementprojettut.anglais;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.constraint.ConstraintLayout;
import android.widget.Chronometer;
import android.widget.GridLayout;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.cassa.entrainementprojettut.R;
import com.example.cassa.entrainementprojettut.gameUtils.GameActivity;


public class EnglishActivity extends GameActivity {
    @BindView(R.id.chronometer2)
     Chronometer time;
    @BindView(R.id.layout_niveau)
    ConstraintLayout mainLayout;

    private MediaPlayer playerEvent;



    private  int rightAnswerCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english);
        ButterKnife.bind(this);
        initializeGame();

        showMenu();

        /*initializeSizeOfATag();
        initializeGameAfterMenuDismiss();*/
        initializeGameAfterMenuDismiss();
        if(isSong()) {
            startBackgroundMusic(EnglishActivity.this, R.raw.geography_music);
        }
        playerEvent= MediaPlayer.create(EnglishActivity.this,R.raw.envent_sound);
    }

    private void initializeGameAfterMenuDismiss() {
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                if (levelChosen != 0) {
                    initializeScoreValues("Anglais",levelChosen);
                    time.setBase(SystemClock.elapsedRealtime());
                    time.start();
                    rightAnswerCounter =0;
                    setRectangleOnMap();

                } else {
                    showMenu();
                }
            }
        });
    }





    private void setRectangleOnMap(){


       GridLayout conteneurRect = (GridLayout) getLayoutInflater().inflate(R.layout.layout_level1anglais, mainLayout, false);

        mainLayout.addView(conteneurRect);

        int scale = (int) getResources().getDisplayMetrics().density;
        int margin =  10*scale;

        int row=0;
        GridLayout.Spec colSpec = conteneurRect.spec(2);

        for(row=0;row<conteneurRect.getRowCount();row++) {
            GridLayout.Spec rowSpec = conteneurRect.spec(row);


            ImageView image = new ImageView(this);
            image.setImageResource(R.drawable.rectangle);
            GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(rowSpec, colSpec);
            layoutParams.width = 300;
            layoutParams.height = 100;

            layoutParams.setMargins(margin, margin, margin, margin);
            image.setLayoutParams(layoutParams);


            conteneurRect.addView(image, layoutParams);
        }










        ///canvas.drawRect(rect, paint);
    }

    private void showMenu(){
        String[] menu = new String[4];
        menu[0]= "niveau 1";
        menu[1]= "niveau 2";
        menu[2]= "niveau 3";
        menu[3]= "niveau 4";
        displayLevelchoice(this,menu);
    }
}
