package com.example.cassa.entrainementprojettut.mysteryWord.word;

/**
 * Created by clement on 05/01/18.
 */

public class WordCM1 extends OutilsWord implements I_Word {

    public WordCM1(String mot) {
        this.mWord = mot;
        codeWord(1);
        mOrder ="Décale les lettres du mot codé de -1 lettre dans l'alphabet pour trouver le mot caché";
    }

    @Override
    public void codeWord(int i) {
        StringBuilder codedWord = new StringBuilder();
        for (char c : mWord.toCharArray())
        {
            c = codeLetterUpward(c, i);
            codedWord.append(c);
        }
        mCodedWord =codedWord.toString();
    }

}
