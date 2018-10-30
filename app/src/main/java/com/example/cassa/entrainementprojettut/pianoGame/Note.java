package com.example.cassa.entrainementprojettut.pianoGame;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;

/**
 * Created by clement on 16/01/18.
 * Modified by brice on 10/10/18
 */

class Note {
    private int id;
    private int adressSound;

    Note(int id, int adressSound) {
        this.id = id;
        this.adressSound = adressSound;
    }

    public int getId() {
        return id;
    }

    public int getAdressSound() {
        return adressSound;
    }

    void playSong(Activity activity){

        final MediaPlayer song = MediaPlayer.create(activity,adressSound);
        song.setAudioStreamType(AudioManager.STREAM_MUSIC);

        song.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                song.release();
            }
        });

        song.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });
    }
}
