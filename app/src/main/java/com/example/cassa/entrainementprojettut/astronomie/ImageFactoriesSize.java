package com.example.cassa.entrainementprojettut.astronomie;

import android.widget.ImageView;

class ImageFactoriesSize {

    static void factorisize(ImageView d,String name,float density){
        switch (name) {
            case "Mercure":
                d.getLayoutParams().height = (int) (50 * density);
                d.getLayoutParams().width = (int) (50 * density);
                break;
            case "Venus":
                d.getLayoutParams().height = (int) (70 * density);
                d.getLayoutParams().width = (int) (70 * density);
                break;
            case "Terre":
                d.getLayoutParams().height = (int) (80 * density);
                d.getLayoutParams().width = (int) (80 * density);
                break;
            case "Mars":
                d.getLayoutParams().height = (int) (60 * density);
                d.getLayoutParams().width = (int) (60 * density);
                break;
            case "Jupiter":
                d.getLayoutParams().height = (int) (200 * density);
                d.getLayoutParams().width = (int) (200 * density);
                break;
            case "Saturne":
                d.getLayoutParams().height = (int) (150 * density);
                d.getLayoutParams().width = (int) (150 * density);
                break;
            case "Uranus":
                d.getLayoutParams().height = (int) (100 * density);
                d.getLayoutParams().width = (int) (100 * density);
                break;
            case "Neptune":
                d.getLayoutParams().height = (int) (60 * density);
                d.getLayoutParams().width = (int) (60 * density);
                break;
        }
        d.requestLayout();
   }
}
