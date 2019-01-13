package com.example.cassa.entrainementprojettut.anglais;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.*;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.cassa.entrainementprojettut.R;
import com.example.cassa.entrainementprojettut.gameUtils.GameActivity;

import java.util.List;


public class EnglishActivity extends GameActivity {
    @BindView(R.id.chronometer2)
    Chronometer time;
    @BindView(R.id.layout_niveau)
    ConstraintLayout mainLayout;

    private MediaPlayer playerEvent;
    private Button tabButton[];
    private TextView question;
    private ControllerEnglish ctrl;


    private int rightAnswerCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english);
        ButterKnife.bind(this);
        initializeGame();

        showMenu();

        /*initializeSizeOfATag();
        initializeGameAfterMenuDismiss();*/
        initializeGameAfterMenuDismiss();
        if (isSong()) {
            startBackgroundMusic(EnglishActivity.this, R.raw.geography_music);
        }
        playerEvent = MediaPlayer.create(EnglishActivity.this, R.raw.envent_sound);
    }

    private void initializeGameAfterMenuDismiss() {
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                if (levelChosen != 0) {
                    initializeScoreValues("Anglais", levelChosen);
                    time.setBase(SystemClock.elapsedRealtime());
                    time.start();
                    rightAnswerCounter = 0;
                    //generateLayoutLevel4();
                    genrateGameLayouts(levelChosen);
                    generateGame(levelChosen);

                } else {
                    showMenu();
                }
            }
        });
    }

    private void generateGame(int levelChosen) {
        switch (levelChosen) {
            case 1:
                generateBasicGame(levelChosen);
                break;
            case 2:
                generateBasicGame(levelChosen);
                break;
            case 3:
                generateBasicGame(levelChosen);
                break;
            case 4:

                break;
            default:

                break;
        }
    }

    private void generateBasicGame(int diff) {
        enableButton();
        ctrl = new ControllerEnglish(diff);
        question.setText(ctrl.getQuestion());
        List<String[]> result = ctrl.GetFalseAnswsers();
        int shufle = (int) (Math.random() * 4);

        result.add(shufle, ctrl.getTrueanswsers());
        for (int i = 0; i < tabButton.length; i++) {
            tabButton[i].setText(result.get(i)[0]);
            tabButton[i].setOnClickListener(actionbutton());
            tabButton[i].setTag(result.get(i)[1]);
        }

    }

    private View.OnClickListener actionbutton() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disableButton();

                isgoodAnswer((String) v.getTag());
            }
        };
    }

    private void enableButton() {
        for (Button button : tabButton) {
            button.setEnabled(true);
        }
    }

    private void disableButton() {
        for (Button button : tabButton) {
            button.setEnabled(false);
        }
    }


    private void isgoodAnswer(String tag) {
        if (tag.equals(question.getText())) {
            showText("bonne reponse");
            rightAnswerCounter++;
            if (rightAnswerCounter == 10) {
                unableLoose();
                unableScoreMode();
                time.stop();
                timeScore = (SystemClock.elapsedRealtime() - time.getBase()) / 1000;
                initializeScoreValues("Anglais", levelChosen);
                showResultScreen(this);

            } else {
                generateGame(levelChosen);
            }
        } else {
            showText("mauvaise réponce");
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    generateGame(levelChosen);
                }
            }, 1000);


        }
    }


    private void genrateGameLayouts(int levelChosen) {
        if (levelChosen <= 3) {
            generateLayoutDefault();
        } else if (levelChosen == 4) {
            generateLayoutLevel4();
        }


    }

    private void generateLayoutDefault() {
        ConstraintLayout conteneurRect = (ConstraintLayout) getLayoutInflater().inflate(R.layout.layouts_level_aglais2et3, mainLayout, false);

        mainLayout.addView(conteneurRect);
        tabButton = new Button[4];

        tabButton[0] = findViewById(R.id.a_reponce1);
        tabButton[1] = findViewById(R.id.a_reponce2);
        tabButton[2] = findViewById(R.id.a_reponce3);
        tabButton[3] = findViewById(R.id.a_reponce4);

        question = findViewById(R.id.a_question);

    }


    private void generateLayoutLevel4() {


        GridLayout conteneurRect = (GridLayout) getLayoutInflater().inflate(R.layout.layout_level1anglais, mainLayout, false);

        mainLayout.addView(conteneurRect);

        int scale = (int) getResources().getDisplayMetrics().density;
        int margin = 10 * scale;

        int row = 0;
        GridLayout.Spec colSpec = conteneurRect.spec(2);

        for (row = 0; row < conteneurRect.getRowCount(); row++) {
            GridLayout.Spec rowSpec = conteneurRect.spec(row);


            ImageView image = new ImageView(this);
            image.setImageResource(R.drawable.rectangle);
            GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(rowSpec, colSpec);
            layoutParams.width = 300;
            layoutParams.height = 100;

            layoutParams.setMargins(margin, margin, margin, margin);
            image.setLayoutParams(layoutParams);


            conteneurRect.addView(image, layoutParams);
        }


        ///canvas.drawRect(rect, paint);
    }

    private void showMenu() {
        String[] menu = new String[4];
        menu[0] = "niveau 1";
        menu[1] = "niveau 2";
        menu[2] = "niveau 3";
        menu[3] = "niveau 4";
        displayLevelchoice(this, menu);
    }
}
