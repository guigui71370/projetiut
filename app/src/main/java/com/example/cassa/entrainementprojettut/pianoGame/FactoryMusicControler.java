package com.example.cassa.entrainementprojettut.pianoGame;

/**
 * Created by clement on 23/01/18.
 */

public class FactoryMusicControler {

    public static IControlerMusic createControlerMusic(int diff){
        switch (diff){
            case 1:
                return new ControlerMusicEasy();
            case 2:
                return new ControlerMusicNormal();
            case 3:
                return new ControlerMusicHard();
            case 4:
                return new ControlerMusicScore();
            default:
                return new ControlerMusicEasy();
        }
    }
}
