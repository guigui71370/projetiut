
package com.example.cassa.entrainementprojettut;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.cassa.entrainementprojettut.anglais.EnglishActivity;
import com.example.cassa.entrainementprojettut.astronomie.AstronomieActivity;
import com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonActivity;
import com.example.cassa.entrainementprojettut.connect4.Connect4Activity;
import com.example.cassa.entrainementprojettut.flag.FlagActivity;
import com.example.cassa.entrainementprojettut.flag.ReverseFlagActivity;
import com.example.cassa.entrainementprojettut.gameUtils.ActivityUtil;
import com.example.cassa.entrainementprojettut.geography.GeographyActivity;
import com.example.cassa.entrainementprojettut.geometry.GeometryActivity;
import com.example.cassa.entrainementprojettut.mysteryWord.MysteryWordActivity;
import com.example.cassa.entrainementprojettut.mythology.MythologyActivity;
import com.example.cassa.entrainementprojettut.operationGame.AdditionActivity;
import com.example.cassa.entrainementprojettut.pianoGame.PianoActivity;
import com.example.cassa.entrainementprojettut.score.ScoreActivity;
import java.util.regex.Pattern;

public class MainActivity extends ActivityUtil {

    public static boolean mute = false;
    private static final String STRING_MUTE="STRING_MUTE";
    protected static String playerName = "";
    MediaPlayer playerEvent;
    private AnimationDrawable mOwlAnimation;
    Toast toast;
    public static String getPlayerName() {
        return playerName;
    }

    public static void  setPlayerName(String name) {
        playerName = name;
    }

    @Override @TargetApi(16)
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mAddition = findViewById(R.id.activity_main_addition_btn);
        Button btnMysteryWord = findViewById(R.id.activity_main_mysteryWord_btn);
        Button btnFlagActivity = findViewById(R.id.activity_main_flagActivity_btn);
        Button btnReverseFlagActivity = findViewById(R.id.activity_reverse_flagActivity_btn);
        Button btnGeographyTag = findViewById(R.id.activity_main_geographyTag);
        Button btnPiano = findViewById(R.id.activity_main_piano);
        Button btnConjugaison = findViewById(R.id.activity_main_conjugaison);
        Button btnGeometry = findViewById(R.id.activity_main_geometry);
        Button btnConnect4 = findViewById(R.id.activity_main_connect4);
        Button btnastronomie = findViewById(R.id.activity_main_astronomie);
        Button btnmythology = findViewById(R.id.activity_main_mythology);
        Button scoreTest = findViewById(R.id.activity_main_score_btn);
        Button btnAnglais=findViewById(R.id.activity_main_anglais);
        final ImageButton ImgBtnsong = findViewById(R.id.activity_main_song_imgbtn);
        ImageView owlImg = findViewById(R.id.chouettes_menu);
        owlImg.setBackgroundResource(R.drawable.animation_chouettes_menu);
        mOwlAnimation = (AnimationDrawable) owlImg.getBackground();
        playerEvent = MediaPlayer.create(MainActivity.this, R.raw.envent_sound);
        music = R.raw.bensound_jazzyfrenchy;
        //startBackgroundMusic(this, music);

        /*if(savedInstanceState!=null){
            mute=savedInstanceState.getBoolean(STRING_MUTE);
        }*/
        //

        if(!mute){
            mute = false;
            setSong(true);
            startBackgroundMusic(getApplicationContext(),music);
            ImgBtnsong.setBackground(getResources().getDrawable(R.drawable.volume_unmute));
            playerEvent.setVolume(1,1);
            bgPlayer.setVolume(1,1);
        }else{
            mute = true;
            setSong(false);
            ImgBtnsong.setBackground(getResources().getDrawable(R.drawable.volume_mute));
            /*bgPlayer.setVolume(0,0);
            playerEvent.setVolume(0,0);*/
        }

        //On terminaisons.json la reference ici
        if (playerName.isEmpty()) {
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

                playerEvent.start();
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

        btnConnect4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent scoreActivityIntent = new Intent(MainActivity.this, Connect4Activity.class);
                startActivity(scoreActivityIntent);
              
                playerEvent.start();
                finish();
            }
        });

        btnGeometry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent geometryActivityIntent = new Intent(MainActivity.this, GeometryActivity.class);
                startActivity(geometryActivityIntent);

                playerEvent.start();
                finish();
            }
        });
        btnastronomie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent astronomieActivityIntent = new Intent(MainActivity.this, AstronomieActivity.class);
                startActivity(astronomieActivityIntent);

                playerEvent.start();
                finish();
            }
        });
        btnmythology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent mythologyActivityIntent = new Intent(MainActivity.this, MythologyActivity.class);
                startActivity(mythologyActivityIntent);
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

        btnAnglais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent scoreActivityIntent = new Intent(MainActivity.this, EnglishActivity.class);
                startActivity(scoreActivityIntent);

                playerEvent.start();
                finish();
            }
        });




        ImgBtnsong.setOnClickListener(new View.OnClickListener() {
            @Override @TargetApi(16)
            public void onClick(View v) {
                if(mute){
                    mute = false;
                    setSong(true);
                    startBackgroundMusic(getApplicationContext(),music);
                    ImgBtnsong.setBackground(getResources().getDrawable(R.drawable.volume_unmute));
                    playerEvent.setVolume(1,1);
                    bgPlayer.setVolume(1,1);
                }else{
                    mute = true;
                    setSong(false);
                    ImgBtnsong.setBackground(getResources().getDrawable(R.drawable.volume_mute));
                    bgPlayer.setVolume(0,0);
                    playerEvent.setVolume(0,0);
                }
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
        updateDialog.setCancelable(false);

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
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState=new Bundle();
        outState.putBoolean(STRING_MUTE,mute);
        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState != null){
            this.mute = savedInstanceState.getBoolean(STRING_MUTE, false);

        }
    }
}