package com.example.cassa.entrainementprojettut.anglais.mot;

public enum EnglishWord2 {
    MANGER("eat","manger",0),
    FRERE("brother","frère",0),
    SOEUR("sister","soeur",0),
    MAMAN("mother","maman",0),
    PAPA("dad","papa",0),
    CHIEN("dog","chien",0),
    CHAT("cat","chat",0),
    ETOILE("star","étoile",0),
    COCHON("pig","cochon",0),
    UN("one","un",0),
    DEUX("two","deux",0),
    TROIS("three","trois",0),
    QUATRE("four","quatre",0),
    CINQ("five","cinq",0),
    SIX("six","six",0),
    SEPT("seven","sept",0),
    HUIT("height","huit",0),
    NEUF("nine","neuf",0),
    DIX("ten","dix",0),
    MUSIQUE("song","musique",0),
    ECOUTER("listen","ecouter",0),
    MAISON("house","maison",0),
    SOLEIL("sun","soleil",0),
    EAU("water","eau",0),
    BOIRE("drink","boire",0),
    DESSINER("draw","dessiner",0),
    BONJOUR("hello","bonjour",0),
    AUREVOIR("good bye","aurevoir",0),
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
