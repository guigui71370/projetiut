package com.example.cassa.entrainementprojettut.geography;

import com.example.cassa.entrainementprojettut.geography.gameSetter.I_Set;
import com.example.cassa.entrainementprojettut.geography.gameSetter.SetEurope;
import com.example.cassa.entrainementprojettut.geography.gameSetter.SetOccitanie;
import com.example.cassa.entrainementprojettut.geography.gameSetter.SetWorld;

/**
 * Created by prax on 09/01/2018.
 */

public class Factory {

    public I_Set createNewLevel(int difficulte,float sideSizeOfATag){

        I_Set newLevel;
        switch (difficulte){
            case 1:
                newLevel = new SetWorld(sideSizeOfATag);
                break;
            case 2:
                newLevel = new SetEurope(sideSizeOfATag);
                break;
            case 3:
                newLevel = new SetOccitanie(sideSizeOfATag);
                break;
            default:
                newLevel = new SetWorld(sideSizeOfATag);
                break;
        }
        return newLevel;
    }

}
