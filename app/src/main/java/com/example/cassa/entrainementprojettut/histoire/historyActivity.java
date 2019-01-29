package com.example.cassa.entrainementprojettut.histoire;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.cassa.entrainementprojettut.R;
import com.example.cassa.entrainementprojettut.gameUtils.GameActivity;

import java.util.ArrayList;

public class historyActivity extends GameActivity {
    private int xDelta;
    private int yDelta;
    ArrayList<ImageView> image=new ArrayList<>();
    ArrayList<TextView> text=new ArrayList<>();
    Chronometer time;
    String[] periode={"préhistoire","antiquité","moyen-age","temps\nmoderne","époque\ncontenporaine"};
    private int rightAnswerCounter=0;
    ConstraintLayout mainlayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);


        initializeGame();

        showMenu();



        mainlayout=findViewById(R.id.mainlayout);


        time=findViewById(R.id.chronometer2);




        //initializeGameAfterMenuDismiss();
        if (isSong()) {
            startBackgroundMusic(historyActivity.this, R.raw.geography_music);
        }

        initializeGameAfterMenuDismiss();
        ///playerEvent = MediaPlayer.create(historyActivity.this, R.raw.envent_sound);
    }

    private void test() {
        ConstraintLayout test= (ConstraintLayout) getLayoutInflater().inflate(R.layout.layout_niveau1_history,mainlayout,false);
        mainlayout.addView(test);

        text.add((TextView) test.findViewById(R.id.textView3));
        text.add((TextView) test.findViewById(R.id.textView4));
        text.add((TextView) test.findViewById(R.id.textView5));
        text.add((TextView) test.findViewById(R.id.textView6));
        text.add((TextView) test.findViewById(R.id.textView7));


        image.add((ImageView) test.findViewById(R.id.imageView1));
        image.add((ImageView) test.findViewById(R.id.imageView2));
        image.add((ImageView) test.findViewById(R.id.imageView3));
        image.add((ImageView) test.findViewById(R.id.imageView4));
        image.add((ImageView) test.findViewById(R.id.imageView5));

        for(int i=0;i<image.size();i++){
            image.get(i).setTag(periode[i]);
        }
        for(int i=0;i<image.size();i++){
            text.get(i).setOnTouchListener(onTouchListener());
            text.get(i).setEnabled(true);
            text.get(i).setText(periode[i]);
            text.get(i).setTag(periode[i]);
        }
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
                    if(levelChosen==1)
                    test();

                } else {
                    showMenu();
                }
            }
        });
    }








    private void showMenu() {
        String[] menu = new String[2];
        menu[0] = "niveau 1";
        menu[1] = "niveau 2";

        displayLevelchoice(this, menu);
    }

    private View.OnTouchListener onTouchListener(){
        return new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int t2[] = new int[2];
                view.getLocationInWindow(t2);
                final int x=(int) motionEvent.getRawX();
                final int y=(int) motionEvent.getRawY();

                switch(motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        ConstraintLayout.LayoutParams lParams=(ConstraintLayout.LayoutParams)view.getLayoutParams();
                        xDelta=x-lParams.leftMargin;
                        yDelta=y-lParams.topMargin;
                        Log.d("move12","is touch");
                        break;

                    case MotionEvent.ACTION_MOVE:
                        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();

                        layoutParams.leftMargin=x-xDelta;
                        layoutParams.topMargin=y-yDelta;

                        Log.d("move12","is move");
                        view.setLayoutParams(layoutParams);
                        break;

                    case MotionEvent.ACTION_UP:
                        int tagCoords[] = new int[2];
                        view.getLocationOnScreen(tagCoords);
                        float leftSide = tagCoords[0];
                        float rightSide = leftSide + view.getWidth();
                        float upperSide = tagCoords[1];
                        float downSide = upperSide + view.getHeight();
                        Log.d("pos1","pos 1"+tagCoords[0]);

                        if(checkVictoryBox(leftSide, rightSide, upperSide, downSide,(String)view.getTag()))
                            view.setEnabled(false);

                        break;

                }

                return true;
            }
        };
    }

    private boolean checkVictoryBox( float leftSideTxtView, float rightSideTxtView,
                                     float upperSideTxtView, float downSideTxtView, String tag) {

        //victoryBox = vicotryBoxHitBoxTolerance(victoryBox); //victoryBox
        float[] victoryBox;
        victoryBox = this.getlocation(image.get(0));
        for(int i=0;i<image.size();i++){
            victoryBox = this.getlocation(image.get(i));
            if(isarectangle(victoryBox, leftSideTxtView, rightSideTxtView, upperSideTxtView, downSideTxtView) && tag.equals(image.get(i).getTag())  ){
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


    private boolean isarectangle(@NonNull float[] victoryBox, float leftSideTxtView, float rightSideTxtView, float upperSideTxtView, float downSideTxtView) {
        return leftSideTxtView >= victoryBox[0]+5 && leftSideTxtView <= victoryBox[2]+5  &&  upperSideTxtView>=victoryBox[1]+5  && downSideTxtView<=victoryBox[3]+5;
    }
}
