package com.example.cassa.entrainementprojettut.mysteryWord.word;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by clement on 04/01/18.
 */
public class WordCPTest {

    private WordCP wordCP;

    @Test
    public void testFonctionnementStandard() throws Exception {
        wordCP =new WordCP("test");
        StringBuilder codedWord = new StringBuilder();
        for (char c: wordCP.getWord().toCharArray()) {
            c-=1;
            codedWord.append((char) wordCP.adjustCharValue(c));
        }
        assertEquals(codedWord.toString(), wordCP.getCodedWord());
    }

    @Test
    public void TestBouclageDeLalphabet() throws Exception {
        wordCP =new WordCP("abaa");
        assertEquals(wordCP.getCodedWord(),"zazz");
    }
}