package com.example.cassa.entrainementprojettut.conjugaison;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cassa.entrainementprojettut.R;
import com.example.cassa.entrainementprojettut.database.AppDatabase;
import com.example.cassa.entrainementprojettut.database.Infinitif;
import com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil.InfinitifData;
import com.example.cassa.entrainementprojettut.database.VerbeConjugue;
import com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil.VerbeConjugueData;
import com.example.cassa.entrainementprojettut.gameUtils.GameActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil.ListeTemps.FUTURSIMPLE;
import static com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil.ListeTemps.PASSESIMPLE;
import static com.example.cassa.entrainementprojettut.conjugaison.ConjugaisonUtil.ListeTemps.PRESENTINDICATIF;

public class ConjugaisonActivity extends GameActivity implements View.OnClickListener{
    private TextView time;
    private TextView sujet;
    private TextView verbe;
    private TextView complement;
    private TextView infinitif;
    private TextView hint;

    private Button verb1;
    private Button verb2;
    private Button verb3;
    private Button verb4;

    public AppDatabase database;
    private Chronometer chronometer;

    private ConjugaisonController ctrl;

    private LinearLayout layoutStars;

    protected Runnable activateButton=new Runnable() {
        @Override
        public void run() {
            activateButtons();
        }
    };
    protected Runnable generateConjugaison=new Runnable() {
        @Override
        public void run() {
            generateConjugaison();
        }
    };

