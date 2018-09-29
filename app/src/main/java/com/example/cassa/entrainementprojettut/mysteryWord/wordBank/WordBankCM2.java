package com.example.cassa.entrainementprojettut.mysteryWord.wordBank;

import com.example.cassa.entrainementprojettut.mysteryWord.word.I_Word;
import com.example.cassa.entrainementprojettut.mysteryWord.word.WordCM2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clement on 05/01/18.
 */

public class WordBankCM2 extends ToolsWordBank implements I_WordBank {

    private static String longWords[] = {"vendre", "violet", "voisin", "dauphin", "patate",
            "requin", "baleine", "laitue", "maison", "triangle", "tambour", "sucette", "crayon",
            "poisson", "cercle", "robinet", "fantome", "lunette", "guitare", "canard", "manger",
            "jardin", "volant", "souris", "quatre"};

    public WordBankCM2() {
        generateWordsList();
    }

    @Override
    public void generateWordsList() {

        List<I_Word> words = new ArrayList<>();
        String word;
        List<String> selectedWords=new ArrayList<>();

        while (words.size()<5){
            word = selectWordInList(longWords);
            if (alreadySelectedWord(word, selectedWords)) {
                continue;
            }
            words.add(generateWords(word));
            selectedWords.add(word);
        }
        selectedWords.clear();
        this.mWordSet =words;
    }


    private I_Word generateWords(String words) {
        return new WordCM2(words);
    }
}
