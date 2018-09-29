package com.example.cassa.entrainementprojettut.mysteryWord.word;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by clement on 05/01/18.
 */
public class WordCM2Test {

    private WordCM2 wordCM2;

    @Test
    public void testFonctionnementStandard() throws Exception {
        wordCM2 = new WordCM2("test");
        StringBuilder codedWord = new StringBuilder();
        for (char c: wordCM2.getWord().toCharArray()) {
            c+=2;
            codedWord.append((char) wordCM2.adjustCharValue(c));
        }
        assertEquals(codedWord.toString(), wordCM2.getCodedWord());
    }

    @Test
    public void TestBouclageDeLalphabet() throws Exception {
        wordCM2 = new WordCM2("yyzy");
        assertEquals(wordCM2.getCodedWord(),"aaba");
    }

}