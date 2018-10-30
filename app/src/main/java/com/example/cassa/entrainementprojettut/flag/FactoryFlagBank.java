package com.example.cassa.entrainementprojettut.flag;

/**
 * Created by LeBoss on 09/01/2018.
 */

public class FactoryFlagBank {

    public I_FlagBank genererFlagBank(int selectedLevel){
        I_FlagBank flagBank;

        switch (selectedLevel){
            case 1:
                flagBank = new FlagBankEasy();
                break;
            case 2:
                flagBank = new FlagBankNormal();
                break;
            case 3:
                flagBank = new FlagBankHard();
                break;
            default:
                flagBank = new FlagBankEasy();
                break;
        }
        return flagBank;
    }
}
