package com.example.cassa.entrainementprojettut.astronomie.Controler;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cassa.entrainementprojettut.R;
import com.example.cassa.entrainementprojettut.astronomie.AstronomieUtil.PlanetBank;
import com.example.cassa.entrainementprojettut.astronomie.ImageFactoriesSize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;

public class ControlerLVL2 {

    private ConstraintLayout constraintLayoutAstronomie;
    private ImageView planet1;
    private ImageView planet2;
    private ImageView planet3;
    private ImageView planet4;
    private ArrayList<PlanetBank> list = new ArrayList<>();
    private Context context;
    private TextView planeteName;

    private ImageView[] imgPlanet;

    public ControlerLVL2(Context context, ConstraintLayout constraintLayoutAstronomie){
        this.context = context;
        this.constraintLayoutAstronomie = constraintLayoutAstronomie;
        createGame();
    }

    private void createGame() {
        this.planet1 = constraintLayoutAstronomie.findViewById(R.id.activity_astronomie_planet1_imageView);
        this.planet2 = constraintLayoutAstronomie.findViewById(R.id.activity_astronomie_planet2_imageView);
        this.planet3 = constraintLayoutAstronomie.findViewById(R.id.activity_astronomie_planet3_imageView);
        this.planet4 = constraintLayoutAstronomie.findViewById(R.id.activity_astronomie_planet4_imageView);
        this.planeteName = constraintLayoutAstronomie.findViewById(R.id.activity_astronomie_planetName_textView);
        this.imgPlanet = new ImageView[]{planet1, planet2, planet3, planet4};
        shuffleAnswer();
    }

    public int getRightAnswer(){
        int r = (int)(Math.random() * 4);
        this.planeteName.setText(list.get(r).toString());
        return this.imgPlanet[r].getId();
    }

    private void shuffleAnswer(){
        float scale = context.getResources().getDisplayMetrics().density;
        list = new ArrayList<PlanetBank>(EnumSet.allOf(PlanetBank.class));
        Collections.shuffle(list);
        for (int i=0; i<4; i++) {
            this.imgPlanet[i].setBackgroundResource(list.get(i).getPlanetID());
            ImageFactoriesSize.factorisize(this.imgPlanet[i],list.get(i).toString(),scale);
        }
    }
}
