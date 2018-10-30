package com.example.cassa.entrainementprojettut.pianoGame;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clement on 16/01/18.
 */

public class Music {

    private List<Note> notes;
    private List<Note> sequence;
    private int position;

    public Music(List<Note> notes) {
        this.notes = notes;
        this.sequence=new ArrayList<>();
        this.position = 0;
    }

    public List<Note> generateSequence(int size){
        sequence.clear();
        if (size>notes.size())
            addRandomNote();

        for (int j = 0; j <size ; j++) {
            sequence.add(notes.get(j));
        }
        position=size;
        return sequence;
    }

    public void addRandomNote(){
        notes.add(new Note((int)(Math.random() * (7) + 1),0));
    }

    public List<Note> incrementSequence(int i) {
        for (int j = position; j <position+i ; j++) {
            sequence.add(notes.get(j));
        }
        position+=i;
        return sequence;
    }

    public List<Note> getSequence() {
        return sequence;
    }

    public int getPosition() {
        return position;
    }

    public boolean musicEnded(){
        System.out.println("notes: "+notes.size() + " sequence: "+sequence.size());
        return notes.size()==sequence.size();
    }

    public boolean musicEnded(int size){
        return sequence.size()== size;
    }

}
