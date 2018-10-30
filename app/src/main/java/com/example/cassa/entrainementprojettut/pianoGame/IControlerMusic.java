package com.example.cassa.entrainementprojettut.pianoGame;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

import com.example.cassa.entrainementprojettut.R;
import com.example.cassa.entrainementprojettut.playerUtils.PlayerLifes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clement on 23/01/18.
 */

public abstract class IControlerMusic {

    Music music;
    Note actualKey;
    PlayerLifes lifes;
    int positionSequence;
    protected int size;

    public int checkKey(int id){
        int res;
        if (correctKey(id)){
            res= goodAnswerConsequences();
        }
        else{
            res=-1;
            falseAnswerConsequences();
        }
        return res;
    }

    public void falseAnswerConsequences() {
        if(!isDead()) {
            lifes.loseLife();
            resetSequence();
        }
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

    private boolean correctKey(int id) {
        return id == actualKey.getId();
    }

    protected void generateNewSequence(int augmentation) {
        size += augmentation;
        music.generateSequence(size);
        positionSequence=0;
        actualKey = music.getSequence().get(0);
    }

    public boolean isDead() {
        return lifes.isDead();
    }

    protected boolean sequenceFinished() {
        return positionSequence+1 == music.getPosition();
    }

    protected void progressSequence() {
        positionSequence++;
        actualKey = music.getSequence().get(positionSequence);
    }

    private void resetSequence() {
        positionSequence = 0;
        actualKey = music.getSequence().get(positionSequence);
    }

    public boolean songFinished(){
        return music.musicEnded();
    }

    public List<Integer> getIdSequence(){
        List<Integer> listId = new ArrayList<>();
        List<Note> sequence = music.getSequence();
        for(int i=0; i<sequence.size(); i++){
            Note note = sequence.get(i);
            int id = note.getId();
            listId.add(id);
        }
        return  listId;
    }

    protected List<Note> generateNotes(int quantityOfNotes) {
        List<Note>notes=new ArrayList<>();
        for (int i = 1; i <=quantityOfNotes ; i++) {
            Note note=new Note((int)(Math.random() * (7) + 1),0);
            notes.add(note);
        }
        return notes;
    }

    @NonNull
    private Note[] getNotesTab() {
        Note noteDo = new Note(1, R.raw.note_do);
        Note noteRe = new Note(2, R.raw.note_re);
        Note noteMi = new Note(3, R.raw.note_mi);
        Note noteFa = new Note(4, R.raw.note_fa);
        Note noteSol= new Note(5, R.raw.note_sol);
        Note noteLa = new Note(6, R.raw.note_la);
        Note noteSi = new Note(7, R.raw.note_si);

        return new Note[]{noteDo, noteRe, noteMi, noteFa, noteSol, noteLa, noteSi};
    }

    public void playSong(Activity activity, View view){
        String tmp = (String) view.getTag();
        int key = Integer.parseInt(tmp)-1;
        Note notesTab[] = getNotesTab();
        notesTab[key].playSong(activity);
    }

    public void setLife(ImageView imageView) {
        imageView.setImageResource(R.drawable.empty_heart);
    }

    public String controlerType(){
        return "normal";
    }

    public int getSequenceSize(){
        return music.getSequence().size();
    }

    public int getEndSong(){
        return 8;
    }
}
