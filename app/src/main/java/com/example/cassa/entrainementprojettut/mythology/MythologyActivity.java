package com.example.cassa.entrainementprojettut.mythology;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import com.example.cassa.entrainementprojettut.R;
import com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonActivity;
import com.example.cassa.entrainementprojettut.gameUtils.GameActivity;

import java.util.ArrayList;
import java.util.Iterator;

public class MythologyActivity extends GameActivity implements View.OnClickListener {

    private MythologyControler ctrl;
    private Chronometer chronometer;

    private TextView hint;
    private Button divininty1;
    private Button divininty2;
    private Button divininty3;
    private Button divininty4;
    private Button divininty5;
    private Button divininty6;
    private Button[] buttonArray;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mythology);
        initializeGame();
        showMenu();



        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                if (levelChosen != 0) {
                    ctrl = new MythologyControler(levelChosen);
                    init();
                    displayGuess();
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    chronometer.start();
                } else {
                    MythologyActivity.this.onStop();
                    dialog.show();
                }
            }
        });



    }

    /**
     * initialise les vues et démarre la musique
     */
    private void init() {
        music = R.raw.bensound_cute;
        if(isSong()) {
            startBackgroundMusic(this, music);
        }
        chronometer = findViewById(R.id.activity_mythology_chronometer);
        hint = findViewById(R.id.activity_mythology_textview_divinity);
        divininty1 = findViewById(R.id.activity_mythology_button_divinity1);
        divininty2 = findViewById(R.id.activity_mythology_button_divinity2);
        divininty3 = findViewById(R.id.activity_mythology_button_divinity3);
        divininty4 = findViewById(R.id.activity_mythology_button_divinity4);
        divininty5 = findViewById(R.id.activity_mythology_button_divinity5);
        divininty6 = findViewById(R.id.activity_mythology_button_divinity6);
        buttonArray = new Button[]{divininty1, divininty2, divininty3, divininty4, divininty5, divininty6};
    }





    @Override
    public void onClick(View v) {

        if(isAnswer(v)){
            Button button = (Button) v;
            String answer = button.getText().toString();
            if(ctrl.isCorrect(answer)){
                if (ctrl.hasNextQuestion()){
                    displayGuess();
                }
                else{
                    chronometer.stop();
                    unableLoose();
                    unableScoreMode();
                    timeScore = (SystemClock.elapsedRealtime() - chronometer.getBase()) / 1000;
                    initializeScoreValues("Mythologie", levelChosen);
                    showResultScreen(this);
                }

            }
            else{
                unableLoose();
                showLooseScreen(this);
            }
        }


    }


    /**
     * Affiche une question et ses réponses
     */
    private void displayGuess() {

        String text = ctrl.getHint();
        ArrayList<String> divinities = ctrl.getAnswers();
        Iterator<String> itr = divinities.iterator();

        // on affiche l'indice
        hint.setText(text);

        // on affiche les réponses possibles, au maximum six
        int i = 0;
        String s;
        while (i<6 && itr.hasNext()){
            s = itr.next();
            buttonArray[i].setText(s);
        }

    }

    /**
     * @param v a View
     * @return true si la vue est un boutton de réponse
     */
    private boolean isAnswer(View v){
        int i = 0;
        boolean result = false;
        while(i < 6 ){
            if (v.getId() == buttonArray[i].getId()){
                result = true;
            }
            i++;
        }
        return result;
    }


    private void showMenu(){
        String[] menu = new String[3];
        menu[0]= getString(R.string.Level_1);
        menu[1]= getString(R.string.Level_2);
        menu[2]= getString(R.string.Level_3);
        displayLevelchoice(this,menu);
    }
}
