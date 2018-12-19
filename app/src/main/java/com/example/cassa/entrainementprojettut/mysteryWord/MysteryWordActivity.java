package com.example.cassa.entrainementprojettut.mysteryWord;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.cassa.entrainementprojettut.R;
import com.example.cassa.entrainementprojettut.gameUtils.GameActivity;
import com.example.cassa.entrainementprojettut.mysteryWord.word.I_Word;



public class MysteryWordActivity extends GameActivity {
    private TextView gTxtOrder;
    private TextView gTxtAnswer;
    private ImageView gImgPlayer;
    private LinearLayout gBtnLayout;

    private ToggleButton gKeyboard[];
    float gPositionImageJoueur;

    private WordBankController wordBankController;
    private I_Word motEnCour;

    private char gSelectedCharaAnswer;
    private int gNbReponsesCorrectes = 0;
    private int gNbLettreOk;
    private ToggleButton gSelectedLetter;

    private long startingTime;

    private Chronometer chronometer;

    final Handler gHandler = new Handler();


    protected Runnable gDisplayWord = new Runnable() {
        @Override
        public void run() {
            viderLayout();
            gTxtAnswer.setText("");
            displayWord(motEnCour);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mystery_word);

        music = R.raw.bensound_cute;
        if(isSong()) {
            startBackgroundMusic(this, music);
        }
        initializeGame();
        showMenu();
        startingTime = System.currentTimeMillis();
        gKeyboard= new ToggleButton[26];


        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {

            @Override
            public void onDismiss(DialogInterface dialogInterface){
                if (levelChosen != 0) {
                    generateGame();

                    chronometer.setBase(SystemClock.elapsedRealtime());
                    chronometer.start();

                    initializeScoreValues("MysteryWord",levelChosen);


                }
                else {
                    MysteryWordActivity.this.onStop();
                    dialog.show();
                }
            }
        });

        gKeyboard[0] = findViewById(R.id.activity_mysteryWord_A_button);
        gKeyboard[1] = findViewById(R.id.activity_mysteryWord_Z_button);
        gKeyboard[2] = findViewById(R.id.activity_mysteryWord_E_button);
        gKeyboard[3] = findViewById(R.id.activity_mysteryWord_R_button);
        gKeyboard[4] = findViewById(R.id.activity_mysteryWord_T_button);
        gKeyboard[5] = findViewById(R.id.activity_mysteryWord_Y_button);
        gKeyboard[6] = findViewById(R.id.activity_mysteryWord_U_button);
        gKeyboard[7] = findViewById(R.id.activity_mysteryWord_I_button);
        gKeyboard[8] = findViewById(R.id.activity_mysteryWord_O_button);
        gKeyboard[9] = findViewById(R.id.activity_mysteryWord_P_button);
        gKeyboard[10] = findViewById(R.id.activity_mysteryWord_Q_button);
        gKeyboard[11] = findViewById(R.id.activity_mysteryWord_S_button);
        gKeyboard[12] = findViewById(R.id.activity_mysteryWord_D_button);
        gKeyboard[13] = findViewById(R.id.activity_mysteryWord_F_button);
        gKeyboard[14] = findViewById(R.id.activity_mysteryWord_G_button);
        gKeyboard[15] = findViewById(R.id.activity_mysteryWord_H_button);
        gKeyboard[16] = findViewById(R.id.activity_mysteryWord_J_button);
        gKeyboard[17] = findViewById(R.id.activity_mysteryWord_K_button);
        gKeyboard[18] = findViewById(R.id.activity_mysteryWord_L_button);
        gKeyboard[19] = findViewById(R.id.activity_mysteryWord_M_button);
        gKeyboard[20] = findViewById(R.id.activity_mysteryWord_W_button);
        gKeyboard[21] = findViewById(R.id.activity_mysteryWord_X_button);
        gKeyboard[22] = findViewById(R.id.activity_mysteryWord_C_button);
        gKeyboard[23] = findViewById(R.id.activity_mysteryWord_V_button);
        gKeyboard[24] = findViewById(R.id.activity_mysteryWord_B_button);
        gKeyboard[25] = findViewById(R.id.activity_mysteryWord_N_button);

        gTxtAnswer = findViewById(R.id.activity_mysteryWord_answer_textview);
        gTxtOrder = findViewById(R.id.activity_mysteryWord_order_textview);

        gImgPlayer = findViewById(R.id.activity_mysteryWord_pos1_img);

        gBtnLayout = findViewById(R.id.activity_mysteryWord_word_linearlayout);

        chronometer = findViewById(R.id.activity_mystery_word_chronometer);