    private int goodAnswer = 0;
    private int badAnswer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conjugaison);
        showMenu();
        initializeGame();

        database = AppDatabase.getInstanceOfAppDatabase(getApplicationContext());

        database.getInfinitifDao().removeAllInfinitif(); //Pour les tests
        //On recupere tous les infinitifs deja dans la BD
        List<Infinitif> infinitifList = database.getInfinitifDao().getAllInfinitif();
        //On recupere tous les infinitifs existants
        List<Infinitif> infinitifs = new InfinitifData().getInfinitif();
        //Si on a pas d'infinitifs dans la BD, on ajoutes les infinitifs existants
        if (infinitifList.size()==0) {
            for (Infinitif inf: infinitifs) {
                database.getInfinitifDao().addInfinitif(inf);
            }
        }

        //Meme fonctionnement avec les verbes conjugués
        database.getVerbeConjugueDao().removeAllVerbeConjugue();
        List<VerbeConjugue> verbeConjugueList = database.getVerbeConjugueDao().getAllVerbeConjugue();
        List<VerbeConjugue> verbeConjugues = new VerbeConjugueData().getVerbeConjugue(getListTerminaison());
        if(verbeConjugueList.size()==0){
            for (VerbeConjugue vbc: verbeConjugues) {
                database.getVerbeConjugueDao().addVerbeConjugue(vbc);
            }
        }

        music = R.raw.bensound_cute;
        startBackgroundMusic(this,music);

        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                if (levelChosen != 0) {
                    activateButtons();
                    generateConjugaison();
                    addStars(0, ctrl.getNbEtoiles());
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    chronometer.start();
                } else {
                    ConjugaisonActivity.this.onStop();
                    dialog.show();
                }
            }
        });

        time = findViewById(R.id.activity_conjugaison_temps_textview);
        sujet =  findViewById(R.id.activity_conjugaison_sujet_textview);
        verbe =  findViewById(R.id.activity_conjugaison_verbe_textview);
        complement = findViewById(R.id.activity_conjugaison_complement_textview);
        infinitif = findViewById(R.id.activity_conjugaison_infinitif_textview);
        hint = findViewById(R.id.activity_conjugaison_hint_textview);

        verb1 = findViewById(R.id.activity_conjugaison_verb1_button);
        verb2 = findViewById(R.id.activity_conjugaison_verb2_button);
        verb3 = findViewById(R.id.activity_conjugaison_verb3_button);
        verb4 = findViewById(R.id.activity_conjugaison_verb4_button);

        chronometer = findViewById(R.id.activity_conjugaison_chronometer2_chronometer);

        layoutStars = findViewById(R.id.activity_conjugaison_starsLayout_linearlayout);
    }

    //Pour l'instant avec le fichier tests.json, plus tard avec le fichier terminaisons.json
    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("tests.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public ArrayList<HashMap<String,String>> getListTerminaison(){
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            //On recupere l'objet "prototype" de notre json
            JSONArray m_jArry = obj.getJSONArray("prototype");
            ArrayList<HashMap<String, String>> formList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> m_li;

            String regex_value = "Pas de regex";
            String infinitive_value = "Pas d'infinitive";
            String radical_value = "Pas de radical";
            String ending_value = "Pas de ending";
            String aux_value = "Pas d'auxiliaire";
            String ppasse_value = "Pas de Participe Passe";
            String ppresent_value = "Pas de Participe Present";
            String present_value = "Pas de Present";
            String imparfait_value = "Pas d'Imparfait";
            String passe_value = "Pas de Passe";
            String futur_value = "Pas de Futur";
            String spresent_value = "Pas de Subjonctif Present";
            String simparfait_value = "Pas de Subjonctif Imparfait";
            String imperatif_value = "Pas d'Imperatif";
            String condition_value = "Pas de conditionnel";

            //Pour chaque objet prototype
            for (int i = 0; i < m_jArry.length(); i++) {
                //On recupere le prototype de i
                JSONObject jo_inside = m_jArry.getJSONObject(i);

                //On recupere chaque champ si le champ n'est pas null

                if(!(jo_inside.isNull("REGEX"))) {
                    regex_value = jo_inside.getString("REGEX");
                }
                if(!(jo_inside.isNull("ENDING"))) {
                    ending_value = jo_inside.getString("ENDING");
                }
                if(!(jo_inside.isNull("AUX"))) {
                    aux_value = jo_inside.getString("AUX");
                }
                if(!(jo_inside.isNull("PPRESENT"))) {
                    ppresent_value = jo_inside.getString("PPRESENT");
                }
                if(!(jo_inside.isNull("PPASSE"))) {
                    ppasse_value = jo_inside.getString("PPASSE");
                }
                if(!(jo_inside.isNull("PRESENT"))) {
                    present_value = jo_inside.getString("PRESENT");
                }
                if(!(jo_inside.isNull("IMPARFAIT"))) {
                    imparfait_value = jo_inside.getString("IMPARFAIT");
                }
                if(!(jo_inside.isNull("PASSE"))) {
                    passe_value = jo_inside.getString("PASSE");
                }
                if(!(jo_inside.isNull("FUTUR"))) {
                    futur_value = jo_inside.getString("FUTUR");
                }
                if(!(jo_inside.isNull("SPRESENT"))) {
                    spresent_value = jo_inside.getString("SPRESENT");
                }
                if(!(jo_inside.isNull("SIMPARFAIT"))) {
                    simparfait_value = jo_inside.getString("SIMPARFAIT");
                }
                if(!(jo_inside.isNull("IMPERATIF"))) {
                    imperatif_value = jo_inside.getString("IMPERATIF");
                }
                if(!(jo_inside.isNull("CONDITION"))) {
                    condition_value = jo_inside.getString("CONDITION");
                }

                //On ajoute le champ recuperé
                m_li = new HashMap<>();
                m_li.put("REGEX", regex_value);
                m_li.put("ENDING", ending_value);
                m_li.put("AUX", aux_value);
                m_li.put("PPRESENT", ppresent_value);
                m_li.put("PPASSE", ppasse_value);
                m_li.put(PRESENTINDICATIF.getTemps(), present_value);
                m_li.put("IMPARFAIT", imparfait_value);
                m_li.put(PASSESIMPLE.getTemps(), passe_value);
                m_li.put(FUTURSIMPLE.getTemps(), futur_value);
                m_li.put("SPRESENT", spresent_value);
                m_li.put("SIMPARFAIT", simparfait_value);
                m_li.put("IMPERATIF", imperatif_value);
                m_li.put("CONDITION", condition_value);

                formList.add(m_li);
            }
            return formList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void activateButtons() {
        verb1.setEnabled(true);
        verb2.setEnabled(true);
        verb3.setEnabled(true);
        verb4.setEnabled(true);

        verb1.setBackgroundColor(Color.rgb(255,0,0));
        verb2.setBackgroundColor(Color.rgb(0,255,0));
        verb3.setBackgroundColor(Color.rgb(0,0,255));
        verb4.setBackgroundColor(Color.rgb(255,255,0));

        verb1.setOnClickListener(this);
        verb2.setOnClickListener(this);
        verb3.setOnClickListener(this);
        verb4.setOnClickListener(this);
    }

    protected void disableButton(){

        verb1.setEnabled(false);
        verb2.setEnabled(false);
        verb3.setEnabled(false);
        verb4.setEnabled(false);

        verb1.setBackgroundColor(Color.rgb(99,99,99));
        verb2.setBackgroundColor(Color.rgb(99,99,99));
        verb3.setBackgroundColor(Color.rgb(99,99,99));
        verb4.setBackgroundColor(Color.rgb(99,99,99));
    }

    @SuppressLint("SetTextI18n")
    protected void generateConjugaison(){

        ctrl = new ConjugaisonController(levelChosen);

        sujet.setText(ctrl.getSujetConjugaison());
        verbe.setText("");
        complement.setText(ctrl.getComplementConjugaison());
        infinitif.setText(ctrl.getInfinitifConjugaison() + " :");
        time.setText(ctrl.getTempsConjugaison());

        setVerbeMalConjugue();
    }

    @Override
    public void onClick(View view) {
        //Pour les tests
       disableButton();
       if(view.getContentDescription().equals(ctrl.getVerbeConjugaison())){
           showText(getString(R.string.Well_played));
           verbe.setText(ctrl.getVerbeConjugaison().toLowerCase());
           goodAnswer++;
           handler.postDelayed(activateButton, 800);
           if(goodAnswer < ctrl.getNbEtoiles()) {
               addStars(goodAnswer, ctrl.getNbEtoiles() - goodAnswer);
               handler.postDelayed(generateConjugaison,800);
           }else{
               addStars(goodAnswer, ctrl.getNbEtoiles() - goodAnswer);
               unableLoose();
               unableScoreMode();
               chronometer.stop();
               timeScore = (SystemClock.elapsedRealtime() - chronometer.getBase()) / 1000;
               initializeScoreValues("operation", levelChosen);
               showResultScreen(this);
           }

       }else{
           showText(getString(R.string.to_bad) + " " +ctrl.getVerbeConjugaison());
           verbe.setText(ctrl.getVerbeConjugaison().toLowerCase());
           badAnswer++;
           handler.postDelayed(activateButton, 2100);
           handler.postDelayed(generateConjugaison,2100);
       }
    }

    public void setVerbeMalConjugue(){
        //¨Pour les tests
        verb1.setText(ctrl.getVerbeConjugaison());
        verb1.setContentDescription(ctrl.getVerbeConjugaison());
        verb2.setText(ctrl.getInfinitifConjugaison()+"ait");
        verb2.setContentDescription(ctrl.getInfinitifConjugaison()+"ait");
        verb3.setText(ctrl.getInfinitifConjugaison()+"es");
        verb3.setContentDescription(ctrl.getInfinitifConjugaison()+"es");
        verb4.setText(ctrl.getInfinitifConjugaison()+"is");
        verb4.setContentDescription(ctrl.getInfinitifConjugaison()+"is");
    }

    private void showMenu(){
        String[] menu = new String[5];
        menu[0]= getString(R.string.first_year_of_primary_school);
        menu[1]= getString(R.string.second_year_of_primary_school);
        menu[2]= getString(R.string.third_year_of_primary_school);
        menu[3]= getString(R.string.fourth_year_of_primary_school);
        menu[4]= getString(R.string.fifth_year_of_primary_school);
        displayLevelchoice(this,menu);
    }

    /**
     *ON MET DES FANTOMES ICI EN ATTENDANT D'AVOIR DES ETOILES DEJA VIDES
     */
    private void addStars(int etoilePleine, int etoileVide){
        layoutStars.removeAllViews();
        int emptyStars[] = new int[etoileVide];
        int fullStars[] = new int[etoilePleine];
        for (Integer items : fullStars) {
            ImageView imgStars = new ImageView(this);
            imgStars.setBackgroundResource(R.mipmap.star);
            layoutStars.addView(imgStars);
        }

        for (Integer items : emptyStars) {
            ImageView imgStars = new ImageView(this);
            imgStars.setBackgroundResource(R.mipmap.empty_star);
            layoutStars.addView(imgStars);
        }
    }
}

