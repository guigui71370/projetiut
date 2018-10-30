package com.example.cassa.entrainementprojettut.geography.gameSetter;

import com.example.cassa.entrainementprojettut.geography.Tag;

import java.util.List;

/**
 * Created by prax on 09/01/2018.
 */
public interface I_Set {




    //SETTERS

    void setBackgroundImage();
    void setTagList(float tailleCote);

    List <Tag> getTagList();
    int getBackgroundImage();



}
