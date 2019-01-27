package com.example.cassa.entrainementprojettut.astronomie.AstronomieUtil;

import com.example.cassa.entrainementprojettut.R;

import java.util.Random;

public enum PlanetBank{

    MERCURE("Mercure",R.drawable.mercure),
    VENUS("Venus",R.drawable.venus),
    TERRE("Terre",R.drawable.terre),
    MARS("Mars",R.drawable.mars),
    JUPITER("Jupiter",R.drawable.jupiter),
    SATURNE("Saturne",R.drawable.saturne),
    URANUS("Uranus",R.drawable.uranus),
    NEPTUNE("Neptune",R.drawable.neptune);

    private int id;
    private String name;
    PlanetBank(String planetName, int planetID){
        this.id = planetID;
        this.name = planetName;
    }

    public static PlanetBank getRandomPlanete() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }

    public int getPlanetID(){
        return this.id;
    }

    public String toString(){
        return this.name;
    }
}
