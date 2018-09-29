package com.example.cassa.entrainementprojettut.operationGame.SetsOperation;

import com.example.cassa.entrainementprojettut.operationGame.Operations.I_Operation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by clement on 02/01/18.
 */
public class SetIoperationCPTest {

    private SetOperationCP setOperationCP;

    @Before
    public void setUp() throws Exception {
        setOperationCP=new SetOperationCP();
    }

    @Test
    public void testEtendueOperation() throws Exception {
        for (int i = 0; i <100; i++) {
            I_Operation operation=setOperationCP.createAnOperation();
            int res= operation.displayResult();
            assertEquals(true, 2<=res && res<=14);
        }
    }

    @Test
    public void createAnOperation() throws Exception {
        for (int i = 0; i < 1000; i++) {
            I_Operation operation=setOperationCP.createAnOperation();
            assertTrue(operation.displayResult()-3>=0);
        }
    }

}