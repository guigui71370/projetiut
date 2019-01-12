package com.example.cassa.entrainementprojettut.mythology;

public class Divinity {

    private String name;

    private String text;



    private Divinity(String divinityName , String divinityText){
        name = divinityName;
        text = divinityText;
    }

    public String getName(){
        return name;
    }

    public String getText(){
        return text;
    }

}
