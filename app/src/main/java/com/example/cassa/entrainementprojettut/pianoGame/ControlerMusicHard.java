package com.example.cassa.entrainementprojettut.pianoGame;

import com.example.cassa.entrainementprojettut.playerUtils.PlayerLifes;

import java.util.List;

/**
 * Created by clement on 23/01/18.
 */

public class ControlerMusicHard extends IControlerMusic {

    public ControlerMusicHard() {

        lifes=new PlayerLifes();
        List<Note> noteList = generateNotes(20);
        this.music = new Music(noteList);
        size = 4;
        music.generateSequence(size);
        this.positionSequence = 0;
        actualKey = music.getSequence().get(positionSequence);

    }

    ControlerMusicHard(Music music) {
        lifes=new PlayerLifes();
        this.music = music;
        size=4;
        music.generateSequence(size);
        this.positionSequence = 0;
        actualKey = music.getSequence().get(positionSequence);
    }

    protected int goodAnswerConsequences() {
        if (sequenceFinished()) {
            if(!songFinished()){
                generateNewSequence(2);
                return 0;
            }
            return 1;
        }
        else{
            progressSequence();
            return 2;
        }
    }

    @Override
    public int getEndSong() {
        return 20;
    }
}
