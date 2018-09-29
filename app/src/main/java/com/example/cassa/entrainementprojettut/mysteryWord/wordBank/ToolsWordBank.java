package com.example.cassa.entrainementprojettut.mysteryWord.wordBank;

import com.example.cassa.entrainementprojettut.mysteryWord.word.I_Word;

import java.util.List;

/**
 * Created by clement on 05/01/18.
 */

public abstract class ToolsWordBank implements I_WordBank {

    protected List<I_Word> mWordSet;

    public List<I_Word> getWordSet() {
        return mWordSet;
    }

    protected boolean alreadySelectedWord(String word, List<String> selectedWord) {
        return selectedWord.contains(word);
    }

    public String selectWordInList(String[] wordList) {
        String word;
        word = wordList[(generateNumber(wordList.length - 1,0))];
        return word;
    }

    public int generateNumber(int borneSup, int borneInf){

        int nombre = (int)(Math.random() * (borneSup) + borneInf);

        return nombre;
    }

}
