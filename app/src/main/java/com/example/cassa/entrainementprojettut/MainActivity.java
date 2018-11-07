package com.example.cassa.entrainementprojettut;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonActivity;
import com.example.cassa.entrainementprojettut.flag.FlagActivity;
import com.example.cassa.entrainementprojettut.flag.ReverseFlagActivity;
import com.example.cassa.entrainementprojettut.gameUtils.ActivityUtil;
import com.example.cassa.entrainementprojettut.geography.GeographyActivity;
import com.example.cassa.entrainementprojettut.mysteryWord.MysteryWordActivity;
import com.example.cassa.entrainementprojettut.operationGame.AdditionActivity;
import com.example.cassa.entrainementprojettut.pianoGame.PianoActivity;
import com.example.cassa.entrainementprojettut.score.ScoreActivity;
import java.util.regex.Pattern;

public class MainActivity extends ActivityUtil {

    protected static String playerName = "noName";
    MediaPlayer playerEvent;
    private AnimationDrawable mOwlAnimation;
    Toast toast;
    public static String getPlayerName() {
        return playerName;
    }

    private void setPlayerName(String name) {
        playerName = name;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mAddition = findViewById(R.id.activity_main_addition_btn);
        Button btnMysteryWord = findViewById(R.id.activity_main_mysteryWord_btn);
        Button btnFlagActivity = findViewById(R.id.activity_main_flagActivity_btn);
        Button btnReverseFlagActivity = findViewById(R.id.activity_reverse_flagActivity_btn);
        Button btnGeographyTag = findViewById(R.id.activity_main_geographyTag);
        Button btnPiano = findViewById(R.id.activity_main_piano);
        Button btnConjugaison = findViewById(R.id.activity_main_conjugaison);
        Button scoreTest=findViewById(R.id.button8);
        ImageView owlImg = findViewById(R.id.chouettes_menu);
        owlImg.setBackgroundResource(R.drawable.animation_chouettes_menu);
        mOwlAnimation = (AnimationDrawable) owlImg.getBackground();
        playerEvent = MediaPlayer.create(MainActivity.this, R.raw.envent_sound);
        music = R.raw.bensound_jazzyfrenchy;
        startBackgroundMusic(this, music);

        //On terminaisons.json la reference ici
        if (playerName == "noName") {
            alertDialog();
        }

        mAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent additionIntent = new Intent(MainActivity.this, AdditionActivity.class);
                startActivity(additionIntent);

                playerEvent.start();
                finish();
            }
        });


        btnMysteryWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent mysteryWordIntent = new Intent(MainActivity.this, MysteryWordActivity.class);
                startActivity(mysteryWordIntent);

                playerEvent.start();
                finish();
            }
        });

        btnFlagActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent flagActivityIntent = new Intent(MainActivity.this, FlagActivity.class);
                startActivity(flagActivityIntent);

                playerEvent.start();
                finish();
            }
        });


        btnReverseFlagActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent reverseFlagActivityIntent = new Intent(MainActivity.this, ReverseFlagActivity.class);
                startActivity(reverseFlagActivityIntent);
                finish();

            }
        });

        btnGeographyTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent geographyActivityIntent = new Intent(MainActivity.this, GeographyActivity.class);
                startActivity(geographyActivityIntent);

                playerEvent.start();
                finish();
            }
        });

        btnPiano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent pianoActivityIntent = new Intent(MainActivity.this, PianoActivity.class);
                startActivity(pianoActivityIntent);

                playerEvent.start();
                finish();
            }
        });
        btnConjugaison.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent conjugaisonActivityIntent = new Intent(MainActivity.this, ConjugaisonActivity.class);
                startActivity(conjugaisonActivityIntent);

                playerEvent.start();
                finish();
            }
        });



        scoreTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent scoreActivityIntent = new Intent(MainActivity.this, ScoreActivity.class);
                startActivity(scoreActivityIntent);

                playerEvent.start();
                finish();
            }
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            mOwlAnimation.start();
        }
    }

    @SuppressLint("SetTextI18n")
    public void alertDialog() {
        final AlertDialog.Builder updateDialog = new AlertDialog.Builder(this);
        final EditText input = new EditText(this);
        input.setHint("Entre ton nom");
        updateDialog.setView(input);

        updateDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Voir https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html
                /*  Trad du pattern :
                Autorise "Michelle Martin", "Michelle-Martin", "Jean-Edouart"
                N'autorise pas "Jean-Edouart Phillipe", "Jean-édouart", "Michelle Martin Matin", "Michelle Martin-Matin"
                Uniquement l'alphabet latin minuscule et majuscule (ni caracteres speciaux ni chiffres)
                Au minimum 2 caractere, jusqu'a 15 caracteres par nom et 31 caracteres max
                */
                if(Pattern.matches("[a-zA-z]{1,15}([ ]{0,1}|[-]{0,1})[a-zA-z]{1,15}", input.getText().toString())){
                    String m_Text = input.getText().toString();
                    setPlayerName(m_Text);
                }else{
                    showText("Erreur : veuillez entrer un nom valide ! ");
                    alertDialog();
                }
            }
        });
        updateDialog.setOnDismissListener(new DialogInterface.OnDismissListener(){

            @Override
            public void onDismiss(DialogInterface dialog) {
                if(Pattern.matches("[a-zA-z]{1,15}([ ]{0,1}|[-]{0,1})[a-zA-z]{1,15}", input.getText().toString())){
                    String m_Text = input.getText().toString();
                    setPlayerName(m_Text);
                }else{
                    showText("Erreur : veuillez entrer un nom valide ! ");
                    alertDialog();
                }
            }
        });
        updateDialog.show();
    }

    public void showText(String text) {

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        toast = Toast.makeText(context, text, duration);
        toast.show();

        Handler toastStop = new Handler();
        toastStop.postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        }, 500);
    }

}