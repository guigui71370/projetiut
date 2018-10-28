package com.example.cassa.entrainementprojettut.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

/**
 * Created by clement on 07/02/18.
 */

public class DBOpenHelper extends SQLiteOpenHelper {

    public static class Constants implements BaseColumns{

        public static  String DATABASE_NAME="androidGames.db";

        public static  int DATABASE_VERSION = 1;



        public static  String FIRST_TABLE = "Games";

        public static  String COL_ID_TABLE_1 = "idGame";

        public static  String COL_GAME_NAME_TABLE_1 = "gameName";

        public static  String COL_DIFFICULTY_TABLE_1 = "difficulty";




        public static String FOURTH_TABLE = "Score";

        public static String COL_ID_TABLE_4= "idScore";

        public static String COL_PLAYER_TABLE_4 = "player";

        public static String COL_SCORE_TABLE_4 = "score";

        public static String COL_GAME_TABLE_4 = "idGame";




        private static String DATABASE_CREATE_FIRST_TABLE = "create table "
                + Constants.FIRST_TABLE + "(" + Constants.COL_ID_TABLE_1
                + " integer primary key autoincrement, " + Constants.COL_GAME_NAME_TABLE_1
                + " TEXT, "+Constants.COL_DIFFICULTY_TABLE_1+" INTEGER)";



        private static String DATABASE_CREATE_FOURTH_TABLE = "create table "
                + Constants.FOURTH_TABLE + "(" + Constants.COL_ID_TABLE_4
                + " integer primary key autoincrement, " + Constants.COL_GAME_TABLE_4
                + " INTEGER, "+Constants.COL_PLAYER_TABLE_4+" TEXT DEFAULT 'DEV',"
                +Constants.COL_SCORE_TABLE_4 +" INTEGER DEFAULT 0,"+
                "FOREIGN KEY("+Constants.COL_GAME_TABLE_4 +") references "+Constants.FIRST_TABLE+"("+
                Constants.COL_ID_TABLE_1+"))";



        private static String DATABASE_INIT_FIRST_TABLE="insert into "+FIRST_TABLE+
                "("+ COL_GAME_NAME_TABLE_1 +", "+COL_DIFFICULTY_TABLE_1+") VALUES ('operation', 1)" +
                ",('MysteryWord', 1),('flag', 1),('invertFlag', 1),('geography', 1),('operation', 2)" +
                ",('MysteryWord', 2),('flag', 2),('invertFlag', 2),('geography', 2),('operation', 3)" +
                ",('MysteryWord', 3),('flag', 3),('invertFlag', 3),('geography', 3),('operation',4)," +
                "('MysteryWord',4),('piano',4),('operation',5),('MysteryWord',5)";


        private static String DATABASE_INIT_FOURTH_TABLE="insert into "+FOURTH_TABLE+
                "("+ COL_GAME_TABLE_4 +") VALUES (1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(11),(12),(13),(14),(15),(16),(17),(18),(19),(20)";








        private static String DROP_FOURTH_TABLE="DROP TABLE IF EXISTS "+FOURTH_TABLE;
        private static String DROP_FIRST_TABLE="DROP TABLE IF EXISTS "+FIRST_TABLE;




        /* ---------------------------- Tables jeux conjugaison -------------------------------*/



        // création table verbe infinitif
        public static String VERB_TABLE = "VERBE_INFINITIF";

        public static  String VERB_ID = "idVerb";

        public static  String VERB_INFINITIF = "global_sentence";

        private static String DATABASE_CREATE_VERB_TABLE = "create table "
                + Constants.VERB_TABLE + "(" + Constants.VERB_ID
                + " integer primary key autoincrement, " + Constants.VERB_INFINITIF
                + " TEXT)";

        private static String DATABASE_INIT_VERB_TABLE ="insert into "+Constants.VERB_TABLE +
                "("+ Constants.VERB_INFINITIF+ ") VALUES ('être')" +
                ",('avoir'),('manger'),('aimer'),('commencer'),('acheter')";


