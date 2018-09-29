package com.example.cassa.entrainementprojettut.geographieTest;

import com.example.cassa.entrainementprojettut.geography.Controler;
import com.example.cassa.entrainementprojettut.geography.gameSetter.I_Set;
import com.example.cassa.entrainementprojettut.geography.gameSetter.SetEurope;
import com.example.cassa.entrainementprojettut.geography.gameSetter.SetWorld;
import com.example.cassa.entrainementprojettut.geography.gameSetter.SetOccitanie;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by prax on 09/01/2018.
 */

public class ControlerTest {
    @Test
    public void recupererImageNiveau1()  {
        Controler controler = new Controler(1,10);
        I_Set niveau = new SetWorld(10);

        assertEquals(niveau.getBackgroundImage(), controler.getBackgroundImage());

    }
    @Test
    public void recupererImageNiveau2()  {
        Controler controler = new Controler(2,10);
        I_Set niveau = new SetEurope(10);

        assertEquals(niveau.getBackgroundImage(), controler.getBackgroundImage());

    }
    @Test
    public void recupererImageNiveau3()  {
        Controler controler = new Controler(3,10);
        I_Set niveau = new SetOccitanie(10);

        assertEquals(niveau.getBackgroundImage(), controler.getBackgroundImage());

    }
    @Test
    public void recupererNomListeEtiqueNiveau1()  {
        boolean listeIdentique = true;
        int i = 0;

        Controler controler = new Controler(1,10);
        I_Set niveau = new SetWorld(10);

        while (i < niveau.getTagList().size() && listeIdentique == true){
            if(niveau.getTagList().get(i).getName() != controler.getTagList().get(i).getName()){
                listeIdentique = false;
            }
            i++;
        }
        assertTrue(listeIdentique);

    }
    @Test
    public void recupererNomListeEtiqueNiveau2()  {
        boolean listeIdentique = true;
        int i = 0;

        Controler controler = new Controler(2,10);
        I_Set niveau = new SetEurope(10);

        while (i < niveau.getTagList().size() && listeIdentique == true){
            if(niveau.getTagList().get(i).getName() != controler.getTagList().get(i).getName()){
                listeIdentique = false;
            }
            i++;
        }
        assertTrue(listeIdentique);

    }
    @Test
    public void recupererNomListeEtiqueNiveau3()  {
        boolean listeIdentique = true;
        int i = 0;

        Controler controler = new Controler(3,10);
        I_Set niveau = new SetOccitanie(10);

        while (i < niveau.getTagList().size() && listeIdentique == true){
            if(niveau.getTagList().get(i).getName() != controler.getTagList().get(i).getName()){
                listeIdentique = false;
            }
            i++;
        }
        assertTrue(listeIdentique);

    }
}
