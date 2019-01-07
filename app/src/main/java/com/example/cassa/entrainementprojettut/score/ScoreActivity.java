package com.example.cassa.entrainementprojettut.score;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.cassa.entrainementprojettut.R;
import com.example.cassa.entrainementprojettut.database.AppDatabase;
import com.example.cassa.entrainementprojettut.database.Score;
import com.example.cassa.entrainementprojettut.gameUtils.GameActivity;


import java.util.List;

public class ScoreActivity  extends GameActivity {

    public static final String PIANO = "Piano";
    public static final String GEOGRAPHY = "Géographie";
    public static final String INVERT_FLAG = "Drapeaux inversés";
    public static final String FLAG = "Drapeaux";
    public static final String MYSTERY_WORD = "Mot mystère";
    public static final String OPERATION = "Opération";
    public static final String CONJUGAISON = "Conjugaison";
    public static final String CONNECT4 = "Puissance 4";
    public static final String GEOMETRY = "Géométrie";
    public static final String LES_RECORD_DU_JEUX = "Les records du jeu ";
    public static final String PAR_NIVEAU_SONT = " par niveau sont:\n";
    public static final String AUCUN_SCORE_N_A_ÉTÉ_ÉTABLIE_DANS_CE_JEUX_POUR_LE_MOMENT = "Aucun score n'a été établie dans ce jeu pour le moment \n ";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Button mAddition = findViewById(R.id.score_op);
        Button btnMysteryWord = findViewById(R.id.score_mm);
        Button btnFlagActivity = findViewById(R.id.score_f);
        Button btnReverseFlagActivity = findViewById(R.id.score_if);
        Button btnGeographyTag = findViewById(R.id.score_g);
        Button btnPiano = findViewById(R.id.score_p);
        Button btnConjugaison = findViewById(R.id.score_c);
        Button btnConnect4 = findViewById(R.id.score_c4);
        Button btnGeometry = findViewById(R.id.score_ge);

        mAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDatabase database;
                database = AppDatabase.getInstanceOfAppDatabase(getApplicationContext());
                List<Score> list= database.getScoreDao().getAllScoreforgame(OPERATION);
                TextView contenuScore= findViewById(R.id.score_tw);

