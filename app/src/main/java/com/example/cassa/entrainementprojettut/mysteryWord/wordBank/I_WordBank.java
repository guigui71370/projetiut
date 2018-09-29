package com.example.cassa.entrainementprojettut.mysteryWord.wordBank;


import com.example.cassa.entrainementprojettut.mysteryWord.word.I_Word;

import java.util.List;

/**
 * Created by clement on 04/01/18.
 */

public interface I_WordBank {

    List<I_Word> getWordSet();

    void generateWordsList();

}
