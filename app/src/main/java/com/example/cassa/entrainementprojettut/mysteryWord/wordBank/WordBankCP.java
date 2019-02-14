package com.example.cassa.entrainementprojettut.mysteryWord.wordBank;

import com.example.cassa.entrainementprojettut.mysteryWord.word.I_Word;
import com.example.cassa.entrainementprojettut.mysteryWord.word.WordCP;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clement on 04/01/18.
 */

public class WordBankCP extends ToolsWordBank implements I_WordBank {

    private static String shortWords[] = {"film", "doux", "defi", "flou", "fond", "epis", "epee",
            "fete", "fil", "gris", "bleu", "loup", "lune", "dent", "chez", "cent", "sol", "toi",
            "roinoir", "cle", "six", "coq", "dos", "jus", "ici", "lit", "vis", "noir", "sac", "kiwi",
            "huit", "cube", "robe", "ours", "rue", "bras", "main", "bus", "nez", "rire"};


    public WordBankCP() {
        generateWordsList();
    }


    protected I_Word genererMot(String word) {

        return new WordCP(word);
    }

    @Override
    public void generateWordsList() {
        List<I_Word> words = new ArrayList<>();
        String word;
        List<String> selectedWords=new ArrayList<>();

        while (words.size()<5){
            word = selectWordInList(shortWords);
            if (alreadySelectedWord(word, selectedWords)) {
                continue;
            }
            words.add(genererMot(word));
            selectedWords.add(word);
        }
        selectedWords.clear();
        this.mWordSet =words;
    }
}