        //création table temps des verbes
        public static String TEMPS_TABLE = "TEMPS";

        public static  String TEMPS_ID = "idTemps";

        public static  String TEMPS_name = "nameTemps";

        private static String DATABASE_CREATE_TEMPS_TABLE = "create table "
                + Constants.TEMPS_TABLE + "(" + Constants.TEMPS_ID
                + " integer primary key autoincrement, " + Constants.TEMPS_name
                + " TEXT)";

        private static String DATABASE_INIT_TEMPS_TABLE ="insert into "+Constants.TEMPS_TABLE +
                "("+ Constants.TEMPS_name+ ") VALUES ('Présent de lindicatif')" +
                ",('Futur de lindicatif'),('Imparfait de lindicatif'  )";

        //création table verbe conjugue
        public static String CONJUGATE_TABLE = "VERBE_CONJUGUE";

        public static  String CONJUGATE_ID = "idConjugaison";

        public static  String CONJUGATE_verb = "verbeConjugue";

        public static  String CONJUGATE_temps = "temps";

        public static  String CONJUGATE_personne = "personne";

        public static  String CONJUGATE_infinitif = "verbeInfinitif";

        private static String DATABASE_CREATE_CONJUGATE_TABLE = "create table "
                + Constants.CONJUGATE_TABLE + "(" + Constants.CONJUGATE_ID
                + " integer primary key autoincrement, " + Constants.CONJUGATE_verb
                + " TEXT," + Constants.CONJUGATE_infinitif + " integer,"
                + Constants.CONJUGATE_personne + " integer, "
                + Constants.CONJUGATE_temps + " integer, "
                + "FOREIGN KEY("+Constants.CONJUGATE_temps +") references "+Constants.TEMPS_TABLE +"("+
                Constants.TEMPS_ID+")"
                + ",FOREIGN KEY("+Constants.CONJUGATE_infinitif +") references "+Constants.VERB_TABLE +"("+
                Constants.VERB_ID+"))";

        private static String DATABASE_INIT_CONJUGATE_TABLE ="insert into "+Constants.CONJUGATE_TABLE
                + "("+ Constants.CONJUGATE_verb + "," + Constants.CONJUGATE_infinitif + "," + Constants.CONJUGATE_personne + "," + Constants.CONJUGATE_temps +")"
                + " VALUES "
                + "('mange', 3, 1, 1),"
                + "('manges', 3, 2, 1),"
                + "('mange', 3, 3, 1),"
                + "('mange', 3, 4, 1),"
                + "('mange', 3, 5, 1),"
                + "('mange', 3, 6, 1)";


        //création table phrase
        public static String SENTENCE_TABLE = "SENTENCE";

        public static  String SENTENCE_ID = "idSentence";

        public static  String SENTENCE_GLOBAL = "global_sentence";

        public static  String SENTENCE_verb = "conjugate_verb";

        private static String DATABASE_CREATE_SENTENCE_TABLE = "create table "
                + Constants.SENTENCE_TABLE + "(" + Constants.SENTENCE_ID
                + " integer primary key autoincrement, " + Constants.SENTENCE_GLOBAL
                + " TEXT, "+ Constants.SENTENCE_verb +" integer,"+
                "FOREIGN KEY("+Constants.SENTENCE_verb +") references "+Constants.CONJUGATE_TABLE+"("+
                Constants.CONJUGATE_ID+"))";

        private static String DATABASE_INIT_SENTENCE_TABLE ="insert into "+Constants.SENTENCE_TABLE
                + "("+ Constants.SENTENCE_GLOBAL + "," + Constants.SENTENCE_verb + ")"
                + " VALUES "
                + "('Tu ... une glace.', 2)";


        private static String DROP_SENTENCE_TABLE="DROP TABLE IF EXISTS "+SENTENCE_TABLE;
        private static String DROP_CONJUGATE_TABLE="DROP TABLE IF EXISTS "+CONJUGATE_TABLE;
        private static String DROP_VERB_TABLE="DROP TABLE IF EXISTS "+VERB_TABLE;
        private static String DROP_TEMPS_TABLE="DROP TABLE IF EXISTS "+TEMPS_TABLE;




    }

