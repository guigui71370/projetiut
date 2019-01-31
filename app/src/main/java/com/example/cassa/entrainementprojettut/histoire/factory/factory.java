package com.example.cassa.entrainementprojettut.histoire.factory;

import com.example.cassa.entrainementprojettut.histoire.model.I_lvl;
import com.example.cassa.entrainementprojettut.histoire.model.lvl2;

public class factory {

    public  I_lvl factory(int i) {
        switch (i) {
            case 2:
                return new lvl2();
            default:
                return new lvl2();
        }
    }
}
