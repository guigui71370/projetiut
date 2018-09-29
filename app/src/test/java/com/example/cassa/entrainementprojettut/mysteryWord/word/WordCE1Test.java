package com.example.cassa.entrainementprojettut.mysteryWord.word;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by clement on 05/01/18.
 */
public class WordCE1Test {

    private WordCE1 wordCE1;

    @Test
    public void testFonctionnementStandard() throws Exception {
        wordCE1 =new WordCE1("test");
        StringBuilder codedWord = new StringBuilder();
        for (char c: wordCE1.getWord().toCharArray()) {
            c-=2;
            codedWord.append((char) wordCE1.adjustCharValue(c));
        }
        assertEquals(codedWord.toString(), wordCE1.getCodedWord());
    }

    @Test
    public void TestBouclageDeLalphabet() throws Exception {
        wordCE1 =new WordCE1("bcbb");
        assertEquals(wordCE1.getCodedWord(),"zazz");
    }

}