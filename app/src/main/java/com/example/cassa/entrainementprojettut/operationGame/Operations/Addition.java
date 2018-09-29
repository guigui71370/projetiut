package com.example.cassa.entrainementprojettut.operationGame.Operations;

/**
 * Created by clement on 02/01/18.
 */

public class Addition implements I_Operation {

    private int terme1;
    private int terme2;
    private char signe='+';

    @Override
    public char getSigne() {
        return signe;
    }

    @Override
    public int getTerme1() {
        return terme1;
    }

    @Override
    public int getTerme2() {
        return terme2;
    }

    @Override
    public void generateOperation(int maxValueTerme1, int minValueTerme1, int maxValueTerme2, int minValueTerme2) {
        this.terme1= generateRandomNumber(maxValueTerme1, minValueTerme1);
        this.terme2= generateRandomNumber(maxValueTerme2, minValueTerme2);
    }


    public int displayResult(){
        return terme1+terme2;
    }

    @Override
    public int generateRandomNumber(int maxValue, int minValue){

        int nombre = (int)(Math.random() * (maxValue) + minValue);

        return nombre;
    }

}
