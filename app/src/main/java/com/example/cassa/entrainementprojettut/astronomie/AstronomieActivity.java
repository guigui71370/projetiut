package com.example.cassa.entrainementprojettut.astronomie;

import android.content.DialogInterface;
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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_astrnomie);
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





        image1.setImageResource(R.drawable.mercury);
        String te= getResources().getResourceEntryName(R.drawable.mercury);

        ImageFactoriesSize.factorisize(image1,te,scale );



    }



    public  void generatedNewGame(){
        ctrl=new controler(this);
        goodAnswer=getResources().getResourceEntryName(ctrl.calculGoodanswer());
        text.setText(goodAnswer);
        int[]reponce=ctrl.reponceshufle();

        for(int i=0;i<reponce.length;i++){
            tab[i].setImageResource(reponce[i]);
             ImageFactoriesSize.factorisize(image1,getResources().getResourceEntryName(reponce[i]),scale );
        }

    }


    public  void checkAnswer(String planetname){

        if(this.goodAnswer.equals(planetname)&& this.nbgoodAnswer<10){
            this.nbgoodAnswer++;
            this.generatedNewGame();
        }else if(this.nbgoodAnswer==10){
            unableLoose();
            unableScoreMode();
            chronometer.stop();
            timeScore = (SystemClock.elapsedRealtime() - chronometer.getBase()) / 1000;
            initializeScoreValues("astronomie", levelChosen);
            showResultScreen(this);
        }else {



            generatedNewGame();
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
            Log.d("astronmie",getResources().getResourceEntryName(v.getId()));
            checkAnswer(getResources().getResourceEntryName(v.getId()));
        }else {
            Log.d("astronmie","eror");

        }
    }
}
