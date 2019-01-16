package com.example.cassa.entrainementprojettut.mythology.metier;

import java.util.ArrayList;
import java.util.Random;

class SetMythologyLVL2 implements I_SetMythology {

    private ArrayList<Divinity> list;
    private Random r;
    private Divinity lastOne;

    public SetMythologyLVL2(){
        list = new ArrayList<Divinity>();
        list.add(Divinity.APOLLON);
        list.add(Divinity.ARTEMIS);
        list.add(Divinity.ARES);
        list.add(Divinity.HERA);
        list.add(Divinity.HEPHAISTOS);
        list.add(Divinity.DIONYSOS);

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
