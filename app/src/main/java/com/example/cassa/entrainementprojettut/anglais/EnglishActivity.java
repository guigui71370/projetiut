package com.example.cassa.entrainementprojettut.anglais;

import android.os.Bundle;
import android.widget.Chronometer;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.cassa.entrainementprojettut.R;
import com.example.cassa.entrainementprojettut.gameUtils.GameActivity;

public class EnglishActivity extends GameActivity {
    @BindView(R.id.chronometer2)
    Chronometer time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english);
        ButterKnife.bind(this);
    }
}
