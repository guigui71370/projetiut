package com.example.cassa.entrainementprojettut.operationGame.SetsOperation;

import android.support.annotation.NonNull;

import com.example.cassa.entrainementprojettut.operationGame.Operations.Addition;
import com.example.cassa.entrainementprojettut.operationGame.Operations.I_Operation;
import com.example.cassa.entrainementprojettut.operationGame.Operations.Multiplication;
import com.example.cassa.entrainementprojettut.operationGame.Operations.Soustraction;

/**
 * Created by clement on 02/01/18.
 */

public class SetOperationCE2 implements I_SetOperation {

    private I_Operation operation;

    public SetOperationCE2() {
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
        I_Operation operation;
        int operateur=(int)(Math.random() * (3) + 1);
        switch (operateur){
            case 1:
                operation= generateAddition();
                break;
            case 2:
                operation= generateSoustraction();
                break;
            case 3:
                operation = generateSimpleMultiplication();
                break;
            default:
                operation= generateAddition();
                break;
        }

        return operation;
    }

    @NonNull
    private I_Operation generateSimpleMultiplication() {
        int terme1= generateSimpleNumbers();
        Multiplication multiplication=new Multiplication();
        while (multiplication.displayResult()<3){
            multiplication.generateOperation(terme1,10,1);
        }
        return multiplication;
    }

    private int generateSimpleNumbers() {
        int tabProduit[] = new int[4];
        tabProduit[1] = 2;
        tabProduit[2] = 5;
        tabProduit[3] = 10;

        return tabProduit[(int)(Math.random() * (3) + 1)];
    }

    private void generatePositiveOperation(I_Operation addition) {
        while (addition.displayResult()<3){
            addition.generateOperation(10,1,10,1);
        }
    }

    @NonNull
    public I_Operation generateSoustraction() {
        Soustraction soustraction=new Soustraction();
        generatePositiveOperation(soustraction);
        return soustraction;
    }

    @NonNull
    public I_Operation generateAddition() {
        Addition addition=new Addition();
        generatePositiveOperation(addition);
        return addition;
    }
}