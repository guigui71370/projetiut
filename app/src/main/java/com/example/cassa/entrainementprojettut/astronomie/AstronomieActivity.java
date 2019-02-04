package com.example.cassa.entrainementprojettut.astronomie;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
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
import com.example.cassa.entrainementprojettut.astronomie.Controler.ControlerLVL4;
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

    ImageView planetImage1;
    ImageView planetImage2;
    ImageView planetImage3;
    ImageView planetImage4;
    ImageView planetImage5;
    ImageView planetImage6;
    ImageView planetImage7;
    ImageView planetImage8;
    ImageView[] imagesPlanet;

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
            case 1:
                for (LinearLayout l: conteneurPlanet_lvl3) {
                    l.setOnDragListener(new MyDragListener());
                }
                for (TextView t: txtPlanet_lvl3){
                    t.setOnTouchListener(new MyTouchListener());
                }
                break;
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

    private final class MyTouchListener implements View.OnTouchListener {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                ClipData data = ClipData.newPlainText("", "");
                DragShadowBuilder shadowBuilder = new DragShadowBuilder(
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
            if (event.getLocalState() instanceof TextView && v instanceof LinearLayout) {
                int action = event.getAction();
                switch (event.getAction()) {
                    case DragEvent.ACTION_DRAG_STARTED:
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
                            checkAnswer_LVL1(rightInput);
                            Log.d("Test drop", "rightAnswer:  " + rightAnswer);
                        }else{
                            Log.d("Test drop", "attendue: " + v.getContentDescription());
                            Log.d("Test drop", "selectionne:  " + view.getText());
                        }
                        //view.setVisibility(View.VISIBLE);
                        break;
                    case DragEvent.ACTION_DRAG_ENDED:
                        view = (TextView) event.getLocalState();
                        view.setVisibility(View.VISIBLE);
                    default:
                        break;
                }
            }
            return true;
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

                this.planetImage1 = findViewById(R.id.activity_astronomie_lvl3_mercure_imageView);
                this.planetImage2 = findViewById(R.id.activity_astronomie_lvl3_venus_imageView);
                this.planetImage3 = findViewById(R.id.activity_astronomie_lvl3_terre_imageView);
                this.planetImage4 = findViewById(R.id.activity_astronomie_lvl3_mars_imageView);
                this.planetImage5 = findViewById(R.id.activity_astronomie_lvl3_jupiter_imageView);
                this.planetImage6 = findViewById(R.id.activity_astronomie_lvl3_saturne_imageView);
                this.planetImage7 = findViewById(R.id.activity_astronomie_lvl3_uranus_imageView);
                this.planetImage8 = findViewById(R.id.activity_astronomie_lvl3_neptune_imageView);
                this.imagesPlanet = new ImageView[]{planetImage1, planetImage2, planetImage3, planetImage4, planetImage5, planetImage6, planetImage7, planetImage8};

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
                this.conteneurPlanet_lvl3 = controlerAstronomie4.getConteneurPlanet();
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
                    TextView foo = (TextView)this.conteneurPlanet_lvl3[i].getChildAt(0);
                    if(foo == null){
                        foo = new TextView(this);
                        foo.setText("");
                    }
                    if(foo.getText().equals(this.conteneurPlanet_lvl3[i].getContentDescription())){
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
