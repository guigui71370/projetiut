package com.example.cassa.entrainementprojettut.anglais;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.*;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.cassa.entrainementprojettut.R;
import com.example.cassa.entrainementprojettut.anglais.controller.ControllerEnglish;
import com.example.cassa.entrainementprojettut.anglais.mot.AddwordDatabase;
import com.example.cassa.entrainementprojettut.database.AppDatabase;
import com.example.cassa.entrainementprojettut.gameUtils.GameActivity;

import java.util.ArrayList;
import java.util.List;


public class EnglishActivity extends GameActivity {
    @BindView(R.id.chronometer2)
    Chronometer time;
    @BindView(R.id.layout_niveau)
    ConstraintLayout mainLayout;

    private MediaPlayer playerEvent;
    private View tabButton[];
    private TextView tabTextview[];
    private TextView question;
    private ControllerEnglish ctrl;
    private int xDelta;
    private int yDelta;
    private AppDatabase database;

    private int rightAnswerCounter;

    private MediaPlayer jouer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english);
        ButterKnife.bind(this);
        initializeGame();
        database = AppDatabase.getInstanceOfAppDatabase(getApplicationContext());
        showMenu();
        AddwordDatabase.database_ajout();
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
                if(bgPlayer!=null)
                    bgPlayer.stop();
                generateBasicGame(levelChosen);
                break;
            case 4:
                generateGameLevel4();
                break;
            default:

                break;
        }
    }

    private void generateGameLevel4() {

        ctrl = new ControllerEnglish(4,database);

        List<String[]> result = ctrl.GetFalseAnswsers();
        for (int i = 0; i < tabButton.length; i++) {

            tabTextview[i].setText(result.get(i)[1]);
            test.get(i).setTag(result.get(i)[1]);

        }
        int y=0;
        while(result.size()!=0){
;            int i= (int) (Math.random()*result.size());

            TextView btn= (TextView) tabButton[y];
            btn.setText(result.get(i)[0]);
            btn.setTag(result.get(i)[1]);
            result.remove(i);
            y++;
        }

       /* */




    }

    private void generateBasicGame(int diff) {

        ctrl = new ControllerEnglish(diff,database);

        if(diff==3) {
            if(jouer!=null){
                jouer.stop();
            }
            int Ressource=Integer.parseInt(ctrl.getTrueanswsers()[2]);

            question.setText("Rejouer le sons");
            if(Ressource!=0)
                jouer=MediaPlayer.create(EnglishActivity.this, Ressource);
            else
                jouer=MediaPlayer.create(EnglishActivity.this,  R.raw.envent_sound);
            jouer.setLooping(false);
            jouer.start();
            question.setOnClickListener(actionRejouer());
            question.setEnabled(true);

        }else{
            question.setText("Quelle est la traduction de : "+ctrl.getQuestion()+" ?");

        }


        question.setTag(ctrl.getQuestion());
        List<String[]> result = ctrl.GetFalseAnswsers();
        Log.d("size11",result.size()+"");
        int shufle = (int) (Math.random() * 4);

        result.add(shufle, ctrl.getTrueanswsers());
        for (int i = 0; i < tabButton.length; i++) {
            Button btn= (Button) tabButton[i];
            btn.setText(result.get(i)[0]);
            tabButton[i].setOnClickListener(actionbutton());
            tabButton[i].setTag(result.get(i)[1]);
        }
        enableButton();
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



    private View.OnClickListener actionRejouer() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jouer.start();
            }
        };
    }

    private void enableButton() {
        for (View button : tabButton) {
            button.setEnabled(true);
        }
    }

    private void disableButton() {
        for (View button : tabButton) {
            button.setEnabled(false);
        }
    }


    private void isgoodAnswer(String tag) {
        if (tag.equals(question.getTag())) {
            showText("Bonne réponse");
            rightAnswerCounter++;
            if (rightAnswerCounter == 10) {
                if(levelChosen==3){
                    jouer.stop();
                }
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
            showText("Mauvaise réponse");
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

            ///image.setTag("TextView"+row);



        }
        //RelativeLayout layout= (RelativeLayout) conteneurRect.getChildAt(0);
        float maxWidth = 0.1f * getScreenWidth() ;
        int horizontalSpaceBetweenCols =(int) maxWidth + 10;
        tabButton = new TextView[5];
        for(int i=0;i<5;i++){

            TextView tabTextView =new TextView(this);
            tabTextView.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL);
            tabTextView.setMinWidth(200);
            tabTextView.setTextSize(20);
            //conteneurRect.getChildAt(i).setOnTouchListener(onTouchListener());
            tabTextView.setText("test");
            tabTextView.setOnTouchListener(onTouchListener());

            //tabTextView.setTag("TextView"+i);


            RelativeLayout.LayoutParams textViewParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

            textViewParams.setMargins((2* horizontalSpaceBetweenCols), ((i-(2*(-1))) * 100), 0, 0);

            tabTextView.setLayoutParams(textViewParams);
            conteneurRect.addView(tabTextView,textViewParams);
            tabButton[i]=tabTextView;




            //conteneurRect.addView(tabTextView);
        }

        tabTextview=new TextView[5];
        tabTextview[0]=findViewById(R.id.mot1);
        tabTextview[1]=findViewById(R.id.mot2);
        tabTextview[2]=findViewById(R.id.mot3);
        tabTextview[3]=findViewById(R.id.mot4);
        tabTextview[4]=findViewById(R.id.mot5);

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




                        int tagCoords[] = new int[2];
                        view.getLocationOnScreen(tagCoords);
                        float leftSide = tagCoords[0];
                        float rightSide = leftSide + view.getWidth();
                        float upperSide = tagCoords[1];
                        float downSide = upperSide + view.getHeight();
                        Log.d("pos1","pos 1"+tagCoords[0]);
                       /* Log.d("pos1","pos 1"+tagCoords[1]);*/

                     if (checkVictoryBox(leftSide, rightSide, upperSide, downSide,(String)view.getTag())){
                            view.setEnabled(false);

                            view.setBackgroundColor(Color.GREEN);
                            playerEvent.start();
                        }
                        /*else{
                            int position = getPositionTag((float[])view.getTag());
                            replaceTag(view,position);
                        }*/
                }
                mainLayout.invalidate();
                return true;
            }
        };
    }

   private boolean checkVictoryBox( float leftSideTxtView, float rightSideTxtView,
                                    float upperSideTxtView, float downSideTxtView,String tag) {
        //victoryBox = vicotryBoxHitBoxTolerance(victoryBox); //victoryBox
       float[] victoryBox;
       victoryBox = this.getlocation(test.get(0));
       for(int i=0;i<test.size();i++){
           victoryBox = this.getlocation(test.get(i));
       if(isarectangle(victoryBox, leftSideTxtView, rightSideTxtView, upperSideTxtView, downSideTxtView) && test.get(i).getTag().equals(tag) ){
            showText("Bravo!");
            rightAnswerCounter++;




            if(rightAnswerCounter ==5){
                unableLoose();
                unableScoreMode();
                time.stop();
                timeScore =  (SystemClock.elapsedRealtime() - time.getBase())/1000;
                showResultScreen(this);
            }
            return true;
        }}
        showText("Essaie encore!");
        return false;
    }

    private boolean isarectangle(@NonNull float[] victoryBox, float leftSideTxtView, float rightSideTxtView, float upperSideTxtView, float downSideTxtView) {
        return leftSideTxtView >= victoryBox[0]&& leftSideTxtView <= victoryBox[2]  &&  upperSideTxtView>=victoryBox[1]  && downSideTxtView<=victoryBox[3];
    }


    private float [] getlocation(@NonNull View v){
        int t[] = new int[2];
        v.getLocationOnScreen(t);

        Log.d("pos1","pos 1"+t[0]);
        /*Log.d("pos1","pos 1"+t[1]);*/
        float leftSide = t[0];
        float rightSide = leftSide + v.getWidth();
        float upperSide = t[1];
        float downSide = upperSide + v.getHeight();


        return new float[]{leftSide,upperSide,rightSide,downSide};
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
