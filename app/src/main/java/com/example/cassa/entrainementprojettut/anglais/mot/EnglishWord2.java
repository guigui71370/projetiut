package com.example.cassa.entrainementprojettut.anglais.mot;

import com.example.cassa.entrainementprojettut.R;

public enum EnglishWord2 {
    MANGER("Eat","Manger", R.raw.eat),
    FRERE("Brother","Frère",R.raw.brother),
    SOEUR("Sister","Soeur",R.raw.sister),
    MAMAN("Mother","Maman",R.raw.mother),
    PAPA("Father","Papa",R.raw.father),
    CHIEN("Dog","Chien",R.raw.dog),
    CHAT("Cat","Chat",R.raw.cat),
    ETOILE("Star","Étoile",R.raw.star),
    COCHON("Pig","Cochon",R.raw.pig),
    UN("One","Un",R.raw.one),
    DEUX("Two","Deux",R.raw.two),
    TROIS("Three","Trois",R.raw.three),
    QUATRE("Four","Quatre",R.raw.four),
    CINQ("Five","Cinq",R.raw.five),
    SIX("Six","Six",R.raw.six),
    SEPT("Seven","Sept",R.raw.seven),
    HUIT("Eight","Huit",R.raw.eight),
    NEUF("Nine","Neuf",R.raw.nine),
    DIX("Ten","Dix",R.raw.ten),
    MUSIQUE("Song","Chanson",R.raw.song),
    ECOUTER("Listen","Écouter",R.raw.listen),
    MAISON("House","Maison",R.raw.house),
    SOLEIL("Sun","Soleil",R.raw.sun),
    EAU("Water","Eau",R.raw.water),
    BOIRE("Drink","Boire",R.raw.drink),
    DESSINER("Draw","Dessiner",R.raw.draw),
    BONJOUR("Hello","Bonjour",R.raw.hello),
    AUREVOIR("Goodbye","Au revoir",R.raw.goodbye),
    ROUGE("Red","Rouge",R.raw.red),
    VERT("Green","Vert",R.raw.green),
    BLEU("Blue","Bleu",R.raw.blue),
    ORANGE("Orange","Orange",R.raw.orange),
    MARRON("Brown","Marron",R.raw.brown),
    JAUNE("Yellow","Jaune",R.raw.yellow),
    BLANC("White","Blanc",R.raw.white),
    NOIR("Black","NOIR",R.raw.black),
    GRIS("Gray","Gris",R.raw.grey);






    private int idWord;


    String Word;

    String traduction;


    EnglishWord2(String Word, String traduction,int song) {
        this.Word = Word;
        this.idWord=song;
        this.traduction = traduction;
    }


    public int getIdWord() {
        return idWord;
    }

    public void setIdWord(int idWord) {
        this.idWord = idWord;
    }


    public String getEnglishWord() {
        return Word;
    }

    public void setEnglishWord( String englishWord) {
        this.Word = englishWord;
    }


    public String getTraduction() {
        return traduction;
    }

    public void setTraduction( String traduction) {
        this.traduction = traduction;
    }
}
