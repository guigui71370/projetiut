package com.example.cassa.entrainementprojettut.pianoGame;

import android.util.Log;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by clement on 17/01/18.
 */
public class ControlerMusicTest {

    private IControlerMusic controlerMusic ;
    private List<Note> notes=new ArrayList<>();

    @Before
    public void setUp() throws Exception {


        Note note=new Note(1,0);
        notes.add(note);
        note=new Note(2,0);
        notes.add(note);
        note=new Note(3,0);
        notes.add(note);
        note=new Note(4,0);
        notes.add(note);

        Music music=new Music(notes);

        controlerMusic=new ControlerMusicEasy(music);
    }

    @Test
    public void noteSaisieOk() throws Exception {
        assertEquals(2, controlerMusic.checkKey(1));
    }

    @Test
    public void noteSaisieFalse() throws Exception {
        assertEquals(-1, controlerMusic.checkKey(3));
    }

    @Test
    public void sequenceProgress() throws Exception {
        controlerMusic.checkKey(1);
        assertEquals(controlerMusic.actualKey, notes.get(1));
    }

    @Test
    public void sequenceReboot() throws Exception {
        controlerMusic.checkKey(1);
        controlerMusic.checkKey(2);
        controlerMusic.checkKey(4);
        assertEquals(controlerMusic.actualKey, notes.get(0));
    }

    @Test
    public void sequenceFinishedReboot() throws Exception {
        finishFirstSequence();
        assertEquals(controlerMusic.actualKey, notes.get(0));
    }

    public void finishFirstSequence() {
        controlerMusic.checkKey(1);
        controlerMusic.checkKey(2);
        controlerMusic.checkKey(3);
    }

    @Test
    public void sequenceSizeAugmented() throws Exception {
        finishFirstSequence();
        assertEquals(4,controlerMusic.music.getSequence().size());
    }

    @Test
    public void finishSong() throws Exception {
        finishFirstSequence();
        finishFirstSequence();
        controlerMusic.checkKey(4);
        assertTrue(controlerMusic.songFinished());
    }

}