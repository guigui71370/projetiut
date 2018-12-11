package com.example.cassa.entrainementprojettut.connect4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlateauTest {

    @Test
    public void verticaltest_ccc() throws Exception {
        Plateau plateau=new Plateau(2);
        plateau.insertCheckers(0,'r');
        plateau.insertCheckers(0,'r');
        plateau.insertCheckers(0,'r');

        assertEquals(0, plateau.conect4In1Turn('r'));
    }



    @Test
    public void horizontaltest_ccc() throws Exception {
        Plateau plateau=new Plateau(2);
        plateau.insertCheckers(3,'r');
        plateau.insertCheckers(1,'r');
        plateau.insertCheckers(2,'r');

        assertEquals(0, plateau.conect4In1Turn('r'));
    }



    @Test
    public void diagonalerightest_ccc() throws Exception {
        Plateau plateau=new Plateau(2);
        plateau.insertCheckers(3,'c');
        plateau.insertCheckers(3,'c');
        plateau.insertCheckers(3,'r');


        plateau.insertCheckers(2,'c');
        plateau.insertCheckers(2,'r');
        plateau.insertCheckers(2,'r');


        plateau.insertCheckers(1,'c');
        plateau.insertCheckers(1,'r');
        plateau.insertCheckers(0,'r');

        assertEquals(3, plateau.conect4In1Turn('r'));
    }


    @Test
    public void diagonalelefttest_ccc() throws Exception {
        Plateau plateau=new Plateau(2);
        plateau.insertCheckers(0,'c');
        plateau.insertCheckers(0,'c');
        plateau.insertCheckers(0,'r');



        plateau.insertCheckers(1,'c');
        plateau.insertCheckers(1,'r');
        plateau.insertCheckers(1,'r');


        plateau.insertCheckers(2,'c');
        plateau.insertCheckers(2,'r');

        plateau.insertCheckers(3,'r');

        assertEquals(0, plateau.conect4In1Turn('r'));
    }



    @Test
    public void horizontaltestccc_() throws Exception {
        Plateau plateau=new Plateau(2);
        plateau.insertCheckers(0,'r');
        plateau.insertCheckers(1,'r');
        plateau.insertCheckers(2,'r');

        assertEquals(3, plateau.conect4In1Turn('r'));
    }



    @Test
    public void horizontaltestcc_c() throws Exception {
        Plateau plateau=new Plateau(2);
        plateau.insertCheckers(0,'r');
        plateau.insertCheckers(1,'r');
        plateau.insertCheckers(3,'r');

        assertEquals(2, plateau.conect4In1Turn('r'));
    }

    @Test
    public void horizontaltestc_cc() throws Exception {
        Plateau plateau=new Plateau(2);
        plateau.insertCheckers(0,'r');
        plateau.insertCheckers(2,'r');
        plateau.insertCheckers(3,'r');

        assertEquals(1, plateau.conect4In1Turn('r'));
    }


    @Test
    public void horizontaltestcc_c2_game() throws Exception {
        Plateau plateau=new Plateau(2);
        plateau.insertCheckers(2,'r');
        plateau.insertCheckers(3,'r');
        plateau.insertCheckers(5,'r');
        plateau.insertCheckers(6,'y');
        plateau.insertCheckers(2,'y');

        assertEquals(4, plateau.conect4In1Turn('r'));
    }




}
