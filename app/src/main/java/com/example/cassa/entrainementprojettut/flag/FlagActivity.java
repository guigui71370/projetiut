package com.example.cassa.entrainementprojettut.flag;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cassa.entrainementprojettut.R;
import com.example.cassa.entrainementprojettut.gameUtils.GameActivity;

import java.util.Random;

public class FlagActivity extends GameActivity implements View.OnClickListener {

    private  ImageView mFlag1;
    private ImageView mFlag2;
    private ImageView mFlag3;
    private ImageView mFlag4;


    private  TextView mCountryName;
    private TextView mScore;

    private String gGoodAnswer;

    private ControllerFlagBank controllerFlagBank;

    private boolean hasWon = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag);
        music = R.raw.bensound_funnysong;

        if(isSong()) {
            startBackgroundMusic(this, music);
        }
        showMenu();
        initializeGame();
        initializeFlag();
        initializeCountryNameAndScore();


        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                if (levelChosen != 0) {

                    generateNewGame();
                    initializeScoreValues("Flag",levelChosen);
                    launchGhost(FlagActivity.this,30000,R.id.activity_flag_IA_img);

                } else {
                    FlagActivity.this.onStop();
                    dialog.show();
                }

            }
        });



    }


    private void initializeCountryNameAndScore() {
        mCountryName = findViewById(R.id.activity_flag_name01_txt);
        mScore = findViewById(R.id.activity_flag_score_txt);

        numericalScore = 0;
        mScore.setText("0");
    }


    private void initializeFlag() {
        mFlag1 = findViewById(R.id.activity_flag_flag01);
        mFlag2 = findViewById(R.id.activity_flag_flag02);
        mFlag3 = findViewById(R.id.activity_flag_flag03);
        mFlag4 = findViewById(R.id.activity_flag_flag04);

        mFlag1.setOnClickListener(this);
        mFlag2.setOnClickListener(this);
        mFlag3.setOnClickListener(this);
        mFlag4.setOnClickListener(this);
    }


    protected void generateNewGame(){

        controllerFlagBank = new ControllerFlagBank(levelChosen);
        ImageView listeDrapeau[] = {mFlag1, mFlag2, mFlag3, mFlag4};
        enableFlag();
        generateCountryToFind(controllerFlagBank);
        generateFlagChoice(controllerFlagBank, listeDrapeau);
    }



    private void generateFlagChoice(ControllerFlagBank controllerFlagBank, ImageView[] flagList) {
        for(int i=0; i <4;i++) {
            flagList[i].setImageResource(controllerFlagBank.getFlag(i).getmRessource());
            flagList[i].setTag(controllerFlagBank.getFlag(i).getmNameCountry());
        }
    }

    private void generateCountryToFind(ControllerFlagBank controllerFlagBank) {
        Random rand = new Random();
        int numPaysMystere = rand.nextInt(4);

        mCountryName.setText(controllerFlagBank.getFlag(numPaysMystere).getmNameCountry());
        gGoodAnswer = controllerFlagBank.getFlag(numPaysMystere).getmNameCountry();
    }

    private void enableFlag() {
        mFlag1.setEnabled(true);
        mFlag2.setEnabled(true);
        mFlag3.setEnabled(true);
        mFlag4.setEnabled(true);

        mFlag1.setColorFilter(0);
        mFlag2.setColorFilter(0);
        mFlag3.setColorFilter(0);
        mFlag4.setColorFilter(0);
    }

    protected  void checkAnswer(ImageView v, String country){

        if(country == gGoodAnswer){

            showText(getString(R.string.Well_played));
            numericalScore = numericalScore + 5;
            mScore.setText(""+ numericalScore);
            generateNewGame();
            if(numericalScore >= 50 && hasWon == false){
                unableLoose();
                firework(R.id.flag_activity_layout);
                showText(getString(R.string.You_have_win));
                hasWon = true;

            }

        }
        else{
            showText(getString(R.string.Too_bad));

            numericalScore = numericalScore - 2;
            v.setBackgroundColor(Color.argb(150,200,200,200));
            v.setEnabled(false);
            mScore.setText(""+ numericalScore);
            v.setColorFilter(R.color.material_grey_600);
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
    public void onClick(View view) {
        String paysSelectione = (String) view.getTag();
        System.out.println(getString(R.string.Selectionned_country)+paysSelectione);

        checkAnswer((ImageView) view,paysSelectione);
    }

}