        for (int i = 0; i < gKeyboard.length; i++) {
            final int tmp = i;
            gKeyboard[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    validRep(gKeyboard[tmp], gSelectedLetter);
                    System.out.println(gSelectedCharaAnswer);
                }
            });
        }
    }

    private void displayWord(I_Word pWord) {


        int i = 0;
        final int wordLength = pWord.getCodedWord().length();
        for (char c : pWord.getCodedWord().toCharArray()) {
            final int tmp = i;
            final ToggleButton button = (ToggleButton) this.getLayoutInflater().inflate(R.layout.mystery_word_button, gBtnLayout, false);
            button.setText(String.valueOf(c));
            button.setTextOff(String.valueOf(c));
            button.setTextOn(String.valueOf(c));
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View pView) {
                    reinitClavier();
                    gTxtAnswer.setText("");
                    gSelectedCharaAnswer = motEnCour.getWord().charAt(tmp);
                    gSelectedLetter = (ToggleButton)pView;
                    pView.setClickable(false);
                    for (int j = 0; j < wordLength; j++) {
                        ToggleButton letter = (ToggleButton) gBtnLayout.getChildAt(j);
                        if (letter.isChecked() && letter.isEnabled() && letter != pView) {
                            letter.setChecked(false);
                            letter.setClickable(true);
                        }
                    }
                }
            });
            gBtnLayout.addView(button);
            ToggleButton firstLetter = (ToggleButton) gBtnLayout.getChildAt(0);
            firstLetter.setChecked(true);
            gSelectedCharaAnswer = motEnCour.getWord().charAt(0);
            gSelectedLetter = firstLetter;
            i++;
        }
    }

    private void viderLayout() {
        gBtnLayout.removeAllViews();
    }

    private boolean checkAnswer(String pString) {
        boolean res = false;
        if (pString.equalsIgnoreCase(String.valueOf(gSelectedCharaAnswer))) {
            res = true;
            gTxtAnswer.setText(R.string.Well_played);
        } else {
            gTxtAnswer.setText(R.string.Try_again);
        }
        return res;
    }

    public boolean motFini(I_Word sMotActuel, int i) {
        return (sMotActuel.getWord().length() == i);
    }

    public void reinitClavier() {
        for (ToggleButton button : gKeyboard) {
            button.setEnabled(true);
            button.setChecked(false);
        }
    }

    protected void onDestroy(){
        super.onDestroy();
        try {
            bgPlayer.stop();
        }catch (Exception e){

        }
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    public void desactiverBouton(Button pBtn, String pString) {
        pBtn.setText(pString);
        pBtn.setEnabled(false);
        pBtn.setTextColor(Color.rgb(60, 60, 60));
    }

    public void validRep(Button pBtn, Button pBtnSelec) {
        String s = pBtn.getText().toString();
        if (checkAnswer(s)) {
            gNbLettreOk++;
            desactiverBouton(pBtnSelec, s);
            reinitClavier();
            validMot(motEnCour, gNbLettreOk, gTxtAnswer);
        } else {
            pBtn.setEnabled(false);
        }
    }

    public void validMot(I_Word pWord, int pInt, TextView pReponse) {
        if (motFini(pWord, pInt)) {
            pReponse.setText("Bravo !");
            gNbReponsesCorrectes++;

            float largeurEcran = getScreenWidth();

            
            moveImage(gImgPlayer, gPositionImageJoueur + (largeurEcran / 6), 600, gPositionImageJoueur);

            gPositionImageJoueur = gPositionImageJoueur + (largeurEcran / 6);
            partieFinie(5);
        } else {
            int indexCurrentLetter = gBtnLayout.indexOfChild(gSelectedLetter);
            int indexNextLetter;
            if (indexCurrentLetter == motEnCour.getCodedWord().length() - 1 ||
                    !gBtnLayout.getChildAt(indexCurrentLetter + 1).isEnabled()) {
                int j = 0;
                while (!gBtnLayout.getChildAt(j).isEnabled()) {
                    j++;
                }
                indexNextLetter = j;
            } else {
                indexNextLetter = indexCurrentLetter + 1;
            }
            ToggleButton nextLetter = (ToggleButton) gBtnLayout.getChildAt(indexNextLetter);
            nextLetter.setChecked(true);
            gSelectedCharaAnswer = motEnCour.getWord().charAt(indexNextLetter);
            gSelectedLetter = nextLetter;
            nextLetter.setClickable(false);
        }
    }

    public void partieFinie(int pNbMot) {
        if (gNbReponsesCorrectes == pNbMot) {
            unableLoose();
            unableScoreMode();
            chronometer.stop();
            timeScore =  (SystemClock.elapsedRealtime() - chronometer.getBase())/1000;
            showResultScreen(this);


        }
        else {
            motEnCour = motSuivant();
        }
    }

    public void generateGame() {
        //On récupère le mWord et on l'affiche, ainsi que la mOrder associée
        wordBankController =new WordBankController(levelChosen);
        motEnCour = wordBankController.getWord(0);
        gNbLettreOk = 0;
        displayWord(motEnCour);
        gTxtOrder.setText(motEnCour.getOrder());

        int duree;
        switch(levelChosen)
        {
            case 1: case 2: case 3:
                duree = 120000;
                break;
            case 4: case 5:
                duree = 180000;
                break;
            default:
                duree = 120000;
                break;
        }

        launchTimer(MysteryWordActivity.this,
                duree, R.id.activity_mysteryWord_pos1_img, R.id.activity_mysteryWord_ordi_img);

    }

    /**
     * @return I_Word motSuivant
     */

    public I_Word motSuivant() {
        I_Word motSuivant = wordBankController.getWord(gNbReponsesCorrectes);
        gNbLettreOk = 0;
        gHandler.postDelayed(gDisplayWord, 1000);
        gTxtOrder.setText(motSuivant.getOrder());
        return motSuivant;
    }
    private void showMenu(){
        String[] menu = new String[5];
        menu[0]= getString(R.string.Level_1);
        menu[1]= getString(R.string.Level_2);
        menu[2]= getString(R.string.Level_3);
        menu[3]= getString(R.string.Level_4);
        menu[4]= getString(R.string.Level_5);
        displayLevelchoice(this,menu);
    }
}