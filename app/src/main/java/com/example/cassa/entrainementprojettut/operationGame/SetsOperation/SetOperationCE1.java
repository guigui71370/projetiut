package com.example.cassa.entrainementprojettut.operationGame.SetsOperation;

import com.example.cassa.entrainementprojettut.operationGame.Operations.Addition;
import com.example.cassa.entrainementprojettut.operationGame.Operations.I_Operation;
import com.example.cassa.entrainementprojettut.operationGame.Operations.Soustraction;

/**
 * Created by clement on 02/01/18.
 */

public class SetOperationCE1 implements I_SetOperation {

    private I_Operation operation;

    public SetOperationCE1() {
        this.operation = createAnOperation();
    }

    public I_Operation getOperation() {
        return operation;
    }

    @Override
    public int getTerme1Operation() {
        return operation.getTerme1();
    }

    @Override
    public int getTerme2Operation() {
        return operation.getTerme2();
    }

    @Override
    public char getSigneOperation() {
        return operation.getSigne();
    }

    @Override
    public I_Operation createAnOperation() {
        int operateur=(int)(Math.random() * (2) + 1);
        if(operateur==1){
            return generateAddition();
        }else{
            return generateSoustraction();
        }
    }

    private I_Operation generateAddition() {
        Addition addition=new Addition();
        generatePositiveOperation(addition);
        return addition;
    }

    private void generatePositiveOperation(I_Operation addition) {
        while (addition.displayResult()<3){
            addition.generateOperation(10,1,10,1);
        }
    }

    private I_Operation generateSoustraction() {
        Soustraction soustraction=new Soustraction();
        generatePositiveOperation(soustraction);
        return soustraction;
    }
}
