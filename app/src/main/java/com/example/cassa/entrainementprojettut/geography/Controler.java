package com.example.cassa.entrainementprojettut.geography;

import com.example.cassa.entrainementprojettut.geography.gameSetter.I_Set;

import java.util.List;

/**
 * Created by prax on 09/01/2018.
 */

public class Controler {

    private I_Set newLevel;

    public Controler(int difficulte, float sideSizeOfATag) {

        Factory factory = new Factory();
        newLevel = factory.createNewLevel(difficulte,sideSizeOfATag);

    }

    public List<Tag> getTagList() {

       return newLevel.getTagList();

    }
    public int getBackgroundImage(){
        return newLevel.getBackgroundImage();
    }

}
