package com.example.cassa.entrainementprojettut.geographieTest;

import com.example.cassa.entrainementprojettut.geography.Tag;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by prax on 09/01/2018.
 */

public class TagTest {
    //  Jeu Tag


    @Test
    public void etiquetteGetNom(){
        Tag tag = new Tag("nomEtiquette",10/12,10/12,1/12);
        assertEquals("nomEtiquette", tag.getName());
    }

    @Test
    public void etiquetteGetZone(){
        Tag tag = new Tag("nomEtiquette",10/12,10/12,1/12);
        float[]tabZoneVictoire;
        tabZoneVictoire = tag.getVictoryBox();

        assertEquals(10/12,tabZoneVictoire[0],0);
        assertEquals(11/12,tabZoneVictoire[1],0);
        assertEquals(10/12,tabZoneVictoire[2],0);
        assertEquals(11/12,tabZoneVictoire[3],0);
    }


}
