package com.example.cassa.entrainementprojettut.astronomie.Controler;

import android.content.ClipData;
import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.cassa.entrainementprojettut.R;
import com.example.cassa.entrainementprojettut.astronomie.AstronomieActivity;
import com.example.cassa.entrainementprojettut.astronomie.AstronomieUtil.PlanetBank;
import com.example.cassa.entrainementprojettut.astronomie.ImageFactoriesSize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;

public class ControlerLVL1 {
    private Context context;
    private AstronomieActivity astronomieActivity;
    private ConstraintLayout constraintLayoutAstronomie;

    private ArrayList<PlanetBank> list = new ArrayList<>();

    private TextView planeteName1_lvl3;
    private TextView planeteName2_lvl3;
    private TextView planeteName3_lvl3;
    private TextView planeteName4_lvl3;
    private TextView planeteName5_lvl3;
    private TextView planeteName6_lvl3;
    private TextView planeteName7_lvl3;
    private TextView planeteName8_lvl3;

    private LinearLayout planeteMercure_lvl3;
    private LinearLayout planeteVenus_lvl3;
    private LinearLayout planeteTerre_lvl3;
    private LinearLayout planeteMars_lvl3;
    private LinearLayout planeteJupiter_lvl3;
    private LinearLayout planeteSaturne_lvl3;
    private LinearLayout planeteUranus_lvl3;
    private LinearLayout planeteNeptune_lvl3;

    private ImageView planet1;
    private ImageView planet2;
    private ImageView planet3;
    private ImageView planet4;
    private ImageView planet5;
    private ImageView planet6;
    private ImageView planet7;
    private ImageView planet8;
    private LinearLayout linearLayoutPlanete;

    private TextView[] txtPlanet;
    private LinearLayout[] conteneurPlanet;
    private ImageView[] imgPlanet;

    private int rightInput = 0;

    public ControlerLVL1(Context context, ConstraintLayout constraintLayout){
        this.context = context;
        this.constraintLayoutAstronomie = constraintLayout;
        createGame();
        astronomieActivity = (AstronomieActivity) context;
    }

    private void createGame() {
        this.planeteName1_lvl3 = constraintLayoutAstronomie.findViewById(R.id.activity_astronomie_lvl3_planetName1_textView);
        this.planeteName2_lvl3 = constraintLayoutAstronomie.findViewById(R.id.activity_astronomie_lvl3_planetName2_textView);
        this.planeteName3_lvl3 = constraintLayoutAstronomie.findViewById(R.id.activity_astronomie_lvl3_planetName3_textView);
        this.planeteName4_lvl3 = constraintLayoutAstronomie.findViewById(R.id.activity_astronomie_lvl3_planetName4_textView);
        this.planeteName5_lvl3 = constraintLayoutAstronomie.findViewById(R.id.activity_astronomie_lvl3_planetName5_textView);
        this.planeteName6_lvl3 = constraintLayoutAstronomie.findViewById(R.id.activity_astronomie_lvl3_planetName6_textView);
        this.planeteName7_lvl3 = constraintLayoutAstronomie.findViewById(R.id.activity_astronomie_lvl3_planetName7_textView);
        this.planeteName8_lvl3 = constraintLayoutAstronomie.findViewById(R.id.activity_astronomie_lvl3_planetName8_textView);
        this.txtPlanet = new TextView[]{planeteName1_lvl3, planeteName2_lvl3, planeteName3_lvl3, planeteName4_lvl3, planeteName5_lvl3, planeteName6_lvl3, planeteName7_lvl3, planeteName8_lvl3};

        this.planeteMercure_lvl3 = constraintLayoutAstronomie.findViewById(R.id.activity_astronomie_lvl3_mercure_textViewConteneur);
        this.planeteVenus_lvl3 = constraintLayoutAstronomie.findViewById(R.id.activity_astronomie_lvl3_venus_textViewConteneur);
        this.planeteTerre_lvl3 = constraintLayoutAstronomie.findViewById(R.id.activity_astronomie_lvl3_terre_textViewConteneur);
        this.planeteMars_lvl3 = constraintLayoutAstronomie.findViewById(R.id.activity_astronomie_lvl3_mars_textViewConteneur);
        this.planeteJupiter_lvl3 = constraintLayoutAstronomie.findViewById(R.id.activity_astronomie_lvl3_jupiter_textViewConteneur);
        this.planeteSaturne_lvl3 = constraintLayoutAstronomie.findViewById(R.id.activity_astronomie_lvl3_saturne_textViewConteneur);
        this.planeteUranus_lvl3 = constraintLayoutAstronomie.findViewById(R.id.activity_astronomie_lvl3_uranus_textViewConteneur);
        this.planeteNeptune_lvl3 = constraintLayoutAstronomie.findViewById(R.id.activity_astronomie_lvl3_neptune_textViewConteneur);
        this.conteneurPlanet = new LinearLayout[]{planeteMercure_lvl3, planeteVenus_lvl3, planeteTerre_lvl3, planeteMars_lvl3, planeteJupiter_lvl3, planeteSaturne_lvl3, planeteUranus_lvl3, planeteNeptune_lvl3};

        this.planet1 = constraintLayoutAstronomie.findViewById(R.id.activity_astronomie_lvl3_mercure_imageView);
        this.planet2 = constraintLayoutAstronomie.findViewById(R.id.activity_astronomie_lvl3_venus_imageView);
        this.planet3 = constraintLayoutAstronomie.findViewById(R.id.activity_astronomie_lvl3_terre_imageView);
        this.planet4 = constraintLayoutAstronomie.findViewById(R.id.activity_astronomie_lvl3_mars_imageView);
        this.planet5 = constraintLayoutAstronomie.findViewById(R.id.activity_astronomie_lvl3_jupiter_imageView);
        this.planet6 = constraintLayoutAstronomie.findViewById(R.id.activity_astronomie_lvl3_saturne_imageView);
        this.planet7 = constraintLayoutAstronomie.findViewById(R.id.activity_astronomie_lvl3_uranus_imageView);
        this.planet8 = constraintLayoutAstronomie.findViewById(R.id.activity_astronomie_lvl3_neptune_imageView);
        this.imgPlanet = new ImageView[]{planet1, planet2, planet3, planet4, planet5, planet6, planet7, planet8};
        this.linearLayoutPlanete = constraintLayoutAstronomie.findViewById(R.id.activity_astronomie_lvl3_linearLayoutPlanet_linearLayout);

        shuffleAnswer();
        activateListener();
    }

