package com.example.cassa.entrainementprojettut.flag;

/**
 * Created by LeBoss on 09/01/2018.
 */

public class ControllerFlagBank {

    private I_FlagBank flagBank;

    public ControllerFlagBank(int selectedLevel) {
        FactoryFlagBank factoryFlagBank = new FactoryFlagBank();
        flagBank = factoryFlagBank.genererFlagBank(selectedLevel);
    }

    public I_FlagBank getFlagBank(){
        return flagBank;
    }

    public Flag getFlag(int i){
        return flagBank.getFlag(i);
    }
}
