package com.example.cassa.entrainementprojettut.mysteryWord;

import com.example.cassa.entrainementprojettut.mysteryWord.wordBank.I_WordBank;
import com.example.cassa.entrainementprojettut.mysteryWord.wordBank.WordBankCE1;
import com.example.cassa.entrainementprojettut.mysteryWord.wordBank.WordBankCE2;
import com.example.cassa.entrainementprojettut.mysteryWord.wordBank.WordBankCM1;
import com.example.cassa.entrainementprojettut.mysteryWord.wordBank.WordBankCM2;
import com.example.cassa.entrainementprojettut.mysteryWord.wordBank.WordBankCP;

/**
 * Created by clement on 04/01/18.
 */

public class FactoryWordBank {



    public I_WordBank createI_WordBank(int difficulte) {
        I_WordBank wordBank;
        switch (difficulte) {
            case 1:
                wordBank= new WordBankCP();
                break;
            case 2:
                wordBank= new WordBankCE1();
                break;
            case 3:
                wordBank= new WordBankCE2();
                break;
            case 4:
                wordBank= new WordBankCM1();
                break;
            default:
                wordBank= new WordBankCM2();
                break;
        }
        return wordBank;
    }
}
