package com.example.cassa.entrainementprojettut.astronomie;

import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cassa.entrainementprojettut.R;
import com.example.cassa.entrainementprojettut.astronomie.Controler.ControlerLVL1;
import com.example.cassa.entrainementprojettut.astronomie.Controler.ControlerLVL2;
import com.example.cassa.entrainementprojettut.astronomie.Controler.ControlerLVL3;
import com.example.cassa.entrainementprojettut.gameUtils.GameActivity;


public class AstronomieActivity extends GameActivity implements View.OnClickListener {

    private Chronometer chronometer;
    private ConstraintLayout constraintLayout;


    TextView planeteName1_lvl3;
    TextView planeteName2_lvl3;
    TextView planeteName3_lvl3;
    TextView planeteName4_lvl3;
    TextView planeteName5_lvl3;
    TextView planeteName6_lvl3;
    TextView planeteName7_lvl3;
    TextView planeteName8_lvl3;
    TextView[] txtPlanet_lvl3;

    LinearLayout planeteMercure_lvl3;
    LinearLayout planeteVenus_lvl3;
    LinearLayout planeteTerre_lvl3;
    LinearLayout planeteMars_lvl3;
    LinearLayout planeteJupiter_lvl3;
    LinearLayout planeteSaturne_lvl3;
    LinearLayout planeteUranus_lvl3;
    LinearLayout planeteNeptune_lvl3;
    LinearLayout[] conteneurPlanet_lvl3;

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
    private int rightInput = 0;

