package com.example.cassa.entrainementprojettut.histoire;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.cassa.entrainementprojettut.R;
import com.example.cassa.entrainementprojettut.gameUtils.GameActivity;
import com.example.cassa.entrainementprojettut.histoire.controler.controleur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class historyActivity extends GameActivity {
    private int xDelta;
    private int yDelta;
    private ArrayList<ImageView> image = new ArrayList<>();
    private ArrayList<TextView> text = new ArrayList<>();
    Chronometer time;
    String[] periode = {"Préhistoire", "Antiquité", "Moyen\nÂge", "Temps\nmodernes", "Époque\ncontenporaine"};
    private int rightAnswerCounter = 0;
    ConstraintLayout mainlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        initializeGame();
        showMenu();
        mainlayout = findViewById(R.id.mainlayout);
        time = findViewById(R.id.chronometer2);
        //initializeGameAfterMenuDismiss();
        if (isSong()) {
            startBackgroundMusic(historyActivity.this, R.raw.geography_music);
        }
        initializeGameAfterMenuDismiss();
        ///playerEvent = MediaPlayer.create(historyActivity.this, R.raw.envent_sound);
    }


    private void initializeGameAfterMenuDismiss() {
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                if (levelChosen != 0) {
                    initializeScoreValues("Histoire", levelChosen);
                    time.setBase(SystemClock.elapsedRealtime());
                    time.start();
                    rightAnswerCounter = 0;
                    //generateLayoutLevel4();
                    if (levelChosen == 1)
                        generateGamelvlun();
                    if (levelChosen == 2)
                        generateGameLvlDeux();

                } else {
                    showMenu();
                }
            }
        });
    }

    private void generateGamelvlun() {
        ConstraintLayout layoutLvlUn = (ConstraintLayout) getLayoutInflater().inflate(R.layout.layout_niveau1_history, mainlayout, false);
        mainlayout.addView(layoutLvlUn);

        text.add((TextView) layoutLvlUn.findViewById(R.id.textView3));
        text.add((TextView) layoutLvlUn.findViewById(R.id.textView4));
        text.add((TextView) layoutLvlUn.findViewById(R.id.textView5));
        text.add((TextView) layoutLvlUn.findViewById(R.id.textView6));
        text.add((TextView) layoutLvlUn.findViewById(R.id.textView7));
        text.add((TextView) layoutLvlUn.findViewById(R.id.textViewEnonce));

        image.add((ImageView) layoutLvlUn.findViewById(R.id.imageView1));
        image.add((ImageView) layoutLvlUn.findViewById(R.id.imageView2));
        image.add((ImageView) layoutLvlUn.findViewById(R.id.imageView3));
        image.add((ImageView) layoutLvlUn.findViewById(R.id.imageView4));
        image.add((ImageView) layoutLvlUn.findViewById(R.id.imageView5));


        for (int i = 0; i < image.size(); i++) {
            image.get(i).setTag(periode[i]);
        }
        Arrays.sort(periode);

        for (int i = 0; i < image.size(); i++) {
            text.get(i).setOnTouchListener(onTouchListener());
            text.get(i).setEnabled(true);
            text.get(i).setText(periode[i]);
            text.get(i).setTag(periode[i]);
        }
    }


    private ArrayList<Button> listreponce;

    private void generateGameLvlDeux() {
        ConstraintLayout layoutlvl2 = (ConstraintLayout) getLayoutInflater().inflate(R.layout.layout_lvl2_history, mainlayout, false);
        mainlayout.addView(layoutlvl2);
        listreponce = new ArrayList<>();

        listreponce.add((Button) layoutlvl2.findViewById(R.id.h_reponce1));
        listreponce.add((Button) layoutlvl2.findViewById(R.id.h_reponce2));
        listreponce.add((Button) layoutlvl2.findViewById(R.id.h_reponce3));
        listreponce.add((Button) layoutlvl2.findViewById(R.id.h_reponce4));
        text.add((TextView) layoutlvl2.findViewById(R.id.history_question));
        text.add((TextView) layoutlvl2.findViewById(R.id.conteur_history));
        text.add((TextView) layoutlvl2.findViewById(R.id.theme_question));
        text.get(1).setText(rightAnswerCounter+"/5");
        for (int i = 0; i < listreponce.size(); i++) {
            listreponce.get(i).setOnClickListener(onClickListener());

        }

        generatequetion();


    }

    private void generatequetion() {
        controleur ctrl = new controleur();
        List<String[]> list = ctrl.reponce(2);

        text.get(2).setText(list.get(0)[2]);
        text.get(0).setText(list.get(0)[0]);
        text.get(0).setTag(list.get(0)[1]);

        String tabrep[] = new String[4];
        for (int i = 0; i < list.size(); i++) {
            tabrep[i] = list.get(i)[1];
        }
        Arrays.sort(tabrep);
        for (int i = 0; i < list.size(); i++) {
            listreponce.get(i).setText(tabrep[i]);
            listreponce.get(i).setTag(tabrep[i]);

        }


    }


    private void showMenu() {
        String[] menu = new String[2];
        menu[0] = "Niveau 1";
        menu[1] = "Niveau 2";

        displayLevelchoice(this, menu);
    }

    private View.OnClickListener onClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verif(v);
            }


        };
    }

    Runnable r=new Runnable() {
        @Override
        public void run() {
            generatequetion();
            enablebutton();
        }
    };

    private void verif(View v) {
        if (text.get(0).getTag().equals(v.getTag())) {
            rightAnswerCounter++;
            showText("Bonne réponse");
            text.get(1).setText("Nombre de bonnes réponses :"+rightAnswerCounter+"/5");
            if (rightAnswerCounter == 5) {
                unableLoose();
                unableScoreMode();
                time.stop();
                timeScore = (SystemClock.elapsedRealtime() - time.getBase()) / 1000;
                showResultScreen(this);
            } else {
               new Handler().postDelayed(r,1000);
                disablebutton();
            }
        } else {
            showText("Mauvaise réponse");
            new Handler().postDelayed(r,1000);
            disablebutton();
        }
    }

    private void disablebutton() {
        for (int i=0;i<listreponce.size();i++){
            listreponce.get(i).setEnabled(false);
        }
    }
    private void enablebutton() {
        for (int i=0;i<listreponce.size();i++){
            listreponce.get(i).setEnabled(true);
        }
    }

    private View.OnTouchListener onTouchListener() {
        return new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int t2[] = new int[2];
                view.getLocationInWindow(t2);
                final int x = (int) motionEvent.getRawX();
                final int y = (int) motionEvent.getRawY();

                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        ConstraintLayout.LayoutParams lParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();
                        xDelta = x - lParams.leftMargin;
                        yDelta = y - lParams.topMargin;
                        Log.d("move12", "is touch");
                        break;

                    case MotionEvent.ACTION_MOVE:
                        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();

                        layoutParams.leftMargin = x - xDelta;
                        layoutParams.topMargin = y - yDelta;

                        Log.d("move12", "is move");
                        view.setLayoutParams(layoutParams);
                        break;

                    case MotionEvent.ACTION_UP:
                        int tagCoords[] = new int[2];
                        view.getLocationOnScreen(tagCoords);
                        float leftSide = tagCoords[0];
                        float rightSide = leftSide + view.getWidth();
                        float upperSide = tagCoords[1];
                        float downSide = upperSide + view.getHeight();
                        Log.d("pos1", "pos 1" + tagCoords[0]);

                        if (checkVictoryBox(leftSide, rightSide, upperSide, downSide, (String) view.getTag()))
                            view.setEnabled(false);

                        break;

                }

                return true;
            }
        };
    }

    private boolean checkVictoryBox(float leftSideTxtView, float rightSideTxtView,
                                    float upperSideTxtView, float downSideTxtView, String tag) {

        //victoryBox = vicotryBoxHitBoxTolerance(victoryBox); //victoryBox
        float[] victoryBox;
        victoryBox = this.getlocation(image.get(0));
        for (int i = 0; i < image.size(); i++) {
            victoryBox = this.getlocation(image.get(i));
            if (isarectangle(victoryBox, leftSideTxtView, rightSideTxtView, upperSideTxtView, downSideTxtView) && tag.equals(image.get(i).getTag())) {
                showText("Bravo!");
                rightAnswerCounter++;


                if (rightAnswerCounter == 5) {
                    unableLoose();
                    unableScoreMode();
                    time.stop();
                    timeScore = (SystemClock.elapsedRealtime() - time.getBase()) / 1000;
                    showResultScreen(this);
                }
                return true;
            }
        }
        showText("Essaie encore!");
        return false;
    }


    private float[] getlocation(@NonNull View v) {
        int t[] = new int[2];
        v.getLocationOnScreen(t);

        Log.d("pos1", "pos 1" + t[0]);
        /*Log.d("pos1","pos 1"+t[1]);*/
        float leftSide = t[0];
        float rightSide = leftSide + v.getWidth();
        float upperSide = t[1];
        float downSide = upperSide + v.getHeight();


        return new float[]{leftSide, upperSide, rightSide, downSide};
    }


    private boolean isarectangle(@NonNull float[] victoryBox, float leftSideTxtView, float rightSideTxtView, float upperSideTxtView, float downSideTxtView) {
        return leftSideTxtView >= victoryBox[0] + 5 && leftSideTxtView <= victoryBox[2] + 5 && upperSideTxtView >= victoryBox[1] + 5 && downSideTxtView <= victoryBox[3] + 5;
    }
}
