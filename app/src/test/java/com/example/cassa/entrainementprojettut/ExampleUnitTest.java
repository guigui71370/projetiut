package com.example.cassa.entrainementprojettut;


import com.example.cassa.entrainementprojettut.flag.ControllerFlagBank;
import com.example.cassa.entrainementprojettut.flag.Flag;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void flagGetName() {
        Flag flag = new Flag("France", R.drawable.france);
        assertEquals("France", flag.getmNameCountry());
    }

    @Test
    public void flagGetRessource() {
        Flag flag = new Flag("France", R.drawable.france);
        assertEquals(R.drawable.france, flag.getmRessource());
    }

    @Test
    public void controllerNiveau1(){
        for (int i=0; i<1000; i++){
            ControllerFlagBank controllerFlagBank = new ControllerFlagBank(1);

            Flag flag0 = controllerFlagBank.getFlag(0);
            Flag flag1 = controllerFlagBank.getFlag(1);
            Flag flag2 = controllerFlagBank.getFlag(2);
            Flag flag3 = controllerFlagBank.getFlag(3);

            //Argentine est u pays de niveau 2
            assertTrue(flag0.getmNameCountry() != "Argentine");
            assertTrue(flag1.getmNameCountry() != "Argentine");
            assertTrue(flag2.getmNameCountry() != "Argentine");
            assertTrue(flag3.getmNameCountry() != "Argentine");

        }
    }

    @Test
    public void controllerNiveau2(){
        for (int i=0; i<1000; i++){
            ControllerFlagBank controllerFlagBank = new ControllerFlagBank(2);

            Flag flag0 = controllerFlagBank.getFlag(0);
            Flag flag1 = controllerFlagBank.getFlag(1);
            Flag flag2 = controllerFlagBank.getFlag(2);
            Flag flag3 = controllerFlagBank.getFlag(3);

            //Maroc est un pays de niveau 3
            assertTrue(flag0.getmNameCountry() != "Maroc");
            assertTrue(flag1.getmNameCountry() != "Maroc");
            assertTrue(flag2.getmNameCountry() != "Maroc");
            assertTrue(flag3.getmNameCountry() != "Maroc");

        }
    }



    @Test
    public void wordGetCodeWord(){
        //En attende de révisions du code
    }
}