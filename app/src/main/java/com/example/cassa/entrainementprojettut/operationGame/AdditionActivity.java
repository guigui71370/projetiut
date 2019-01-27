package com.example.cassa.entrainementprojettut.operationGame;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import com.example.cassa.entrainementprojettut.R;
import com.example.cassa.entrainementprojettut.gameUtils.GameActivity;

public class AdditionActivity extends GameActivity implements View.OnClickListener{

    private TextView mNumber1;
    private TextView mNumber2;
    private TextView mSigne;

    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;

    private Chronometer chronometer;

    private OperationController ctrl;

    private MediaPlayer playerEvent;

    private int rightAnswerCounter;

    protected Runnable activateButton=new Runnable() {
        @Override
        public void run() {
            activateButtons();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);
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
                    generateOperation();
                    launchTimer(AdditionActivity.this,60000,R.id.activity_addition_ordi_img);
                    launchImageJoueur(R.id.acivity_addition_pos1_img);
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    chronometer.start();
                } else {
                    AdditionActivity.this.onStop();
                    dialog.show();
                }
            }
        });

        playerEvent = MediaPlayer.create(AdditionActivity.this,R.raw.envent_sound);

        rightAnswerCounter = 0;
        // On recupère les widgets

        mNumber1 = findViewById(R.id.activity_addition_nombre1_textview);
        mNumber2 = findViewById(R.id.activity_addition_nombre2_textview);
        mSigne = findViewById(R.id.activity_addition_operateur_textview);

        mButton1 = findViewById(R.id.activity_addition_rep1_btn);
        mButton2 = findViewById(R.id.activity_addition_rep2_btn);
        mButton3 = findViewById(R.id.activity_addition_rep3_btn);
        mButton4 = findViewById(R.id.activity_addition_rep4_btn);

        chronometer = findViewById(R.id.chronometer2);

    }

    @SuppressLint("SetTextI18n")
    protected void generateOperation(){


        ctrl = new OperationController(levelChosen);


        //Affichage de l'opération

        int[] termesOperation=ctrl.getTermesOperation();

        mNumber1.setText(""+termesOperation[0]);
        mNumber2.setText(""+termesOperation[1]);
        mSigne.setText(""+ctrl.getSigneOperation());

        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
        mButton4.setOnClickListener(this);

        shuffleAnswers();

    }

    protected void shuffleAnswers(){

        int answerPosition=(int)(Math.random() * 4);

        Button tabButton[] = {mButton1,mButton2,mButton3,mButton4};
        int tabAnswer[] = new int[4];
        int i;

        for(i = 0;i<4;i++){
            if(i< answerPosition){
                tabAnswer[i] = ctrl.getAnswer() - (answerPosition - i);
            }
            else if(i == answerPosition){
                tabAnswer[i] = ctrl.getAnswer();
            }
            else{
                tabAnswer[i] = ctrl.getAnswer() + (i - answerPosition);
            }
        }

        for(i=0;i<4; i++) {
            //int indiceListe = (int) (Math.random() * listeReponses.size());
            tabButton[i].setTag(tabAnswer[i]);
            tabButton[i].setText("" + tabAnswer[i]);

        }
    }

    public boolean checkAnswer(int reponseEnvoyee){
        float screenWidth = getScreenWidth();

        if(ctrl.checkAnswer(reponseEnvoyee)){


            rightAnswerCounter++;
            showText(getString(R.string.Well_played));
            playerEvent.start();

            moveImage(playerImage,playerImagePosition+(screenWidth/11),600,playerImagePosition);
            playerImagePosition = playerImagePosition + (screenWidth/11);

            if(rightAnswerCounter == 10){
                unableLoose();
                unableScoreMode();
                chronometer.stop();
                timeScore =  (SystemClock.elapsedRealtime() - chronometer.getBase())/1000;
                initializeScoreValues("Opération",levelChosen);
                showResultScreen(this);

            }
            else{
                generateOperation();
            }

            return true;

        }
        else{

            showText(getString(R.string.to_bad) + ctrl.getAnswer());
            generateOperation();

            return false;
        }

    }

    protected void disableButton(){

        mButton1.setEnabled(false);
        mButton2.setEnabled(false);
        mButton3.setEnabled(false);
        mButton4.setEnabled(false);

        mButton1.setBackgroundColor(Color.rgb(99,99,99));
        mButton2.setBackgroundColor(Color.rgb(99,99,99));
        mButton3.setBackgroundColor(Color.rgb(99,99,99));
        mButton4.setBackgroundColor(Color.rgb(99,99,99));
    }

    protected void activateButtons(){

        mButton1.setEnabled(true);
        mButton2.setEnabled(true);
        mButton3.setEnabled(true);
        mButton4.setEnabled(true);

        mButton1.setBackgroundColor(Color.rgb(255,0,0));
        mButton2.setBackgroundColor(Color.rgb(0,255,0));
        mButton3.setBackgroundColor(Color.rgb(60,80,255));
        mButton4.setBackgroundColor(Color.rgb(255,255,0));
    }

    @Override
    public void onClick(View view) {
        int reponseEnvoyee = (int) view.getTag();
        disableButton();
        if(checkAnswer(reponseEnvoyee)) {

            handler.postDelayed(activateButton, 800);
        }
        else{
            handler.postDelayed(activateButton, 2100);

        }

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
}