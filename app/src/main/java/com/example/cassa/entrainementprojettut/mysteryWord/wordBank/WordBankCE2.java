package com.example.cassa.entrainementprojettut.mysteryWord.wordBank;

import com.example.cassa.entrainementprojettut.mysteryWord.word.I_Word;
import com.example.cassa.entrainementprojettut.mysteryWord.word.WordCE2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clement on 05/01/18.
 */

public class WordBankCE2 extends ToolsWordBank implements I_WordBank {

    private static String longAndNormalWords[] = {"livre", "epine", "ferme", "finir", "fleur", "drole",
            "fusee", "froid", "futur", "soupe", "veste", "jaune", "vivre", "pomme", "hiver", "porte",
            "botte", "chaud", "lampe", "voler", "tasse", "renne", "chien", "chat", "avion", "barbe",
            "aigle", "pelle", "lapin", "jambe", "panda", "pieds", "verre", "genou","vendre", "violet", "voisin", "dauphin", "patate",
            "requin", "baleine", "laitue", "maison", "triangle", "tambour", "sucette", "crayon",
            "poisson", "cercle", "robinet", "fantome", "lunette", "guitare", "canard", "manger",
            "jardin", "volant", "souris", "quatre"};


    public WordBankCE2() {
        generateWordsList();
    }

    @Override
    public void generateWordsList() {

        List<I_Word> words = new ArrayList<>();
        String word;
        List<String> selectedWords=new ArrayList<>();

        while (words.size()<5){
            word = selectWordInList(longAndNormalWords);
            if (alreadySelectedWord(word, selectedWords)) {
                continue;
            }
            words.add(generateWord(word));
            selectedWords.add(word);
        }
        selectedWords.clear();
        this.mWordSet =words;
    }


    private I_Word generateWord(String word) {
        return new WordCE2(word);
    }
}
