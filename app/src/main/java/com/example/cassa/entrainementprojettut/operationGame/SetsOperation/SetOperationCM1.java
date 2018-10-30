package com.example.cassa.entrainementprojettut.operationGame.SetsOperation;

import android.support.annotation.NonNull;

import com.example.cassa.entrainementprojettut.operationGame.Operations.Addition;
import com.example.cassa.entrainementprojettut.operationGame.Operations.I_Operation;
import com.example.cassa.entrainementprojettut.operationGame.Operations.Multiplication;
import com.example.cassa.entrainementprojettut.operationGame.Operations.Soustraction;



/**
 * Created by clement on 02/01/18.
 */

public class SetOperationCM1 implements I_SetOperation {

    private I_Operation operation;

    public SetOperationCM1() {
        this.operation = createAnOperation();
    }

    public I_Operation getOperation() {
        return this.operation;
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
        I_Operation operation;
        int operateur=(int)(Math.random() * (4) + 1);
        if(operateur>2){
            operation= generateMultiplication();
        }else operation = generateRandomOperationButMultiplication(operateur);
        return operation;
    }

    private I_Operation generateMultiplication() {
        Multiplication multiplication=new Multiplication();
        generatePositiveOperation(multiplication);
        return multiplication;
    }

    @NonNull
    private I_Operation generateRandomOperationButMultiplication(int operator) {
        I_Operation operation;
        if(operator==2){
            operation= generateSoustraction();
        }else{
            operation= generateAddition();
        }
        return operation;
    }


    private void generatePositiveOperation(I_Operation addition) {
        while (addition.displayResult()<3){
            addition.generateOperation(10,1,10,1);
        }
    }

    @NonNull
    private I_Operation generateSoustraction() {
        Soustraction soustraction=new Soustraction();
        generatePositiveOperation(soustraction);
        return soustraction;
    }

    @NonNull
    private I_Operation generateAddition() {
        Addition addition=new Addition();
        while (addition.displayResult()<3) {
            addition.generateOperation(12, 1, 12, 1);
        }
        return addition;
    }
}