    private void shuffleAnswer(){
        float scale = context.getResources().getDisplayMetrics().density;
        float width = context.getResources().getDisplayMetrics().widthPixels;
        list = new ArrayList<PlanetBank>(EnumSet.allOf(PlanetBank.class));
        for (int j=0; j<8; j++) {
            this.imgPlanet[j].setBackgroundResource(list.get(j).getPlanetID());
            ImageFactoriesSize.factorisize(this.imgPlanet[j],list.get(j).toString(),scale);
            ImageFactoriesSize.setEmplacement(context,this.imgPlanet[j],list.get(j).toString());
        }
        ViewGroup.LayoutParams linearLayoutPlaneteLayoutParams = linearLayoutPlanete.getLayoutParams();
        linearLayoutPlaneteLayoutParams.width = (int) width;
        Collections.shuffle(list);
        for (int i=0; i<8; i++) {
            this.txtPlanet[i].setText(list.get(i).toString());
        }
    }

    private void activateListener(){
        for (LinearLayout l: conteneurPlanet) {
            l.setOnDragListener(new MyDragListener());
        }
        for (TextView t: txtPlanet){
            t.setOnTouchListener(new MyTouchListener());
        }
    }

    private final class MyTouchListener implements View.OnTouchListener {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(
                        view);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.INVISIBLE);
                return true;
            } else {
                return false;
            }
        }
    }

    class MyDragListener implements View.OnDragListener {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            if (event.getLocalState() instanceof TextView && v instanceof LinearLayout) {
                int action = event.getAction();
                switch (event.getAction()) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        return true;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        break;
                    case DragEvent.ACTION_DROP:
                        // Dropped, reassign View to ViewGroup
                        TextView view = (TextView) event.getLocalState();
                        LinearLayout container = (LinearLayout) v;
                        if(v.getContentDescription().equals(view.getText())){
                            ViewGroup owner = (ViewGroup) view.getParent();
                            owner.removeView(view);
                            container.addView(view);
                            rightInput++;
                            astronomieActivity.checkAnswer_LVL1(rightInput);
                            //Log.d("Test drop", "rightAnswer:  " + rightAnswer);
                        }else{
                            Log.d("Test drop", "attendue: " + v.getContentDescription());
                            Log.d("Test drop", "selectionne:  " + view.getText());
                        }
                        //view.setVisibility(View.VISIBLE);
                        break;
                    case DragEvent.ACTION_DRAG_ENDED:
                        view = (TextView) event.getLocalState();
                        view.setVisibility(View.VISIBLE);
                    default:
                        break;
                }
            }
            return true;
        }
    }
}
