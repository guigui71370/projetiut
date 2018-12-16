package com.example.cassa.entrainementprojettut.gameUtils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Handler;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatCallback;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cassa.entrainementprojettut.MainActivity;
import com.example.cassa.entrainementprojettut.R;
import com.example.cassa.entrainementprojettut.database.AppDatabase;
import com.example.cassa.entrainementprojettut.database.Score;
import com.plattysoft.leonids.ParticleSystem;



public class GameActivity extends ActivityUtil implements AppCompatCallback,
        TaskStackBuilder.SupportParentable, ActionBarDrawerToggle.DelegateProvider {

    Toast toast;

    public GameActivity() {
        dialog = null;
    }

    protected final Handler handler = new Handler();
    protected float playerImagePosition;
    protected ImageView playerImage;
    protected ImageView IAImage;
    protected Runnable looseActivity;
    protected Runnable scoreMode;
    protected long numericalScore;
    protected long timeScore;
    protected String currentActivityName;
    protected int currentLevel;
    protected View lvlChoiceView;

    protected String playerName = MainActivity.getPlayerName();

    protected  void showText(String text){

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
        }, 1500);
    }



    protected  void showTextdurration(String text, int time){

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
        }, time);
    }

    protected int levelChosen = 0;
    protected AlertDialog dialog;


    protected void initializeGame(){
        levelChosen = 0;
        timeScore = 0;
        numericalScore = 0;
        if(looseActivity != null) {
            handler.removeCallbacks(looseActivity);
        }
        if(scoreMode != null) {
            handler.removeCallbacks(scoreMode);
        }
    }

    protected void initializeScoreValues(String gameName,int difficulty){
        currentActivityName=gameName;
        currentLevel=difficulty;
    }

    protected void displayLevelchoice(Context activityContext, String[] levelsNames){

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(activityContext);
        mBuilder.setCancelable(false);
        mBuilder.setNegativeButton("Retour au menu",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        Intent back = new Intent(getApplicationContext(), MainActivity.class);

                        startActivity(back);
                        finish();
                    }
                });

            String colorsTab[] = {"#77dd6c", "#eebf38", "#ee3838", "#c847ea", "#47aaea"};

        lvlChoiceView = getLayoutInflater().inflate(R.layout.level_choice_popup, null);

        LinearLayout container = lvlChoiceView.findViewById(R.id.level_popup_activity_linearlayout);
        for(int i = 0; i < levelsNames.length; i++) {
            final Button lvlButton = (Button) this.getLayoutInflater().inflate(R.layout.level_choice_button, container, false);
            lvlButton.setText(levelsNames[i]);
            lvlButton.setTag(i + 1);
            lvlButton.getBackground().setColorFilter(Color.parseColor(colorsTab[i]), PorterDuff.Mode.MULTIPLY);
            lvlButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view){
                    levelChosen = (int)view.getTag();
                    dialog.dismiss();
                }
            });
            if(container != null) {
                container.addView(lvlButton);
            }
        }

        TextView message = lvlChoiceView.findViewById(R.id.level_popup_message_textView);

        mBuilder.setView(lvlChoiceView);
        dialog = mBuilder.create();
        dialog.show();

        //On prend les caracs de l'écran
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        Window window = dialog.getWindow();
        lp.copyFrom(window.getAttributes());

        //On l'applique au dialogue
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);


        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {

                Context c = getApplicationContext();
                Intent ecranMenu = new Intent(c, MainActivity.class);
                startActivity(ecranMenu);
                finish();
            }
        });
    }

    protected void disableLevelMenu(){
        LinearLayout container = lvlChoiceView.findViewById(R.id.level_popup_activity_linearlayout);
        View child;
        for(int i = 0; i < container.getChildCount(); i++) {
            child = container.getChildAt(i);
            child.setEnabled(false);
        }
    }

    protected void enableLevelMenu(){
        LinearLayout container = lvlChoiceView.findViewById(R.id.level_popup_activity_linearlayout);
        View child;
        for(int i = 0; i < container.getChildCount(); i++) {
            child = container.getChildAt(i);
            child.setEnabled(true);
        }
    }

    protected void showResultScreen(final Activity activity) {
        if(!activity.isFinishing()) {
            if (looseActivity != null) {
                handler.removeCallbacks(looseActivity);
            }
            if (levelChosen != 0) {
                final boolean[] canLeave = {false};

                AlertDialog.Builder mBuilder = new AlertDialog.Builder(activity);

                View resultView = getLayoutInflater().inflate(R.layout.resultat_popup, null);

                Button replayButton = resultView.findViewById(R.id.resultat_popup_rejouer_btn);
                Button menuButton = resultView.findViewById(R.id.resultat_popup_menu_btn);
                TextView mTextViewMessage = resultView.findViewById(R.id.resultat_popup_messace_textView);

                mBuilder.setView(resultView);
                dialog = mBuilder.create();
                dialog.show();

                //On prend les caracs de l'écran
                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                Window window = dialog.getWindow();
                lp.copyFrom(window.getAttributes());

                //On l'applique au dialogue
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                window.setAttributes(lp);

                if (numericalScore > 0) {
                    checkNumericalScore(mTextViewMessage, numericalScore, "Ton score est de ", " Record actuel :");
                } else if (timeScore > 0) {
                    checkTimeScore(mTextViewMessage, timeScore, "Bravo, tu as réussi en ", " secondes! Record actuel :");
                }
                dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (canLeave[0]) {
                            dialog.dismiss();

                        } else {
                            dialog.show();
                        }

                    }
                });
                replayButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        canLeave[0] = true;
                        activity.recreate();
                        dialog.dismiss();

                    }
                });
                menuButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        canLeave[0] = true;
                        Intent additionIntent = new Intent(activity, MainActivity.class);
                        startActivity(additionIntent);
                        activity.finish();

                    }
                });
                numericalScore = 0;
                timeScore = 0;
            }
        }
    }

    private void checkTimeScore(TextView mTextViewMessage, long Score, String s, String s2) {
        AppDatabase database;
        database = AppDatabase.getInstanceOfAppDatabase(getApplicationContext());
        long highScore = database.getScoreDao().findScoreForAGame(currentActivityName, currentLevel);
        if (highScore == 0) {
            database.getScoreDao().addScore(new Score(playerName, Score, currentActivityName, currentLevel));
            highScore = Score;
        } else if (highScore > Score) {
            database.getScoreDao().updateScore(new Score(playerName, Score, currentActivityName, currentLevel));
            highScore = Score;
        }
        mTextViewMessage.setText(s + Score + s2 + highScore);
        database.destroyInstance();
    }

    private void checkNumericalScore(TextView mTextViewMessage, long Score, String s, String s2) {
        AppDatabase database;
        database = AppDatabase.getInstanceOfAppDatabase(getApplicationContext());
        long highScore = database.getScoreDao().findScoreForAGame(currentActivityName, currentLevel);
        if (highScore == 0) {
            database.getScoreDao().addScore(new Score(playerName, Score, currentActivityName, currentLevel));
            highScore = Score;
        } else if (highScore < Score) {
            database.getScoreDao().updateScore(new Score(playerName, Score, currentActivityName, currentLevel));
            highScore = Score;
        }
        mTextViewMessage.setText(s + Score + s2 + highScore);
        database.destroyInstance();
    }

    protected void showLooseScreen(final Activity activity){
        if(!activity.isFinishing()) {

            final boolean[] canLeave = {false};
            if (scoreMode != null) {
                handler.removeCallbacks(scoreMode);
            }

            levelChosen = 0;

            AlertDialog.Builder mBuilder = new AlertDialog.Builder(activity);

            View resultView = getLayoutInflater().inflate(R.layout.resultat_popup, null);

            Button replayButton = resultView.findViewById(R.id.resultat_popup_rejouer_btn);
            Button menuButton = resultView.findViewById(R.id.resultat_popup_menu_btn);
            TextView mTextViewMessage = resultView.findViewById(R.id.resultat_popup_messace_textView);

            mBuilder.setView(resultView);
            dialog = mBuilder.create();
            dialog.show();

            //On prend les caracs de l'écran
            WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
            Window window = dialog.getWindow();
            lp.copyFrom(window.getAttributes());

            //On l'applique au dialogue
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            window.setAttributes(lp);


            mTextViewMessage.setText("Dommage, tu as perdu.");

            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialogInterface) {
                    if (canLeave[0] == true) {
                        dialog.dismiss();

                    } else {
                        dialog.show();
                    }

                }
            });
            replayButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    canLeave[0] = true;
                    activity.recreate();
                    dialog.dismiss();

                }
            });
            menuButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    canLeave[0] = true;
                    Intent additionIntent = new Intent(activity, MainActivity.class);
                    startActivity(additionIntent);
                    activity.finish();

                }
            });
        }
    }

    protected void moveImage(ImageView pImage, float pDestination, int pDuration, float pPosDepart){

        TranslateAnimation animationTranslation=new TranslateAnimation(pPosDepart,pDestination,0,0);
        animationTranslation.setFillAfter(true);
        animationTranslation.setDuration(pDuration);
        pImage.startAnimation(animationTranslation);

    }

    protected void launchTimer(final Activity srcActivity, int arrivalTime, int playerImage, int IAImage){

        startChrono(srcActivity,arrivalTime);

        this.playerImage = findViewById(playerImage);
        this.IAImage = findViewById(IAImage);


        float screenWidth = getScreenWidth();
        int IApictureWidth = this.IAImage.getDrawable().getIntrinsicWidth();


        playerImagePosition = this.playerImage.getX();


        moveImage(this.IAImage,screenWidth-IApictureWidth,arrivalTime,0);

    }
    protected void unableLoose(){
        handler.removeCallbacks(looseActivity);
    }
    protected void unableScoreMode(){
        handler.removeCallbacks(scoreMode);
    }

    protected void startChrono(final Activity srcActivity, int temps){
        looseActivity = new Runnable() {
            @Override
            public void run() {
                if(srcActivity != null){
                    showLooseScreen(srcActivity);
                }
            }
        };

        scoreMode = new Runnable() {
            @Override
            public void run() {

                if(srcActivity != null){
                    showResultScreen(srcActivity);
                }

            }
        };
        handler.postDelayed(looseActivity,temps);
        handler.postDelayed(scoreMode,temps+500);
    }

    protected void firework(int view) {

        new ParticleSystem(this, 32, R.drawable.confeti_blanc, 5000)
                .setSpeedModuleAndAngleRange(0f, 0.3f, 0, 180)
                .setRotationSpeed(150)
                .setAcceleration(0.00005f, 90)
                .oneShot(findViewById(view), 64);

        new ParticleSystem(this, 32, R.drawable.confeti_violet, 5000)
                .setSpeedModuleAndAngleRange(0f, 0.3f, 0, 180)
                .setRotationSpeed(150)
                .setAcceleration(0.00005f, 90)
                .oneShot(findViewById(view), 64);
    }

}
