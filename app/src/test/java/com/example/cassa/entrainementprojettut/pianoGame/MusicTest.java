package com.example.cassa.entrainementprojettut.pianoGame;

import android.support.annotation.NonNull;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by clement on 16/01/18.
 */
public class MusicTest {

    private Music music;
    private List<Note> notes;

    private void createMusic() {
        notes = generateNotes();
        music=new Music(notes);

    }

    @NonNull
    private List<Note> generateNotes() {
        List<Note>notes=new ArrayList<>();
        for (int i = 0; i <100 ; i++) {
            Note note=new Note((int)(Math.random() * (7) + 1),0);
            notes.add(note);
        }
        return notes;
    }

    @Before
    public void setUp() throws Exception {
        createMusic();
    }

    @Test
    public void testSizeSequenceGenerated() throws Exception {
        List<Note>sequence=music.generateSequence(2);
        assertTrue(sequence.size()==2);
    }

    @Test
    public void testValueGeneratedSequence() throws Exception {
        List<Note>sequence=music.generateSequence(2);
        for (int i = 0; i < sequence.size(); i++) {
            assertTrue(sequence.get(i)==notes.get(i));
        }
    }

    @Test
    public void testIncrementSequenceSize() throws Exception {
        music.generateSequence(2);
        List<Note>sequence=music.incrementSequence(1);
        assertEquals(3,sequence.size());
    }

    @Test
    public void testIncrementSequenceValue() throws Exception {
        music.generateSequence(2);
        List<Note>sequence=music.incrementSequence(1);
        for (int i = 0; i < sequence.size(); i++) {
            assertEquals(sequence.get(i), notes.get(i));
        }
    }
}