    protected Runnable activateButton=new Runnable() {
        @Override
        public void run() {
            activateButtons(levelChosen);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_astronomie);
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
                    generatedNewGame();
                    launchTimer(AstronomieActivity.this,60000,R.id.activity_astronomie_ghost_img);
                    launchImageJoueur(R.id.activity_astronomie_star_img);
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    chronometer.start();
                } else {
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

    private void activateListerner(int levelChosen) {
        switch (levelChosen){
            case 1:
                planet1.setOnClickListener(this);
                planet2.setOnClickListener(this);
                planet3.setOnClickListener(this);
                planet4.setOnClickListener(this);
                planetName.setOnClickListener(this);
                break;
            case 2:
                planet.setOnClickListener(this);
                planetName1.setOnClickListener(this);
                planetName2.setOnClickListener(this);
                planetName3.setOnClickListener(this);
                planetName4.setOnClickListener(this);
                break;
            case 3:
                for (LinearLayout l: conteneurPlanet_lvl3) {
                    l.setOnDragListener(new MyDragListener());
                }
                for (TextView t: txtPlanet_lvl3){
                    t.setOnTouchListener(new MyTouchListener());
                }
                break;
        }
    }

    private final class MyTouchListener implements View.OnTouchListener {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(
                        view);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.INVISIBLE);
                return true;
            } else {
                return false;
            }
        }
    }

    class MyDragListener implements View.OnDragListener {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int action = event.getAction();
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    // do nothing
                    return true;
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    // Dropped, reassign View to ViewGroup
                    TextView view = (TextView) event.getLocalState();
                    LinearLayout container = (LinearLayout) v;
                    if(v.getContentDescription().equals(view.getText())){
                        ViewGroup owner = (ViewGroup) view.getParent();
                        owner.removeView(view);
                        container.addView(view);
                        rightInput++;
                        checkAnswer_LVL3(rightInput);
                        Log.d("Test drop", "rightAnswer:  " + rightAnswer);
                    }else{
                        Log.d("Test drop", "attendue: " + v.getContentDescription());
                        Log.d("Test drop", "selectionne:  " + view.getText());
                    }
                    view.setVisibility(View.VISIBLE);
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                default:
                    break;
            }
            return true;
        }
    }

    private void activateButtons(int levelChosen) {
        switch (levelChosen){
            case 1:
                planet1.setEnabled(true);
                planet2.setEnabled(true);
                planet3.setEnabled(true);
                planet4.setEnabled(true);
                planetName.setEnabled(true);
                break;
            case 2:
                planet.setEnabled(true);
                planetName1.setEnabled(true);
                planetName2.setEnabled(true);
                planetName3.setEnabled(true);
                planetName4.setEnabled(true);
                break;
        }
    }

    private void disableButtons(int levelChosen) {
        switch (levelChosen){
            case 1:
                planet1.setEnabled(false);
                planet2.setEnabled(false);
                planet3.setEnabled(false);
                planet4.setEnabled(false);
                planetName.setEnabled(false);
                break;
            case 2:
                planet.setEnabled(false);
                planetName1.setEnabled(false);
                planetName2.setEnabled(false);
                planetName3.setEnabled(false);
                planetName4.setEnabled(false);
                break;
        }
    }

    public void generatedNewGame(){
        switch (levelChosen){
            case 1:
                activateListerner(levelChosen);
                ControlerLVL1 controlerAstronomie1 = new ControlerLVL1(this,constraintLayout);
                this.rightAnswer = getResources().getResourceEntryName(controlerAstronomie1.getRightAnswer());
                break;
            case 2:
                activateListerner(levelChosen);
                ControlerLVL2 controlerAstronomie2 = new ControlerLVL2(this,constraintLayout);
                this.rightAnswer = getResources().getResourceEntryName(controlerAstronomie2.getRightAnswer());
                break;
            case 3:
                ConstraintLayout conteneurRect = (ConstraintLayout) getLayoutInflater().inflate(R.layout.activity_astronomie_lvl3, constraintLayout, false);
                constraintLayout.addView(conteneurRect);
                planeteName1_lvl3 = findViewById(R.id.activity_astronomie_lvl3_planetName1_textView);
                planeteName2_lvl3 = findViewById(R.id.activity_astronomie_lvl3_planetName2_textView);
                planeteName3_lvl3 = findViewById(R.id.activity_astronomie_lvl3_planetName3_textView);
                planeteName4_lvl3 = findViewById(R.id.activity_astronomie_lvl3_planetName4_textView);
                planeteName5_lvl3 = findViewById(R.id.activity_astronomie_lvl3_planetName5_textView);
                planeteName6_lvl3 = findViewById(R.id.activity_astronomie_lvl3_planetName6_textView);
                planeteName7_lvl3 = findViewById(R.id.activity_astronomie_lvl3_planetName7_textView);
                planeteName8_lvl3 = findViewById(R.id.activity_astronomie_lvl3_planetName8_textView);
                txtPlanet_lvl3 = new TextView[]{planeteName1_lvl3, planeteName2_lvl3, planeteName3_lvl3, planeteName4_lvl3, planeteName5_lvl3, planeteName6_lvl3, planeteName7_lvl3, planeteName8_lvl3};

                planeteMercure_lvl3 = findViewById(R.id.activity_astronomie_lvl3_mercure_textViewConteneur);
                planeteVenus_lvl3 = findViewById(R.id.activity_astronomie_lvl3_venus_textViewConteneur);
                planeteTerre_lvl3 = findViewById(R.id.activity_astronomie_lvl3_terre_textViewConteneur);
                planeteMars_lvl3 = findViewById(R.id.activity_astronomie_lvl3_mars_textViewConteneur);
                planeteJupiter_lvl3 = findViewById(R.id.activity_astronomie_lvl3_jupiter_textViewConteneur);
                planeteSaturne_lvl3 = findViewById(R.id.activity_astronomie_lvl3_saturne_textViewConteneur);
                planeteUranus_lvl3 = findViewById(R.id.activity_astronomie_lvl3_uranus_textViewConteneur);
                planeteNeptune_lvl3 = findViewById(R.id.activity_astronomie_lvl3_neptune_textViewConteneur);
                conteneurPlanet_lvl3 = new LinearLayout[]{planeteMercure_lvl3, planeteVenus_lvl3, planeteTerre_lvl3, planeteMars_lvl3, planeteJupiter_lvl3, planeteSaturne_lvl3, planeteUranus_lvl3, planeteNeptune_lvl3};

                activateListerner(levelChosen);
                ControlerLVL3 controlerAstronomie3 = new ControlerLVL3(this,constraintLayout);
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        nbgoodAnswer = 10;
        checkAnswer("nn");
    }

    public void checkAnswer_LVL3(int rightInput){
        float screenWidth = getScreenWidth();
        if(rightInput <8){
            this.nbgoodAnswer++;

            moveImage(playerImage,playerImagePosition+(screenWidth/8),600,playerImagePosition);
            playerImagePosition = playerImagePosition + (screenWidth/8);

        }else if(rightInput==8){
            unableLoose();
            unableScoreMode();
            chronometer.stop();
            timeScore = (SystemClock.elapsedRealtime() - chronometer.getBase()) / 1000;
            initializeScoreValues("astronomie", levelChosen);
            showResultScreen(this);
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
            initializeScoreValues("astronomie", levelChosen);
            showResultScreen(this);
            return true;
        }else {
            generatedNewGame();
            return false;
        }
    }

    private void showMenu(){
        String[] menu = new String[3];
        menu[0] = "niveau 1";
        menu[1] = "niveau 2";
        menu[2] = "niveau 3";

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