package com.example.cassa.entrainementprojettut.anglais.mot;

public enum EnglishWord2 {
    MANGER("Eat","Manger",0),
    FRERE("Brother","Frère",0),
    SOEUR("Sister","Soeur",0),
    MAMAN("Mother","Maman",0),
    PAPA("Dad","Papa",0),
    CHIEN("Dog","Chien",0),
    CHAT("Cat","Chat",0),
    ETOILE("Star","Étoile",0),
    COCHON("Pig","Cochon",0),
    UN("One","Un",0),
    DEUX("Two","Deux",0),
    TROIS("Three","Trois",0),
    QUATRE("Four","Quatre",0),
    CINQ("Five","Cinq",0),
    SIX("Six","Six",0),
    SEPT("Seven","Sept",0),
    HUIT("Eight","Huit",0),
    NEUF("Nine","Neuf",0),
    DIX("Ten","Dix",0),
    MUSIQUE("Song","Musique",0),
    ECOUTER("Listen","Écouter",0),
    MAISON("House","Maison",0),
    SOLEIL("Sun","Soleil",0),
    EAU("Water","Eau",0),
    BOIRE("Drink","Boire",0),
    DESSINER("Draw","Dessiner",0),
    BONJOUR("Hello","Bonjour",0),
    AUREVOIR("Goodbye","Au revoir",0),
    ;






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
