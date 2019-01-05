package com.example.cassa.entrainementprojettut.astronomie;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.SystemClock;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cassa.entrainementprojettut.R;
import com.example.cassa.entrainementprojettut.gameUtils.GameActivity;

public class AstronomieActivity extends GameActivity implements View.OnClickListener {

    controler ctrl;
    private Chronometer chronometer;
    ImageView image1 ;
    ImageView image2 ;
    ImageView image3 ;
    ImageView image14 ;
    TextView text;
    ImageView tab[];
    private  float scale ;
    private  String goodAnswer="test";
    private  int nbgoodAnswer=0;
    private   final Handler handlers = new Handler();
    private Runnable pause=new Runnable() {
        @Override
        public void run() {
         enableImage();
         generatedNewGame();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_astronomie);
        showMenu();
        initializeGame();
        music = R.raw.bensound_retrosoul;
        if(isSong()){
            startBackgroundMusic(this,music);
        }

        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                if (levelChosen != 0) {
                    generatedNewGame();
                    //launchTimer(AdditionActivity.this,60000,R.id.acivity_addition_pos1_img,R.id.activity_addition_ordi_img);
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    chronometer.start();
                } else {
                    AstronomieActivity.this.onStop();
                    dialog.show();
                }
            }
        });


        image1 =findViewById(R.id.imageView);
        image2 =findViewById(R.id.imageView4);
        image3 =findViewById(R.id.imageView3);
        image14 =findViewById(R.id.imageView5);
        scale = getResources().getDisplayMetrics().density;
        text=findViewById(R.id.textView);

        tab=new ImageView[]{image1,image2,image3,image14};
        chronometer=findViewById(R.id.activity_astronomie_chrono_chronometer2);

        image1.setImageResource(R.drawable.mercure);
        String te= getResources().getResourceEntryName(R.drawable.mercure);

        ImageFactoriesSize.factorisize(image1,te,scale );
        image1.setOnClickListener(this);
        image2.setOnClickListener(this);
        image3.setOnClickListener(this);
        image14.setOnClickListener(this);
    }

    public  void generatedNewGame(){
        ctrl=new controler(this);
        goodAnswer=getResources().getResourceEntryName(ctrl.calculGoodanswer());
        text.setText(goodAnswer);
        int[]reponce=ctrl.reponceshufle();

        for(int i=0;i<reponce.length;i++){
            tab[i].setImageResource(reponce[i]);
            ImageFactoriesSize.factorisize(tab[i],getResources().getResourceEntryName(reponce[i]),scale );
            tab[i].setTag(getResources().getResourceEntryName(reponce[i]));
        }
        enableImage();
    }

    public  void checkAnswer(String planetname){
        if(this.goodAnswer.equals(planetname)&& this.nbgoodAnswer<10){
            this.nbgoodAnswer++;
            handlers.postDelayed(pause,3000);
            //this.generatedNewGame();
            showText(getString(R.string.Well_played));
        }else if(this.nbgoodAnswer==10){
            unableLoose();
            unableScoreMode();
            chronometer.stop();
            timeScore = (SystemClock.elapsedRealtime() - chronometer.getBase()) / 1000;
            initializeScoreValues("astronomie", levelChosen);
            showResultScreen(this);
        }else {
            showText("mauvaise réponse");
            handlers.postDelayed(pause,3000);
        }
    }

    private void showMenu(){
        String[] menu = new String[1];
        menu[0]= "niveau 1";

        displayLevelchoice(this,menu);
    }

    @Override
    public void onClick(View v) {
        if(v instanceof ImageView){

            // Log.d("astronmie", v.getBackground().getClass().getName());
            disableImage();
            String paysSelectione = (String) v.getTag();
            Log.d("astronmie",    paysSelectione+" ");
            Log.d("astronmie",getResources().getResourceEntryName(v.getId()));

            checkAnswer(paysSelectione);
        }else {
            Log.d("astronmie","error");

        }
    }




    private void enableImage(){
        int i;
        for(i=0; i<tab.length; i++) {
            tab[i].setEnabled(true);

        }
    }
    private void disableImage(){
        int i;
        for(i=0; i<tab.length; i++) {
            tab[i].setEnabled(false);

        }
    }
}
