package com.example.cassa.entrainementprojettut.geometry;

import com.example.cassa.entrainementprojettut.geometry.setGeometry.*;

public class FactorySetGeometry {
    public I_SetGeometry createSetGeometry(int difficulty) {
        I_SetGeometry setGeometry;
        switch (difficulty){
            case 1:
                setGeometry=new SetGeometryLV1();
                break;
            case 2:
                setGeometry=new SetGeometryLV2();
                break;
            case 3:
                setGeometry=new SetGeometryLV3();
                break;
            default:
                setGeometry=new SetGeometryLV1();
                break;

        }
        return setGeometry;
    }
}
