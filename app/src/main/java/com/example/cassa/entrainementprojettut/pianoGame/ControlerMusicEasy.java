package com.example.cassa.entrainementprojettut.pianoGame;


import com.example.cassa.entrainementprojettut.playerUtils.PlayerLifes;
import java.util.List;

/**
 * Created by LeBoss on 16/01/2018.
 */

public class ControlerMusicEasy extends IControlerMusic {


    public ControlerMusicEasy() {

        lifes=new PlayerLifes();
        List<Note> noteList = generateNotes(8);
        this.music = new Music(noteList);
        size = 3;
        music.generateSequence(size);
        this.positionSequence = 0;
        actualKey = music.getSequence().get(positionSequence);

    }

    ControlerMusicEasy(Music music) {
        lifes=new PlayerLifes();
        this.music = music;
        size=3;
        music.generateSequence(size);
        this.positionSequence = 0;
        actualKey = music.getSequence().get(positionSequence);
    }

    protected int goodAnswerConsequences() {
        if (sequenceFinished()) {
            if(!songFinished()){
                generateNewSequence(1);
                return 0;
            }
            return 1;
        }
        else{
            progressSequence();
            return 2;
        }
    }


}