    public DBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                        int version) {
        super(context, name, factory, version);
    }
    public void resetDatabase(SQLiteDatabase sqLiteDatabase ){
        sqLiteDatabase.execSQL(Constants.DROP_FOURTH_TABLE);
        sqLiteDatabase.execSQL(Constants.DROP_FIRST_TABLE);
        sqLiteDatabase.execSQL(Constants.DROP_SENTENCE_TABLE);
        sqLiteDatabase.execSQL(Constants.DROP_TEMPS_TABLE);
        sqLiteDatabase.execSQL(Constants.DROP_CONJUGATE_TABLE);
        sqLiteDatabase.execSQL(Constants.DROP_VERB_TABLE);
        sqLiteDatabase.execSQL(Constants.DATABASE_INIT_FIRST_TABLE);
        sqLiteDatabase.execSQL(Constants.DATABASE_INIT_FOURTH_TABLE);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(Constants.DROP_FOURTH_TABLE);
        sqLiteDatabase.execSQL(Constants.DROP_FIRST_TABLE);
        sqLiteDatabase.execSQL(Constants.DROP_SENTENCE_TABLE);
        sqLiteDatabase.execSQL(Constants.DROP_CONJUGATE_TABLE);
        sqLiteDatabase.execSQL(Constants.DROP_VERB_TABLE);
        sqLiteDatabase.execSQL(Constants.DROP_TEMPS_TABLE);

        Log.d("score","initDatabase");


        sqLiteDatabase.execSQL(Constants.DATABASE_CREATE_FIRST_TABLE);
        Log.d("score","create first table");

        sqLiteDatabase.execSQL(Constants.DATABASE_CREATE_FOURTH_TABLE);
        Log.d("score","create fourth table");


        Log.d("score",Constants.DATABASE_CREATE_VERB_TABLE);
        sqLiteDatabase.execSQL(Constants.DATABASE_CREATE_VERB_TABLE);

        Log.d("score",Constants.DATABASE_CREATE_TEMPS_TABLE);
        sqLiteDatabase.execSQL(Constants.DATABASE_CREATE_TEMPS_TABLE);
        Log.d("score",Constants.DATABASE_CREATE_CONJUGATE_TABLE);
        sqLiteDatabase.execSQL(Constants.DATABASE_CREATE_CONJUGATE_TABLE);
        Log.d("score",Constants.DATABASE_CREATE_SENTENCE_TABLE);
        sqLiteDatabase.execSQL(Constants.DATABASE_CREATE_SENTENCE_TABLE);

        Log.d("score","create table");

        Log.d("score",Constants.DATABASE_INIT_FIRST_TABLE);
        sqLiteDatabase.execSQL(Constants.DATABASE_INIT_FIRST_TABLE);
        sqLiteDatabase.execSQL(Constants.DATABASE_INIT_FOURTH_TABLE);



        Log.d("score",Constants.DATABASE_INIT_VERB_TABLE);
        sqLiteDatabase.execSQL(Constants.DATABASE_INIT_VERB_TABLE);
        Log.d("score",Constants.DATABASE_INIT_TEMPS_TABLE);
        sqLiteDatabase.execSQL(Constants.DATABASE_INIT_TEMPS_TABLE);
        Log.d("score",Constants.DATABASE_INIT_CONJUGATE_TABLE);
        sqLiteDatabase.execSQL(Constants.DATABASE_INIT_CONJUGATE_TABLE);
        Log.d("score",Constants.DATABASE_INIT_SENTENCE_TABLE);
        sqLiteDatabase.execSQL(Constants.DATABASE_INIT_SENTENCE_TABLE);

        Log.d("score","populateTable");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(Constants.DROP_FOURTH_TABLE);
        sqLiteDatabase.execSQL(Constants.DROP_FIRST_TABLE);
    }
}
