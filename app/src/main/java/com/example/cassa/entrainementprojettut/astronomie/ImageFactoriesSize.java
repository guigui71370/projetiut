
package com.example.cassa.entrainementprojettut.astronomie;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ImageView;

public class ImageFactoriesSize {

    public static void factorisize(ImageView d,String name,float density){
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

    public static void setEmplacement(Context context, ImageView d, String name){
        switch (name) {
            case "Mercure":
                d.setX(88);
                DisplayMetrics metrics = context.getResources().getDisplayMetrics();
                float width = metrics.widthPixels;
                Log.d("aa", "setEmplacement: "+width);
                break;
            case "Venus":
                d.setX(168);
                break;
            case "Terre":
                d.setX(258);
                break;
            case "Mars":
                d.setX(328);
                break;
            case "Jupiter":
                d.setX(358);
                break;
            case "Saturne":
                d.setX(358);
                break;
            case "Uranus":
                d.setX(368);
                break;
            case "Neptune":
                d.setX(418);
                break;
        }
        d.requestLayout();

       /*
        switch (name) {
            case "Mercure":
                d.setX(width/12);
                Log.d("a", "setEmplacement: " +d.getX());
                break;
            case "Venus":
                d.setX(width/11);
                Log.d("a", "setEmplacement: " +d.getX());
                break;
            case "Terre":
                d.setX(width/10);
                Log.d("a", "setEmplacement: " +d.getX());
                break;
            case "Mars":
                d.setX(width/9);
                Log.d("a", "setEmplacement: " +d.getX());
                break;
            case "Jupiter":
                d.setX(width/8);
                Log.d("a", "setEmplacement: " +d.getX());
                break;
            case "Saturne":
                d.setX(width/7 * 1.25f);
                Log.d("a", "setEmplacement: " +d.getX());
                break;
            case "Uranus":
                d.setX(width/6 * 1.25f);
                Log.d("a", "setEmplacement: " +d.getX());
                break;
            case "Neptune":
                d.setX(width/5 * 1.25f);
                Log.d("a", "setEmplacement: " +d.getX());
                break;
        }
        d.requestLayout();*/
    }
}

