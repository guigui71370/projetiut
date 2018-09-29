
package com.example.cassa.entrainementprojettut.operationGame.Operations;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by clement on 02/01/18.
 */
public class AdditionTest {

    private Addition addition;

    @Before
    public void setUp() throws Exception {
        addition=new Addition();
    }

    @Test
    public void testStandardAddition() throws Exception {
        for (int i = 0; i <1000; i++) {
            addition.generateOperation(10,1,4,1);
            assertEquals((addition.getTerme2() + addition.getTerme1()), addition.displayResult());
        }
    }
}