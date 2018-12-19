package com.example.cassa.entrainementprojettut.mysteryWord.word;

/**
 * Created by clement on 05/01/18.
 */

public class WordCM2 extends OutilsWord implements I_Word {

    public WordCM2(String mot) {
        this.mWord = mot;
        codeWord(2);
        mOrder ="Décale les lettres du mot codé de -2 lettre dans l'alphabet pour trouver le mot caché";
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
