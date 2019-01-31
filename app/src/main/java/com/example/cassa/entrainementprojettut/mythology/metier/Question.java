package com.example.cassa.entrainementprojettut.mythology.metier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Question {

    private Divinity goodAnswer;
    private ArrayList<Divinity> answers;

    public Question(Divinity divinity, ArrayList<Divinity> listOfBadAnswers){
        goodAnswer = divinity;
        answers = listOfBadAnswers;
        answers.add(divinity);
        Collections.shuffle(answers);
    }

    public boolean isCorrect(String answer ) {
        return answer.equals(goodAnswer.getName());
    }


    public String getHint() {
        return goodAnswer.getText();
    }

    public ArrayList<String> getAnswers() {
        ArrayList<String> stringAnswers = new ArrayList<String>();
        int i = 0;
        while (i<6){
            stringAnswers.add(answers.get(i).getName());
            i++;
        }
        return stringAnswers;
    }

    public int getPicture() {
        return goodAnswer.getPictureId();
    }
}
