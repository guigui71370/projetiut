package com.example.cassa.entrainementprojettut.pianoGame;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.cassa.entrainementprojettut.gameUtils.GameActivity;
import com.example.cassa.entrainementprojettut.R;

import java.util.List;

public class PianoActivity extends GameActivity implements View.OnClickListener {

    private Button mButtonDo;
    private Button mButtonRe;
    private Button mButtonMi;
    private Button mButtonFa;
    private Button mButtonSol;
    private Button mButtonLa;
    private Button mButtonSi;

    private ImageView mHeartOne;
    private ImageView mHeartTwo;
    private ImageView mHeartThree;

    private ImageView[] mHeartList = {mHeartOne, mHeartTwo, mHeartThree};
    private int mHeartPosition = 2;


    private Button[] buttonsTab = {mButtonDo, mButtonRe, mButtonMi, mButtonFa, mButtonSol, mButtonLa, mButtonSi};
    private int idKey;

    IControlerMusic controlerMusic;

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piano);


        music = R.raw.geography_music;
        //startBackgroundMusic(PianoActivity.this, music);
        initializeGame();
        showMenu();
        setPianoButton();

        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                if (levelChosen != 0) {
                    initializeScoreValues("piano",levelChosen);
                    generatNewGame();
                } else {
                    PianoActivity.this.onStop();
                    dialog.show();
                }

            }
        });

    }

    private void generatNewGame() {
        //controlerMusic = new ControlerMusicEasy(levelChosen);
        controlerMusic = FactoryMusicControler.createControlerMusic(levelChosen);
        showSequence();
    }


    private void showSequence() {
        enableButton(false);
        List<Integer> listId = controlerMusic.getIdSequence();
        switchButtonWhite();
        for (int id = 0; id<listId.size(); id++) {
            idKey = listId.get(id) - 1;

            //On redéfinit les Runnables
            int timeGreen = (id+1)*1000+200;
            int timeGray = ((id+1)*2000)-(id*1000);

            handler.postDelayed(runGreen(idKey, (View) buttonsTab[idKey]), timeGreen);
            handler.postDelayed(runWhite(idKey), timeGray);
        }

        handler.postDelayed(enableButton(), listId.size() * 1300);

    }


    private void enableButton(boolean enable) {
        for(Button button: buttonsTab){
            button.setEnabled(enable);
        }
    }


    private Runnable runWhite(final int pi){

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                buttonsTab[pi].setBackgroundColor(Color.WHITE);

            }
        };
        return runnable;
    }


    private Runnable runGreen(final int pi, final View note){

        Runnable greenRunnable = new Runnable() {
            @Override
            public void run() {
                buttonsTab[pi].setBackgroundColor(Color.GREEN);
                controlerMusic.playSong(PianoActivity.this, note);
            }
        };
        return greenRunnable;
    }

    private Runnable enableButton(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                enableButton(true);
            }
        };

        return runnable;
    }


    private void setPianoButton() {

        mHeartList[0] = findViewById(R.id.activity_piano_heart_1);
        mHeartList[1] = findViewById(R.id.activity_piano_heart_2);
        mHeartList[2] = findViewById(R.id.activity_piano_heart_3);

        buttonsTab[0] = (Button) findViewById(R.id.activity_piano_key_do);
        buttonsTab[1] = (Button) findViewById(R.id.activity_piano_key_re);
        buttonsTab[2] = (Button) findViewById(R.id.activity_piano_key_mi);
        buttonsTab[3] = (Button) findViewById(R.id.activity_piano_key_fa);
        buttonsTab[4] = (Button) findViewById(R.id.activity_piano_key_sol);
        buttonsTab[5] = (Button) findViewById(R.id.activity_piano_key_la);
        buttonsTab[6] = (Button) findViewById(R.id.activity_piano_key_si);

        buttonsTab[0].setOnClickListener(this);
        buttonsTab[1].setOnClickListener(this);
        buttonsTab[2].setOnClickListener(this);
        buttonsTab[3].setOnClickListener(this);
        buttonsTab[4].setOnClickListener(this);
        buttonsTab[5].setOnClickListener(this);
        buttonsTab[6].setOnClickListener(this);

        switchButtonWhite();
    }

    private void switchButtonWhite() {
        for (Button button: buttonsTab){
            button.setBackgroundColor(Color.WHITE);
        }
    }

    @Override
    public void onClick(View v) {
        int keyId = Integer.parseInt((String) v.getTag());
        int answer = controlerMusic.checkKey(keyId);
        controlerMusic.playSong(PianoActivity.this, v);

        checkAnswer(answer, v);


    }

    public void checkAnswer(int answer, View view) {
        if (answer>=0){
            rightAnswerConsequences(answer);
            colorCorrect(view);
        }else{
            wrongAnswerConsequences();
            colorError(view);
        }
    }


    private void colorCorrect(View view) {
        view.setBackgroundColor(Color.YELLOW);
        int id = Integer.parseInt(String.valueOf(view.getTag()));
        handler.postDelayed(runWhite(id-1), 350);
    }


    private void colorError(View view) {
        view.setBackgroundColor(Color.RED);
        int id = Integer.parseInt(String.valueOf(view.getTag()));
        handler.postDelayed(runWhite(id-1), 500);
    }


    public void wrongAnswerConsequences() {
        showText(getString(R.string.Too_bad));

        controlerMusic.setLife(mHeartList[mHeartPosition]);
        mHeartPosition -= 1;

        if(controlerMusic.isDead()){

            if (controlerMusic.controlerType().equals("score") && controlerMusic.getSequenceSize()>=controlerMusic.getEndSong()){
    numericalScore = controlerMusic.getSequenceSize()-1;
                showResultScreen(this);
            }else {
                showLooseScreen(this);
            }

        }else {
            showSequence();
        }
    }

    public void rightAnswerConsequences(int answer) {
        if(controlerMusic.songFinished()){

            firework(R.id.activity_piano_layout_life);

            showText(getString(R.string.You_have_win));
            if (!controlerMusic.controlerType().equals("score")) {
                showResultScreen(this);
            }else {
                showSequence();
            }

        }else{
            if(answer==0){
                showText(getString(R.string.Well_played));
                showSequence();
            }
        }
    }
    private void showMenu(){
        String[] menu = new String[4];
        menu[0]= getString(R.string.Level_1);
        menu[1]= getString(R.string.Level_2);
        menu[2]= getString(R.string.Level_3);
        menu[3]= getString(R.string.Level_score);
        displayLevelchoice(this,menu);
    }

}
