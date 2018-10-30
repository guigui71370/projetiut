package com.example.cassa.entrainementprojettut.geography.gameSetter;

import com.example.cassa.entrainementprojettut.R;
import com.example.cassa.entrainementprojettut.geography.Tag;

import java.util.ArrayList;
import java.util.List;



public class SetOccitanie implements I_Set {

    int backgroundImage;
    private List<Tag> tagList;

    public SetOccitanie(float tailleCote){

        tagList = new ArrayList<>();
        setBackgroundImage();
        setTagList(tailleCote);



    }
    public List<Tag> getTagList(){

        return tagList;
    }
    public int getBackgroundImage(){

        return backgroundImage;
    }

    @Override
    public void setBackgroundImage() {
        backgroundImage = R.drawable.occitanie;
    }

    @Override
    public void setTagList(float tailleCote) {
        //float tailleCote = 1/12F;

        tagList.add(new Tag("Pyrénées \n Orientales",6/12F,21/24F, tailleCote));
        tagList.add(new Tag("Aude", 6/12F, 8/12F, tailleCote));
        tagList.add(new Tag("Hérault", 8/12F, 6/12F, tailleCote));
        tagList.add(new Tag("Gard", 10/12F, 9/24F, tailleCote));
        tagList.add(new Tag("Ariege", 15/48F, 35/48F, tailleCote));
        tagList.add(new Tag("Haute \n Garonne", 13/48F, 27/48F, tailleCote));
        tagList.add(new Tag("Tarn", 21/48F, 5/12F, tailleCote));
        tagList.add(new Tag("Aveyron", 13/24F, 3/12F, tailleCote));
        tagList.add(new Tag("Lozere", 33/48F, 2/12F, tailleCote));
        tagList.add(new Tag("Haute \n Pyrénées", 3/48F, 35/48F, tailleCote));
        tagList.add(new Tag("Gers", 3/24F, 11/24F, tailleCote));
        tagList.add(new Tag("Tarn et \n Garonne", 3/12F, 4/12F, tailleCote));
        tagList.add(new Tag("Lot", 4/12F, 3/24F, tailleCote));

    }
}
