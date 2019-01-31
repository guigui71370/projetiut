package com.example.cassa.entrainementprojettut.astronomie.Controler;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cassa.entrainementprojettut.R;
import com.example.cassa.entrainementprojettut.astronomie.AstronomieUtil.PlanetBank;
import com.example.cassa.entrainementprojettut.astronomie.ImageFactoriesSize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;

public class ControlerLVL3 {
    private ConstraintLayout constraintLayoutAstronomie;
    private ImageView planet;
    private ArrayList<PlanetBank> list = new ArrayList<>();
    private Context context;
    private TextView planeteName1;
    private TextView planeteName2;
    private TextView planeteName3;
    private TextView planeteName4;

    private TextView[] txtPlanet;

    public ControlerLVL3(Context context, ConstraintLayout constraintLayoutAstronomie){
        this.context = context;
        this.constraintLayoutAstronomie = constraintLayoutAstronomie;
        createGame();
    }

    private void createGame() {
        this.planet = constraintLayoutAstronomie.findViewById(R.id.activity_astronomie_planet_imageView);
        this.planeteName1 = constraintLayoutAstronomie.findViewById(R.id.activity_astronomie_planetName1_textView);
        this.planeteName2 = constraintLayoutAstronomie.findViewById(R.id.activity_astronomie_planetName2_textView);
        this.planeteName3 = constraintLayoutAstronomie.findViewById(R.id.activity_astronomie_planetName3_textView);
        this.planeteName4 = constraintLayoutAstronomie.findViewById(R.id.activity_astronomie_planetName4_textView);
        this.txtPlanet = new TextView[]{planeteName1, planeteName2, planeteName3, planeteName4};
        shuffleAnswer();
    }

    public int getRightAnswer(){
        float scale = context.getResources().getDisplayMetrics().density;
        int r = (int)(Math.random() * 4);
        this.planet.setBackgroundResource(list.get(r).getPlanetID());
        ImageFactoriesSize.factorisize(this.planet,list.get(r).toString(),scale);
        return this.txtPlanet[r].getId();
    }

    private void shuffleAnswer(){
        list = new ArrayList<PlanetBank>(EnumSet.allOf(PlanetBank.class));
        Collections.shuffle(list);
        for (int i=0; i<4; i++) {
            this.txtPlanet[i].setText(list.get(i).toString());
        }
    }
}
