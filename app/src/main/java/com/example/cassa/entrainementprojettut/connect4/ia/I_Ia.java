package com.example.cassa.entrainementprojettut.connect4.ia;

import com.example.cassa.entrainementprojettut.connect4.Plateau;

public interface I_Ia {

    Plateau platteau=null;
    int getColumn();
    void calculateColumn(Plateau plateau);

}
