package com.example.cassa.entrainementprojettut.mythology.metier;

public class FactorySetMythology {


    public I_SetMythology createSetMythology(int difficulty) {
        I_SetMythology setMythology;
        switch (difficulty){
            case 1:
                setMythology =new SetMythologyLVL1();
                break;
            case 2:
                setMythology =new SetMythologyLVL2();
                break;
            case 3:
                setMythology =new SetMythologyLVL3();
                break;
            default:
                setMythology = new SetMythologyLVL1();
                break;
        }
        return setMythology;
    }
}
