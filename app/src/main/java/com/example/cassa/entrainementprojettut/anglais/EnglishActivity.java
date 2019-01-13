package com.example.cassa.entrainementprojettut.anglais;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.*;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.cassa.entrainementprojettut.R;
import com.example.cassa.entrainementprojettut.anglais.controller.ControllerEnglish;
import com.example.cassa.entrainementprojettut.gameUtils.GameActivity;

import java.util.ArrayList;
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
    private int xDelta;
    private int yDelta;


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
                generateTestGame();
                break;
            default:

                break;
        }
    }

    private void generateTestGame() {







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

     ArrayList<View> test=new ArrayList<>();
    private void generateLayoutLevel4() {


        RelativeLayout conteneurRect = (RelativeLayout) getLayoutInflater().inflate(R.layout.layout_level1anglais, mainLayout, false);
        //conteneurRect.findViewById()
         GridLayout gridlayout= (GridLayout) conteneurRect.getChildAt(0);

        mainLayout.addView(conteneurRect);

        int scale = (int) getResources().getDisplayMetrics().density;
        int margin = 10 * scale;

        int row = 0;
        GridLayout.Spec colSpec = gridlayout.spec(2);

        for (row = 0; row < gridlayout.getRowCount(); row++) {
            GridLayout.Spec rowSpec = gridlayout.spec(row);


            ImageView image = new ImageView(this);
            image.setImageResource(R.drawable.rectangle);
            GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(rowSpec, colSpec);
            layoutParams.width = 300;
            layoutParams.height = 100;

            layoutParams.setMargins(margin, margin, margin, margin);
            image.setLayoutParams(layoutParams);
            image.setTag("test"+row);

            gridlayout.addView(image, layoutParams);

            test.add(image);





        }
        //RelativeLayout layout= (RelativeLayout) conteneurRect.getChildAt(0);

        for(int i=1;i<conteneurRect.getChildCount();i++){
            conteneurRect.getChildAt(i).setOnTouchListener(onTouchListener());

        }
        ///canvas.drawRect(rect, paint);
    }





    private View.OnTouchListener onTouchListener(){
        return new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {






                int t2[] = new int[2];
                view.getLocationInWindow(t2);

                //Log.d("pos1","pos 1"+t2[0]);
                //Log.d("pos1","pos 1"+t2[1]);

                final int x=(int) motionEvent.getRawX();
                final int y=(int) motionEvent.getRawY();

                switch(motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        RelativeLayout.LayoutParams lParams=(RelativeLayout.LayoutParams)view.getLayoutParams();
                        xDelta=x-lParams.leftMargin;
                        yDelta=y-lParams.topMargin;
                        Log.d("move12","is touch");
                        break;

                    case MotionEvent.ACTION_MOVE:
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();

                        layoutParams.leftMargin=x-xDelta;
                        layoutParams.topMargin=y-yDelta;

                        Log.d("move12","is move");
                        view.setLayoutParams(layoutParams);
                        break;

                    case MotionEvent.ACTION_UP:
                    /*Toast toast;
                    toast=Toast.makeText(getApplicationContext(),"x="+((x-xDelta)*12)/retourTailleEcran()+"/12 y="+((y-yDelta)*12)/getHauteurEcran()+"/12",Toast.LENGTH_SHORT);
                    toast.show();*/
                        int t[] = new int[2];
                        test.get(0).getLocationOnScreen(t);

                        Log.d("pos1","pos 1"+t[0]);
                        Log.d("pos1","pos 1"+t[1]);

                        test.get(2).getLocationOnScreen(t);

                        Log.d("pos1","pos 1"+t[0]);
                        Log.d("pos1","pos 1"+t[1]);



                        int tagCoords[] = new int[2];
                        view.getLocationOnScreen(tagCoords);
                        float leftSide = tagCoords[0];
                        float rightSide = leftSide + view.getWidth();
                        float upperSide = tagCoords[1];
                        float downSide = upperSide + view.getHeight();


                        /*if (checkVictoryBox((float[])view.getTag(),leftSide, rightSide, upperSide, downSide)){
                            view.setEnabled(false);

                            view.setBackgroundColor(Color.GREEN);
                            playerEvent.start();
                        }
                        else{
                            int position = getPositionTag((float[])view.getTag());
                            replaceTag(view,position);
                        }*/
                }
                mainLayout.invalidate();
                return true;
            }
        };
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
