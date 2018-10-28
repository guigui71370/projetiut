package com.example.cassa.entrainementprojettut.conjugaison;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cassa.entrainementprojettut.R;
import com.example.cassa.entrainementprojettut.database.DAOconjugaison;
import com.example.cassa.entrainementprojettut.gameUtils.GameActivity;

public class ConjugaisonActivity  extends GameActivity {
   protected DAOconjugaison daoconjugaison=DAOconjugaison.getInstance(this);


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conjugaison);
        final TextView texttest=findViewById(R.id.sentence);
        final TextView temps=findViewById(R.id.temps);
        Button test=findViewById(R.id.verb1);

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               texttest.setText( daoconjugaison.findSentents(1));
               temps.setText( daoconjugaison.findtemp(1));
            }
        });


    }
}
