package com.example.cassa.entrainementprojettut.mysteryWord.word;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by clement on 05/01/18.
 */
public class WordCE2Test {

    private WordCE2 wordCE2;

    @Test
    public void testFonctionnementStandard() throws Exception {
        wordCE2 = new WordCE2("test");
        StringBuilder codedWord = new StringBuilder();
        for (char c: wordCE2.getWord().toCharArray()) {
            c-=3;
            codedWord.append((char) wordCE2.adjustCharValue(c));
        }
        assertEquals(codedWord.toString(), wordCE2.getCodedWord());
    }

    @Test
    public void TestBouclageDeLalphabet() throws Exception {
        wordCE2 = new WordCE2("cdcc");
        assertEquals(wordCE2.getCodedWord(),"zazz");
    }

}