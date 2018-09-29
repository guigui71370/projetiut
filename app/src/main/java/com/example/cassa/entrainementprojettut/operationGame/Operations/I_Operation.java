package com.example.cassa.entrainementprojettut.operationGame.Operations;

/**
 * Created by clement on 02/01/18.
 */

public interface I_Operation {

    int getTerme1();
    int getTerme2();
    char getSigne();

    void generateOperation(int maxValueTerme1, int minValueTerme1, int maxValueTerme2, int minValueTerme2);

    int displayResult();

    int generateRandomNumber(int maxValue, int minValue);

}
