package com.example.cassa.entrainementprojettut.geography;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.cassa.entrainementprojettut.gameUtils.GameActivity;
import com.example.cassa.entrainementprojettut.R;
import java.util.Collections;
import java.util.List;


/**
 * Created by clement on 07/12/17.
 */

public class GeographyActivity extends GameActivity {

    private ViewGroup       mainLayout;
    private List<Tag> tagList;

    private int rightAnswerCounter;
    private int xDelta;
    private int yDelta;

    private MediaPlayer playerEvent;
    private  TextView[] tabTextView;
    private Chronometer chronometer;
    private Controler controler;
    private int verticalSpaceBetweenTags;
    private int horizontalSpaceBetweenCols;
    private float sideSizeOfATag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        music = R.raw.geography_music;
        fullScreenMode(); // To avoid the top menu from appearing
        setContentView(R.layout.activity_geographytag);
        chronometer = (Chronometer)findViewById(R.id.chronometer2);
        mainLayout = (RelativeLayout) findViewById(R.id.geographyTag_relativeLayout);

        initializeGame();
        showMenu();

        initializeSizeOfATag();
        initializeGameAfterMenuDismiss();
        startBackgroundMusic(GeographyActivity.this, R.raw.geography_music);
        playerEvent=MediaPlayer.create(GeographyActivity.this,R.raw.envent_sound);

    }
    private void initializeSizeOfATag() {
        verticalSpaceBetweenTags = 100;
        sideSizeOfATag = 0.1F;
    }

    private void initializeGameAfterMenuDismiss() {
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                        @Override
                                        public void onDismiss(DialogInterface dialogInterface) {
                                            if (levelChosen != 0) {
                                                initializeScoreValues("geography",levelChosen);

                                                controler = new Controler(levelChosen,sideSizeOfATag);
                                                tagList = controler.getTagList();

                                                setBackgroundImage();
                                                setRectangleOnMap();
                                                generateTextView();
                                                setTagTextView();
                                                chronometer.setBase(SystemClock.elapsedRealtime());
                                                chronometer.start();
                                                rightAnswerCounter =0;
                                            } else {
                                                showMenu();
                                            }
                                        }
                                    });
    }

    private void generateTextView(){
        int maxTagInAColumn = getMaxTagInAColumn();
        int columnID = 0;

        shuffleTagGroup();

        tabTextView = new TextView[tagList.size()];

        for(int i = 0; i< tagList.size(); i++){

            tabTextView[i] = new TextView(this);
            tabTextView[i].setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL);
            tabTextView[i].setMinWidth(100);
            tabTextView[i].setBackgroundColor(Color.parseColor("#f3f0e8"));
            tabTextView[i].setOnTouchListener(onTouchListener());

        }
        setNameTextView();

        float maxWidth = sideSizeOfATag * getScreenWidth() ;
        
        horizontalSpaceBetweenCols =(int) maxWidth + 10;
        for(int i = 0; i< tagList.size(); i++){
            if (isPlacedInTheNextCol(maxTagInAColumn, columnID, i)){
                columnID +=1;
            }
            RelativeLayout.LayoutParams textViewParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

            textViewParams.setMargins((columnID* horizontalSpaceBetweenCols), ((i-(columnID*(maxTagInAColumn-1))) * verticalSpaceBetweenTags), 0, 0);
            tabTextView[i].setLayoutParams(textViewParams);
            mainLayout.addView(tabTextView[i],textViewParams);
        }
    }
    private void setTagTextView() {
        for(int i = 0; i< tagList.size(); i++){
            tabTextView[i].setTag(tagList.get(i).getVictoryBox());
        }
    }

    private void setNameTextView() {
        for(int i = 0; i< tagList.size(); i++){
            tabTextView[i].setText(tagList.get(i).getName());
        }
    }

    private View.OnTouchListener onTouchListener(){
        return new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

            final int x=(int) motionEvent.getRawX();
            final int y=(int) motionEvent.getRawY();
                switch(motionEvent.getAction()){
                case MotionEvent.ACTION_DOWN:
                    RelativeLayout.LayoutParams lParams=(RelativeLayout.LayoutParams)view.getLayoutParams();
                    xDelta=x-lParams.leftMargin;
                    yDelta=y-lParams.topMargin;
                    break;

                case MotionEvent.ACTION_MOVE:
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.leftMargin=x-xDelta;
                    layoutParams.topMargin=y-yDelta;
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

                    if (checkVictoryBox((float[])view.getTag(),leftSide, rightSide, upperSide, downSide)){
                       view.setEnabled(false);

                       view.setBackgroundColor(Color.GREEN);
                       playerEvent.start();
                    }
                    else{
                        int position = getPositionTag((float[])view.getTag());
                       replaceTag(view,position);
                    }
            }
            mainLayout.invalidate();
            return true;
            }
        };
    }

    private int getPositionTag(float[] victoryBox) {
        int i =0;
        for(Tag tag: tagList){
            if(tag.getVictoryBox() == victoryBox){
                return i;
            }
            i++;
        }

        return 0;
    }
    private void shuffleTagGroup() {
        Collections.shuffle(tagList);
    }

    private void replaceTag(View view,int position) {

        int maxTagInAColumn = getMaxTagInAColumn();
        int column = ((position)/(maxTagInAColumn-1));
        showText("Column"+column);
        RelativeLayout.LayoutParams layoutP = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutP.leftMargin= (column * horizontalSpaceBetweenCols);
        layoutP.topMargin= ((position - (column*(maxTagInAColumn-1)))*verticalSpaceBetweenTags);
        view.setLayoutParams(layoutP);
    }
    private Boolean isPlacedInTheNextCol(int maxTagInAColum, int columnID, int idTag) {
        return (((((idTag + 1) + columnID) % (maxTagInAColum)) == 0));

    }

    private void setBackgroundImage() {
            mainLayout.setBackgroundResource(controler.getBackgroundImage());
    }

    private void setRectangleOnMap(){
        Paint paint = new Paint();
        paint.setColor(Color.GRAY);
        paint.setAlpha(85);

        Bitmap b = Bitmap.createBitmap((int)getScreenWidth(), (int)getScreenHeight(), Bitmap.Config.ARGB_8888);

        View conteneurRect = getLayoutInflater().inflate(R.layout.geographytag_conteneur_rect, mainLayout, false);
        mainLayout.addView(conteneurRect);

        ImageView drawRectangle = findViewById(R.id.geography_conteneur_rect);
        drawRectangle.setImageBitmap(b);

        Canvas canvas = new Canvas(b);
        RectF rect;
        float[] tagCoords;

        for(Tag etiquette : tagList){

            tagCoords = resizeVictoryBox(etiquette.getVictoryBox());

            rect = new RectF(tagCoords[0], tagCoords[2], tagCoords[1],
                    tagCoords[3]);

            canvas.drawRect(rect, paint);

        }
    }
    private boolean checkVictoryBox(float[]victoryBox, float leftSideTxtView, float rightSideTxtView,
                                    float upperSideTxtView, float downSideTxtView){

        victoryBox = vicotryBoxHitBoxTolerance(victoryBox); //victoryBox

        if( leftSideTxtView >= victoryBox[0] && leftSideTxtView <= victoryBox[1]
                && rightSideTxtView >= victoryBox[0] && rightSideTxtView <= victoryBox[1]
                && upperSideTxtView >= victoryBox[2] && upperSideTxtView <= victoryBox[3]
                && downSideTxtView >= victoryBox[2] && downSideTxtView <= victoryBox[3]){
            showText("Bravo!");
            rightAnswerCounter++;
            if(rightAnswerCounter == tagList.size()){
                unableLoose();
                unableScoreMode();
                chronometer.stop();
                timeScore =  (SystemClock.elapsedRealtime() - chronometer.getBase())/1000;
                showResultScreen(this);
            }
            return true;
        }

        return false;
    }

    private float[] vicotryBoxHitBoxTolerance(float[] victoryBox) {
        victoryBox[0] -= 8;
        victoryBox[1] += 8;
        victoryBox[2] -= 8;
        victoryBox[3] += 8;

        return victoryBox;
    }

    private float[] resizeVictoryBox(float[] victoryBox) {

        victoryBox[0] = victoryBox[0] * getScreenWidth();
        victoryBox[1] = victoryBox[1] * getScreenWidth();
        victoryBox[2]  = victoryBox[2] * getScreenHeight();
        victoryBox[3]  = victoryBox[3] * getScreenHeight();

        return  victoryBox;
    }

    private int getMaxTagInAColumn(){
        int maxTagInAColumn = 0;
        while(maxTagInAColumn*verticalSpaceBetweenTags<= getScreenHeight() * 0.9){
            maxTagInAColumn++;
        }

        return maxTagInAColumn;
    }
    private void showMenu(){
        String[] menu = new String[3];
        menu[0]= "niveau 1";
        menu[1]= "niveau 2";
        menu[2]= "niveau 3";
        displayLevelchoice(this,menu);
    }
    @Override
    protected void onResume() {
        super.onResume();
        fullScreenMode();
    }

    private void fullScreenMode(){
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

}
