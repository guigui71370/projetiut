package com.example.cassa.entrainementprojettut.operationGame.SetsOperation;

import com.example.cassa.entrainementprojettut.operationGame.Operations.I_Operation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by clement on 02/01/18.
 */
public class SetOperationCE1Test {

    private I_SetOperation setOperation;

    @Before
    public void setUp() throws Exception {
        setOperation=new SetOperationCE1();
    }

    @Test
    public void testValiditeSoustraction() throws Exception {
        for (int i = 0; i <1000; i++) {
            I_Operation operation=setOperation.createAnOperation();
            assertEquals(true,operation.displayResult()>=0);
        }
    }

    @Test
    public void createAnOperation() throws Exception {
        for (int i = 0; i < 1000; i++) {
           I_Operation operation=setOperation.createAnOperation();
            assertTrue(operation.displayResult()-3>=0);
        }
    }
}