                contenuScore.setText(LES_RECORD_DU_JEUX+OPERATION +PAR_NIVEAU_SONT);
                if(list.size()>0) {
                    for (int i = 0; i < list.size(); i++) {


                        contenuScore.setText(contenuScore.getText() +"\n" +list.get(i).toString() + "\n");

                    }
                }else{
                    contenuScore.setText(contenuScore.getText()+"\n"+ AUCUN_SCORE_N_A_ÉTÉ_ÉTABLIE_DANS_CE_JEUX_POUR_LE_MOMENT);
                }

            }
        });


        btnMysteryWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDatabase database;
                database = AppDatabase.getInstanceOfAppDatabase(getApplicationContext());
                List<Score> list= database.getScoreDao().getAllScoreforgame(MYSTERY_WORD);
                TextView contenuScore= findViewById(R.id.score_tw);

                contenuScore.setText(LES_RECORD_DU_JEUX+MYSTERY_WORD +PAR_NIVEAU_SONT);
                if(list.size()>0) {
                    for (int i = 0; i < list.size(); i++) {


                        contenuScore.setText(contenuScore.getText()+"\n" + list.get(i).toString() + "\n");

                    }
                }else{
                    contenuScore.setText(contenuScore.getText()+"\n"+ AUCUN_SCORE_N_A_ÉTÉ_ÉTABLIE_DANS_CE_JEUX_POUR_LE_MOMENT);
                }

            }
        });

        btnFlagActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDatabase database;
                database = AppDatabase.getInstanceOfAppDatabase(getApplicationContext());
                List<Score> list= database.getScoreDao().getAllScoreforgame(FLAG);
                TextView contenuScore= findViewById(R.id.score_tw);

                contenuScore.setText(LES_RECORD_DU_JEUX+FLAG +PAR_NIVEAU_SONT);
                if(list.size()>0) {
                    for (int i = 0; i < list.size(); i++) {


                        contenuScore.setText(contenuScore.getText()+"\n" + list.get(i).toString() + "\n");

                    }
                }else{
                    contenuScore.setText(contenuScore.getText()+"\n"+ AUCUN_SCORE_N_A_ÉTÉ_ÉTABLIE_DANS_CE_JEUX_POUR_LE_MOMENT);
                }
            }
        });


        btnReverseFlagActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDatabase database;
                database = AppDatabase.getInstanceOfAppDatabase(getApplicationContext());
                List<Score> list= database.getScoreDao().getAllScoreforgame(INVERT_FLAG);
                TextView contenuScore= findViewById(R.id.score_tw);

                contenuScore.setText(LES_RECORD_DU_JEUX+INVERT_FLAG +PAR_NIVEAU_SONT);
                if(list.size()>0) {
                    for (int i = 0; i < list.size(); i++) {


                        contenuScore.setText(contenuScore.getText()+"\n" + list.get(i).toString() + "\n");

                    }
                }else{
                    contenuScore.setText(contenuScore.getText()+"\n"+ AUCUN_SCORE_N_A_ÉTÉ_ÉTABLIE_DANS_CE_JEUX_POUR_LE_MOMENT);
                }


            }
        });

        btnGeographyTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDatabase database;
                database = AppDatabase.getInstanceOfAppDatabase(getApplicationContext());
                List<Score> list= database.getScoreDao().getAllScoreforgame(GEOGRAPHY);
                TextView contenuScore= findViewById(R.id.score_tw);

                contenuScore.setText(LES_RECORD_DU_JEUX+GEOGRAPHY +PAR_NIVEAU_SONT);
                if(list.size()>0) {
                    for (int i = 0; i < list.size(); i++) {


                        contenuScore.setText(contenuScore.getText()+"\n" + list.get(i).toString() + "\n");

                    }
                }else{
                    contenuScore.setText(contenuScore.getText()+"\n"+ AUCUN_SCORE_N_A_ÉTÉ_ÉTABLIE_DANS_CE_JEUX_POUR_LE_MOMENT);
                }
            }
        });

        btnPiano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDatabase database;
                database = AppDatabase.getInstanceOfAppDatabase(getApplicationContext());
                List<Score> list= database.getScoreDao().getAllScoreforgame(PIANO);
                TextView contenuScore= findViewById(R.id.score_tw);

                contenuScore.setText(LES_RECORD_DU_JEUX+PIANO +PAR_NIVEAU_SONT);
                if(list.size()>0) {
                    for (int i = 0; i < list.size(); i++) {


                        contenuScore.setText(contenuScore.getText()+"\n" + list.get(i).toString() + "\n");

                    }
                }else{
                    contenuScore.setText(contenuScore.getText()+"\n"+ AUCUN_SCORE_N_A_ÉTÉ_ÉTABLIE_DANS_CE_JEUX_POUR_LE_MOMENT);
                }
            }
        });
        btnConjugaison.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDatabase database;
                database = AppDatabase.getInstanceOfAppDatabase(getApplicationContext());
                List<Score> list= database.getScoreDao().getAllScoreforgame(CONJUGAISON);
                TextView contenuScore= findViewById(R.id.score_tw);

                contenuScore.setText(LES_RECORD_DU_JEUX +CONJUGAISON + PAR_NIVEAU_SONT);
                if(list.size()>0) {
                    for (int i = 0; i < list.size(); i++) {


                        contenuScore.setText(contenuScore.getText()+"\n" + list.get(i).toString() + "\n");

                    }
                }else{
                    contenuScore.setText(contenuScore.getText()+"\n"+ AUCUN_SCORE_N_A_ÉTÉ_ÉTABLIE_DANS_CE_JEUX_POUR_LE_MOMENT);
                }
            }
        });



        btnConnect4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDatabase database;
                database = AppDatabase.getInstanceOfAppDatabase(getApplicationContext());
                List<Score> list= database.getScoreDao().getAllScoreforgame(CONNECT4);
                TextView contenuScore= findViewById(R.id.score_tw);

                contenuScore.setText(LES_RECORD_DU_JEUX +CONNECT4 + PAR_NIVEAU_SONT);
                if(list.size()>0) {
                    for (int i = 0; i < list.size(); i++) {


                        contenuScore.setText(contenuScore.getText()+"\n" + list.get(i).toString() + "\n");

                    }
                }else{
                    contenuScore.setText(contenuScore.getText()+"\n"+ AUCUN_SCORE_N_A_ÉTÉ_ÉTABLIE_DANS_CE_JEUX_POUR_LE_MOMENT);
                }
            }
        });

        btnGeometry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDatabase database;
                database = AppDatabase.getInstanceOfAppDatabase(getApplicationContext());
                List<Score> list= database.getScoreDao().getAllScoreforgame(GEOMETRY);
                TextView contenuScore= findViewById(R.id.score_tw);

                contenuScore.setText(LES_RECORD_DU_JEUX +GEOMETRY + PAR_NIVEAU_SONT);
                if(list.size()>0) {
                    for (int i = 0; i < list.size(); i++) {


                        contenuScore.setText(contenuScore.getText()+"\n" + list.get(i).toString() + "\n");

                    }
                }else{
                    contenuScore.setText(contenuScore.getText()+"\n"+ AUCUN_SCORE_N_A_ÉTÉ_ÉTABLIE_DANS_CE_JEUX_POUR_LE_MOMENT);
                }
            }
        });




    }

}
