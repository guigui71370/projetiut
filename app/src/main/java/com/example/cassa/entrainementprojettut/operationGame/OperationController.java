package com.example.cassa.entrainementprojettut.operationGame;

import com.example.cassa.entrainementprojettut.operationGame.Operations.I_Operation;
import com.example.cassa.entrainementprojettut.operationGame.SetsOperation.I_SetOperation;

/**
 * Created by clement on 03/01/18.
 */

class OperationController {

    private I_SetOperation setOperation;

    OperationController(int diff) {
        FactorySetOperation factorySetOperation =new FactorySetOperation();
        setOperation=factorySetOperation.createSetOperation(diff);
    }

    char getSigneOperation(){
        return setOperation.getSigneOperation();
    }

    int[] getTermesOperation(){
        int[] termes=new int[2];
        termes[0]=setOperation.getTerme1Operation();
        termes[1]=setOperation.getTerme2Operation();
        return termes;
    }

    boolean checkAnswer(int reponse){
        I_Operation operation=setOperation.getOperation();
        return reponse==operation.displayResult();
    }

    int getAnswer(){
        I_Operation operation=setOperation.getOperation();
        return operation.displayResult();
    }

}
