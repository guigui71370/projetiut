package com.example.cassa.entrainementprojettut.conjugaison;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cassa.entrainementprojettut.R;
import com.example.cassa.entrainementprojettut.database.DAOconjugaison;
import com.example.cassa.entrainementprojettut.gameUtils.GameActivity;

import java.util.ArrayList;

public class ConjugaisonActivity extends GameActivity implements View.OnClickListener{
    private TextView time;
    private TextView sujet;
    private TextView verbe;
    private TextView infinitif;
    private TextView hint;

    private Button verb1;
    private Button verb2;
    private Button verb3;
    private Button verb4;

    private Chronometer chronometer;

    private ConjugaisonController ctrl;

    private LinearLayout layoutStars;

    private int goodAnswer = 0;
    private int badAnswer = 0;
    public static DAOconjugaison dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conjugaison);
        showMenu();
        initializeGame();
        dao=DAOconjugaison.getInstance(this);
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                if (levelChosen != 0) {
                    activateButtons();
                    generateOperation();
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    chronometer.start();
                } else {
                    ConjugaisonActivity.this.onStop();
                    dialog.show();
                }
            }
        });

        time = findViewById(R.id.activity_conjugaison_temps_textview);
        sujet =  findViewById(R.id.activity_conjugaison_sujet_textview);
        verbe =  findViewById(R.id.activity_conjugaison_verbe_textview);
        infinitif = findViewById(R.id.activity_conjugaison_infinitif_textview);
        hint =findViewById(R.id.activity_conjugaison_hint_textview);

        verb1 = findViewById(R.id.activity_conjugaison_verb1_button);
        verb2 = findViewById(R.id.activity_conjugaison_verb2_button);
        verb3 = findViewById(R.id.activity_conjugaison_verb3_button);
        verb4 = findViewById(R.id.activity_conjugaison_verb4_button);

        chronometer = findViewById(R.id.activity_conjugaison_chronometer2_chronometer);

        layoutStars = findViewById(R.id.activity_conjugaison_starsLayout_linearlayout);
    }


    private void activateButtons() {
        verb1.setEnabled(true);
        verb2.setEnabled(true);
        verb3.setEnabled(true);
        verb4.setEnabled(true);

        verb1.setBackgroundColor(Color.rgb(255,0,0));
        verb2.setBackgroundColor(Color.rgb(0,255,0));
        verb3.setBackgroundColor(Color.rgb(0,0,255));
        verb4.setBackgroundColor(Color.rgb(255,255,0));

        verb1.setOnClickListener(this);
        verb2.setOnClickListener(this);
        verb3.setOnClickListener(this);
        verb4.setOnClickListener(this);
    }



    @SuppressLint("SetTextI18n")
    protected void generateOperation(){

        ctrl = new ConjugaisonController(levelChosen);

        infinitif.setText(ctrl.getInfinitifConjugaison() + " :");
        sujet.setText(ctrl.getSujetConjugaison());
        time.setText(ctrl.getTempsConjugaison());
        if(goodAnswer==0){
            addStars(0, ctrl.getNbEtoiles());
        }
        setVerbeMalConjugue();
    }

    @Override
    public void onClick(View view) {
        //Pour les tests
        if(view.getContentDescription() == ctrl.getVerbeConjugaison()){
            showText("Bonne réponse");
            goodAnswer++;
            if(goodAnswer <= ctrl.getNbEtoiles()){
                addStars(goodAnswer,ctrl.getNbEtoiles()-goodAnswer);
                if(goodAnswer < ctrl.getNbEtoiles()){
                    generateOperation();
                }
            }else{
                //enregistrer les score + mètre fin a l'activiter
            }

        }else{
            badAnswer++;
            generateOperation();
            showText("Mauvaise réponse");
        }
    }

    public void setVerbeMalConjugue(){
        //¨Pour les tests
        ArrayList<String> list=dao.listfindvbc(ctrl.getidverbe(),ctrl.getidverbeconj());

        String tab[]=new String[4];
        int goodPosition=(int)(Math.random() * 4);

        tab[goodPosition]=ctrl.getVerbeConjugaison();



        for(int i=0;i<tab.length;i++){
            int answerPosition=(int)(Math.random() * list.size());
            if(tab[i]==null){
                tab[i]=list.get(answerPosition);
            }

        }
        verb1.setText(tab[0]);
        verb1.setContentDescription(tab[0]);
        verb2.setText(tab[1]);
        verb2.setContentDescription(tab[1]);
        verb3.setText(tab[2]);
        verb3.setContentDescription(tab[2]);
        verb4.setText(tab[3]);
        verb4.setContentDescription(tab[3]);
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

    /**
     *ON MET DES FANTOMES ICI EN ATTENDANT D'AVOIR DES ETOILES DEJA VIDES
     */
    private void addStars(int etoilePleine, int etoileVide){
        layoutStars.removeAllViews();
        int emptyStars[] = new int[etoileVide];
        int fullStars[] = new int[etoilePleine];
        for (Integer items : fullStars) {
            ImageView imgStars = new ImageView(this);
            imgStars.setBackgroundResource(R.mipmap.star);
            layoutStars.addView(imgStars);
        }

        for (Integer items : emptyStars) {
            ImageView imgStars = new ImageView(this);
            imgStars.setBackgroundResource(R.mipmap.ghost);
            layoutStars.addView(imgStars);
        }
    }
}