package com.example.cassa.entrainementprojettut.pianoGame;

import com.example.cassa.entrainementprojettut.playerUtils.PlayerLifes;
import java.util.List;

/**
 * Created by LeBoss on 07/02/2018.
 */

public class ControlerMusicScore extends IControlerMusic {

    private int endSong = 6;

    public ControlerMusicScore() {
        lifes=new PlayerLifes();
        List<Note> noteList = generateNotes(endSong);
        this.music = new Music(noteList);
        size = 3;
        music.generateSequence(size);
        this.positionSequence = 0;
        actualKey = music.getSequence().get(positionSequence);
    }

    public ControlerMusicScore(Music music){
        lifes=new PlayerLifes();
        this.music = music;
        size=3;
        music.generateSequence(size);
        this.positionSequence = 0;
        actualKey = music.getSequence().get(positionSequence);
    }

    @Override
    public boolean songFinished(){
        boolean end = music.musicEnded(endSong);
        if (end)
            endSong = 0;
        return end;
    }

    protected int goodAnswerConsequences() {
        if (sequenceFinished()) {
            if(!songFinished()){
                generateNewSequence(1);
                return 0;
            }
            return 0;
        }
        else{
            progressSequence();
            return 2;
        }
    }

    @Override
    public String controlerType() {
        return "score";
    }

    @Override
    public int getEndSong(){
        return endSong;
    }
}
