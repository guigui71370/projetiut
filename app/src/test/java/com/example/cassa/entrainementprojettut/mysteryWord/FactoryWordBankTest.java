package com.example.cassa.entrainementprojettut.mysteryWord;

import com.example.cassa.entrainementprojettut.mysteryWord.word.WordCE1;
import com.example.cassa.entrainementprojettut.mysteryWord.word.WordCE2;
import com.example.cassa.entrainementprojettut.mysteryWord.word.WordCM1;
import com.example.cassa.entrainementprojettut.mysteryWord.word.WordCM2;
import com.example.cassa.entrainementprojettut.mysteryWord.word.WordCP;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by clement on 09/01/18.
 */
public class FactoryWordBankTest {

    private WordBankController wordBankController;



    @Test
    public void testGenerationCP() throws Exception {
        wordBankController =new WordBankController(1);
        assertEquals(wordBankController.getWord(0).getClass(), WordCP.class);
    }
    @Test
    public void testGenerationCE1() throws Exception {
        wordBankController =new WordBankController(2);
        assertEquals(wordBankController.getWord(0).getClass(), WordCE1.class);
    }
    @Test
    public void testGenerationCE2() throws Exception {
        wordBankController =new WordBankController(3);
        assertEquals(wordBankController.getWord(0).getClass(), WordCE2.class);
    }
    @Test
    public void testGenerationCM1() throws Exception {
        wordBankController =new WordBankController(4);
        assertEquals(wordBankController.getWord(0).getClass(), WordCM1.class);
    }
    @Test
    public void testGenerationCM2() throws Exception {
        wordBankController =new WordBankController(5);
        assertEquals(wordBankController.getWord(0).getClass(), WordCM2.class);
    }

}