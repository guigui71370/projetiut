package com.example.cassa.entrainementprojettut.mysteryWord.word;

/**
 * Created by clement on 05/01/18.
 */

public abstract class OutilsWord implements I_Word {

    protected String mWord;
    protected String mCodedWord;
    protected String mOrder;

    public String getWord() {
        return mWord;
    }
    public String getCodedWord() {
        return mCodedWord;
    }
    public String getOrder() {
        return mOrder;
    }

    protected char codeLetterDownward(char c, int i) {
        int ascii=(int)c;
        ascii-=i;
        ascii = adjustCharValue(ascii);
        return (char)ascii;
    }

    protected char codeLetterUpward(char c, int i) {
        int ascii=(int)c;
        ascii+=i;
        ascii = adjustCharValue(ascii);
        return (char)ascii;
    }

    public int adjustCharValue(int ascii) {
        if(ascii > 122){
            ascii = ascii - 26;
        }
        else if(ascii < 97){
            ascii = ascii + 26;
        }
        return ascii;
    }

}
