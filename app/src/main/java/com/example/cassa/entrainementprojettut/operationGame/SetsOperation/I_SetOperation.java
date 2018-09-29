package com.example.cassa.entrainementprojettut.operationGame.SetsOperation;

import com.example.cassa.entrainementprojettut.operationGame.Operations.I_Operation;

/**
 * Created by clement on 02/01/18.
 */

public interface I_SetOperation {

    I_Operation createAnOperation();

    I_Operation getOperation();

    int getTerme1Operation();

    int getTerme2Operation();

    char getSigneOperation();

}
