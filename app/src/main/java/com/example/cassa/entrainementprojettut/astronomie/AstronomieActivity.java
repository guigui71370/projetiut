package com.example.cassa.entrainementprojettut.astronomie;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.cassa.entrainementprojettut.R;
import com.example.cassa.entrainementprojettut.astronomie.Controler.ControlerLVL1;
import com.example.cassa.entrainementprojettut.astronomie.Controler.ControlerLVL2;
import com.example.cassa.entrainementprojettut.astronomie.Controler.ControlerLVL3;
import com.example.cassa.entrainementprojettut.astronomie.Controler.ControlerLVL4;
import com.example.cassa.entrainementprojettut.gameUtils.GameActivity;


public class AstronomieActivity extends GameActivity implements View.OnClickListener {

    private Chronometer chronometer;
    private ConstraintLayout constraintLayout;

    Button verifier;
    TextView textBienPlacer;
    TextView planetBienPlacer;

    ImageView planet;
    ImageView planet1;
    ImageView planet2;
    ImageView planet3;
    ImageView planet4;

    TextView planetName;
    TextView planetName1;
    TextView planetName2;
    TextView planetName3;
    TextView planetName4;

    private int nbgoodAnswer = 0;
    private String rightAnswer = "test";

    protected Runnable activateButton=new Runnable() {
        @Override
        public void run() {
            activateButtons(levelChosen);
        }
    };
    private ImageView[] imagesPlanet;
    private LinearLayout[] conteneurPlanet_lvl4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_astronomie);
        showMenu();
        initializeGame();
        music = R.raw.bensound_anewbeginning;
        if(isSong()){
            startBackgroundMusic(this,music);
        }

        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                if (levelChosen <= 3) {
                    generatedNewGame();
                    launchTimer(AstronomieActivity.this,60000,R.id.activity_astronomie_ghost_img);
                    launchImageJoueur(R.id.activity_astronomie_star_img);
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    chronometer.start();
                } else if(levelChosen == 4) {
                    generatedNewGame();
                    findViewById(R.id.activity_astronomie_ghost_img).setVisibility(View.INVISIBLE);
                    findViewById(R.id.activity_astronomie_star_img).setVisibility(View.INVISIBLE);
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    chronometer.start();
                } else{
                    AstronomieActivity.this.onStop();
                    dialog.show();
                }
            }
        });

        planet = findViewById(R.id.activity_astronomie_planet_imageView);
        planet1 = findViewById(R.id.activity_astronomie_planet1_imageView);
        planet2 = findViewById(R.id.activity_astronomie_planet2_imageView);
        planet3 = findViewById(R.id.activity_astronomie_planet3_imageView);
        planet4 = findViewById(R.id.activity_astronomie_planet4_imageView);

        planetName = findViewById(R.id.activity_astronomie_planetName_textView);

        planetName1 = findViewById(R.id.activity_astronomie_planetName1_textView);
        planetName2 = findViewById(R.id.activity_astronomie_planetName2_textView);
        planetName3 = findViewById(R.id.activity_astronomie_planetName3_textView);
        planetName4 = findViewById(R.id.activity_astronomie_planetName4_textView);

        constraintLayout = findViewById(R.id.activity_astronomie_constraintLayout);

        chronometer = findViewById(R.id.activity_astronomie_chrono_chronometer2);
    }

    @SuppressLint("ClickableViewAccessibility")
    private void activateListerner(int levelChosen) {
        switch (levelChosen){
            case 2:
                planet1.setOnClickListener(this);
                planet2.setOnClickListener(this);
                planet3.setOnClickListener(this);
                planet4.setOnClickListener(this);
                break;
            case 3:
                planetName1.setOnClickListener(this);
                planetName2.setOnClickListener(this);
                planetName3.setOnClickListener(this);
                planetName4.setOnClickListener(this);
                break;
            case 4 :
                verifier.setOnClickListener(this);
                break;
        }
    }

    private void activateButtons(int levelChosen) {
        switch (levelChosen){
            case 2:
                planet1.setEnabled(true);
                planet2.setEnabled(true);
                planet3.setEnabled(true);
                planet4.setEnabled(true);
                planetName.setEnabled(true);
                break;
            case 3:
                planetName1.setEnabled(true);
                planetName2.setEnabled(true);
                planetName3.setEnabled(true);
                planetName4.setEnabled(true);
                planet.setEnabled(true);
                break;
            case 4:
                verifier.setEnabled(true);
                break;
        }
    }

    private void disableButtons(int levelChosen) {
        switch (levelChosen){
            case 2:
                planetName.setEnabled(false);
                planet1.setEnabled(false);
                planet2.setEnabled(false);
                planet3.setEnabled(false);
                planet4.setEnabled(false);
                break;
            case 3:
                planetName1.setEnabled(false);
                planetName2.setEnabled(false);
                planetName3.setEnabled(false);
                planetName4.setEnabled(false);
                planet.setEnabled(false);
                break;
            case 4:
                verifier.setEnabled(false);
                break;
        }
    }

    public void generatedNewGame(){
        switch (levelChosen){
            case 1:
                ConstraintLayout conteneurRect1 = (ConstraintLayout) getLayoutInflater().inflate(R.layout.activity_astronomie_lvl3, constraintLayout, false);
                constraintLayout.addView(conteneurRect1);
                activateListerner(levelChosen);
                ControlerLVL1 controlerAstronomie1 = new ControlerLVL1(this,constraintLayout);
                break;
            case 2:
                activateListerner(levelChosen);
                ControlerLVL2 controlerAstronomie2 = new ControlerLVL2(this,constraintLayout);
                this.rightAnswer = getResources().getResourceEntryName(controlerAstronomie2.getRightAnswer());
                break;
            case 3:
                activateListerner(levelChosen);
                ControlerLVL3 controlerAstronomie3 = new ControlerLVL3(this,constraintLayout);
                this.rightAnswer = getResources().getResourceEntryName(controlerAstronomie3.getRightAnswer());
                break;
            case 4:
                ConstraintLayout conteneurRect = (ConstraintLayout) getLayoutInflater().inflate(R.layout.activity_astronomie_lvl3, constraintLayout, false);
                constraintLayout.addView(conteneurRect);

                this.verifier = findViewById(R.id.activity_astronomie_lvl3_verifier_button);
                verifier.setVisibility(View.VISIBLE);
                this.planetBienPlacer = findViewById(R.id.activity_astronomie_lvl3_planeteBienPlace_textView);
                planetBienPlacer.setVisibility(View.VISIBLE);
                this.textBienPlacer = findViewById(R.id.activity_astronomie_lvl3_textBienPlace_textView);
                textBienPlacer.setVisibility(View.VISIBLE);
                activateListerner(levelChosen);
                ControlerLVL4 controlerAstronomie4 = new ControlerLVL4(this,constraintLayout);
                this.imagesPlanet = controlerAstronomie4.getImagesPlanet();
                this.conteneurPlanet_lvl4 = controlerAstronomie4.getConteneurPlanet();
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        nbgoodAnswer = 10;
        checkAnswer("nn");
    }

    public void checkAnswer_LVL1(int rightInput){
        float screenWidth = getScreenWidth();
        if(rightInput <8){
            this.nbgoodAnswer++;

            moveImage(playerImage,playerImagePosition+(screenWidth/8),600,playerImagePosition);
            playerImagePosition = playerImagePosition + (screenWidth/8);

        }else if(rightInput==8){
            moveImage(playerImage,playerImagePosition+(screenWidth/8) - 73,600,playerImagePosition);
            unableLoose();
            unableScoreMode();
            chronometer.stop();
            timeScore = (SystemClock.elapsedRealtime() - chronometer.getBase()) / 1000;
            initializeScoreValues("Astronomie", levelChosen);
            showResultScreen(this);
        }else {
            generatedNewGame();
        }
    }

    public void checkAnswer_LVL4(){
        disableButtons(levelChosen);
        int nbGoodPlanet = 0;
        int nbGoodPlanetName = 0;
        if(this.nbgoodAnswer <= 3){
            this.nbgoodAnswer++;
                for(int i=0; i<8; i++){
                    if(this.imagesPlanet[i].getTransitionName().equals(this.imagesPlanet[i].getTag())) {
                        nbGoodPlanet++;
                    }
                    TextView foo = (TextView)this.conteneurPlanet_lvl4[i].getChildAt(0);
                    if(foo == null){
                        foo = new TextView(this);
                        foo.setText("");
                    }
                    if(foo.getText().equals(this.conteneurPlanet_lvl4[i].getContentDescription())){
                        nbGoodPlanetName++;
                    }
                }
                Log.d("ch", "nbGoodPlanet: " + nbGoodPlanet);
                Log.d("ch", "nbGoodPlanetName: " + nbGoodPlanetName);
                if(nbGoodPlanet == 8 && nbGoodPlanetName == 8){
                    unableLoose();
                    unableScoreMode();
                    chronometer.stop();
                    timeScore = (SystemClock.elapsedRealtime() - chronometer.getBase()) / 1000;
                    initializeScoreValues("Astronomie", levelChosen);
                    showResultScreen(this);
                }
                this.textBienPlacer.setText("Nom des planètes dans le bon ordre: " + nbGoodPlanetName + "/8");
                this.planetBienPlacer.setText("Planète dans le bon ordre : " + nbGoodPlanet + "/8");
            activateButtons(levelChosen);
        }else if(nbgoodAnswer==4){
            unableLoose();
            unableScoreMode();
            chronometer.stop();
            showLooseScreen(this);
        }else {
            generatedNewGame();
        }
    }

    public boolean checkAnswer(String planetName){
        float screenWidth = getScreenWidth();
        Log.d("astronomie", "planet name given : " + planetName);
        Log.d("astronomie", "right answer : " + rightAnswer);

        if(this.rightAnswer.equals(planetName)&& this.nbgoodAnswer<10) {
            this.nbgoodAnswer++;

            moveImage(playerImage, playerImagePosition + (screenWidth / 11), 600, playerImagePosition);
            playerImagePosition = playerImagePosition + (screenWidth / 11);
            this.generatedNewGame();

            return true;
        }else if(this.nbgoodAnswer==10){
            unableLoose();
            unableScoreMode();
            chronometer.stop();
            timeScore = (SystemClock.elapsedRealtime() - chronometer.getBase()) / 1000;
            initializeScoreValues("Astronomie", levelChosen);
            showResultScreen(this);
            return true;
        }else {
            generatedNewGame();
            return false;
        }
    }

    private void showMenu(){
        String[] menu = new String[4];
        menu[0] = "niveau 1";
        menu[1] = "niveau 2";
        menu[2] = "niveau 3";
        menu[3] = "niveau 4";

        displayLevelchoice(this,menu);
    }

    @Override
    public void onClick(View v) {
        if(v instanceof ImageView){
            disableButtons(levelChosen);
            if(checkAnswer(getResources().getResourceEntryName(v.getId()))){
                handler.postDelayed(activateButton,800);
            }else{
                handler.postDelayed(activateButton,2100);
            }
        }else if(v instanceof Button){
            checkAnswer_LVL4();
        }else if(v instanceof TextView) {
            disableButtons(levelChosen);
            if(checkAnswer(getResources().getResourceEntryName(v.getId()))){
                handler.postDelayed(activateButton,800);
            }else{
                handler.postDelayed(activateButton,2100);
            }
        }else{
            Log.d("Astronomie", "Erreur ");
        }
    }
}