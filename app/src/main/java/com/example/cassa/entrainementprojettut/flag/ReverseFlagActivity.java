package com.example.cassa.entrainementprojettut.flag;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cassa.entrainementprojettut.R;
import com.example.cassa.entrainementprojettut.gameUtils.GameActivity;

import java.util.Random;

public class ReverseFlagActivity extends GameActivity implements View.OnClickListener {

    private ImageView mFlag;
    private TextView mScore;

    private Button mCountryName1;
    private Button mCountryName2;
    private Button mCountryName3;
    private Button mCountryName4;

    private String gGoodAnswer;

    private boolean hasWon = false;

    private ControllerFlagBank controllerFlagBank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reverse_flag);

        music = R.raw.bensound_goinghigher;
        initializeGame();
        startBackgroundMusic(this, music);
        showMenu();
        initializeCountryNames();
        initializeAnswersAndScore();



        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                if(levelChosen != 0){

                    generateNewGame();

                    initializeScoreValues("Drapeaux inversés",levelChosen);
                    launchTimer(ReverseFlagActivity.this,35000,R.id.activity_flag_IA_img);


                }else{
                    ReverseFlagActivity.this.onStop();
                    dialog.show();
                }
            }
        });
    }



    private void initializeAnswersAndScore() {
        mFlag = findViewById(R.id.activity_reverse_flag_drapeau);
        mScore = findViewById(R.id.activity_reverse_flag_score);


        numericalScore =0;
        mScore.setText("0");
    }



    private void initializeCountryNames() {
        mCountryName1 = findViewById(R.id.activity_reverse_flag_name1);
        mCountryName2 = findViewById(R.id.activity_reverse_flag_name2);
        mCountryName3 = findViewById(R.id.activity_reverse_flag_name3);
        mCountryName4 = findViewById(R.id.activity_reverse_flag_name4);

        mCountryName1.setOnClickListener(this);
        mCountryName2.setOnClickListener(this);
        mCountryName3.setOnClickListener(this);
        mCountryName4.setOnClickListener(this);
    }



    protected void generateNewGame(){

        controllerFlagBank = new ControllerFlagBank(levelChosen);


        Button[] buttonList = {mCountryName1, mCountryName2, mCountryName3, mCountryName4};

        enableCoutryNames();

        generateAnswer(controllerFlagBank);

        generateChoices(controllerFlagBank, buttonList);


    }


    private void generateChoices(ControllerFlagBank flagBank, Button[] buttonList) {
        for(int i = 0; i<4; i++){
            buttonList[i].setText(flagBank.getFlag(i).getmNameCountry());
            buttonList[i].setTag(flagBank.getFlag(i).getmNameCountry());
        }
    }


    private void generateAnswer(ControllerFlagBank flagBank) {
        Random random = new Random();
        int answerNumber = random.nextInt(4);

        gGoodAnswer = flagBank.getFlag(answerNumber).getmNameCountry();
        mFlag.setImageResource(flagBank.getFlag(answerNumber).getmRessource());
    }



    private void enableCoutryNames() {
        mCountryName1.setEnabled(true);
        mCountryName2.setEnabled(true);
        mCountryName3.setEnabled(true);
        mCountryName4.setEnabled(true);
    }




    public void checkAnswer(Button button, String mNomPays){
        if(gGoodAnswer.equals(mNomPays)){

            numericalScore+=5;
            mScore.setText(""+numericalScore);
            generateNewGame();
            if(numericalScore >= 50 && hasWon == false){

                firework(R.id.activity_reverse_flag_layout);
                showText(getString(R.string.You_have_win));
                hasWon = true;
                unableLoose();



            }else {
                showText(getString(R.string.Well_played));
            }
        }else{
            showText(getString(R.string.Too_bad));

            numericalScore -=2;
            button.setEnabled(false);
            mScore.setText(""+ numericalScore);

        }
    }
    private void showMenu(){
        String[] menu = new String[3];
        menu[0]= getString(R.string.Level_1);
        menu[1]= getString(R.string.Level_2);
        menu[2]= getString(R.string.Level_3);
        displayLevelchoice(this,menu);
    }


    @Override
    public void onClick(View view){
        String mNomPays = (String) view.getTag();

        checkAnswer((Button) view, mNomPays);
    }

}
