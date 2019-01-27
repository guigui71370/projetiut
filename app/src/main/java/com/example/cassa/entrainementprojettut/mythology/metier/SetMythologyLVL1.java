package com.example.cassa.entrainementprojettut.mythology.metier;

import java.util.ArrayList;
import java.util.Random;

class SetMythologyLVL1 implements I_SetMythology {

    private ArrayList<Divinity> list;
    private Random r;
    private Divinity lastOne;

    public SetMythologyLVL1(){
        list = new ArrayList<Divinity>();
        list.add(Divinity.ZEUS);
        list.add(Divinity.POSEIDON);
        list.add(Divinity.HADES);
        list.add(Divinity.ATHENA);
        list.add(Divinity.APHRODITE);
        list.add(Divinity.HERMES);

        r = new Random();
    }

    @Override
    public Question getNextQuestion() {
        Divinity goodAnswer;
        ArrayList<Divinity> badAnswers = new ArrayList<Divinity>(list);
        int index = r.nextInt(list.size());
        goodAnswer = badAnswers.get(index);
        badAnswers.remove(index);
        if(lastOne==null || !lastOne.equals(goodAnswer)) {
            lastOne = goodAnswer;
            return new Question(goodAnswer, badAnswers);
        }
        else return getNextQuestion();
    }
}
