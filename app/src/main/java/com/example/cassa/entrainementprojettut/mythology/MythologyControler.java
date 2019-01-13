package com.example.cassa.entrainementprojettut.mythology;

import com.example.cassa.entrainementprojettut.mythology.metier.*;

import java.util.ArrayList;

public class MythologyControler {

    private FactorySetMythology factory;
    private I_SetMythology set;
    private Question question;
    private int levelChosen;
    private int currentLevel;
    private int currentTimeInALevel;

    private final static int TIMES_IN_A_LEVEL = 4;


    public MythologyControler(int level) {

        levelChosen = level;
        currentLevel = 1;
        currentTimeInALevel = 0;
        factory = new FactorySetMythology();
        set = factory.createSetMythology(currentLevel);
        question = set.getNextQuestion();

    }

    public boolean isCorrect(String answer) {
        if(answer != null && !answer.isEmpty()){
            return question.isCorrect(answer);
        }
        else return false;
    }

    public boolean nextQuestion() {
        boolean haveNextQuestion = true;
        currentTimeInALevel++;
        if(currentTimeInALevel < TIMES_IN_A_LEVEL){
            question = set.getNextQuestion();
        }
        else{
            currentLevel++;
            if(currentLevel <= levelChosen){
                set = factory.createSetMythology(currentLevel);
                question = set.getNextQuestion();
            }
            else {
                haveNextQuestion = false;
            }
        }

        return haveNextQuestion;

    }

    public String getHint() {
        return question.getHint();
    }

    public ArrayList<String> getAnswers() {
        return question.getAnswers();
    }

}
