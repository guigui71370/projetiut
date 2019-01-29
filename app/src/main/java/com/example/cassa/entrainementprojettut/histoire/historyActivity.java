package com.example.cassa.entrainementprojettut.histoire;

import android.os.Bundle;
import com.example.cassa.entrainementprojettut.R;
import com.example.cassa.entrainementprojettut.gameUtils.GameActivity;

public class historyActivity extends GameActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);


        initializeGame();

        showMenu();


        //initializeGameAfterMenuDismiss();
        if (isSong()) {
            startBackgroundMusic(historyActivity.this, R.raw.geography_music);
        }
        ///playerEvent = MediaPlayer.create(historyActivity.this, R.raw.envent_sound);
    }








    private void showMenu() {
        String[] menu = new String[2];
        menu[0] = "niveau 1";
        menu[1] = "niveau 2";

        displayLevelchoice(this, menu);
    }
}
