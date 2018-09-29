package com.example.cassa.entrainementprojettut.operationGame;

import com.example.cassa.entrainementprojettut.operationGame.SetsOperation.I_SetOperation;
import com.example.cassa.entrainementprojettut.operationGame.SetsOperation.SetOperationCE1;
import com.example.cassa.entrainementprojettut.operationGame.SetsOperation.SetOperationCE2;
import com.example.cassa.entrainementprojettut.operationGame.SetsOperation.SetOperationCM1;
import com.example.cassa.entrainementprojettut.operationGame.SetsOperation.SetOperationCM2;
import com.example.cassa.entrainementprojettut.operationGame.SetsOperation.SetOperationCP;

/**
 * Created by clement on 09/01/18.
 */

public class FactorySetOperation {

    public I_SetOperation createSetOperation(int difficulty) {
        I_SetOperation setOperation;
        switch (difficulty){
            case 1:
                setOperation=new SetOperationCP();
                break;
            case 2:
                setOperation=new SetOperationCE1();
                break;
            case 3:
                setOperation=new SetOperationCE2();
                break;
            case 4:
                setOperation=new SetOperationCM1();
                break;
            default:
                setOperation=new SetOperationCM2();
                break;
        }
        return setOperation;
    }
}
