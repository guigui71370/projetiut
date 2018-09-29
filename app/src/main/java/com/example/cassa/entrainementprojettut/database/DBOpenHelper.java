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
    }

    public DBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                        int version) {
        super(context, name, factory, version);
    }
    public void resetDatabase(SQLiteDatabase sqLiteDatabase ){
        sqLiteDatabase.execSQL(Constants.DROP_FOURTH_TABLE);
        sqLiteDatabase.execSQL(Constants.DROP_FIRST_TABLE);
        sqLiteDatabase.execSQL(Constants.DATABASE_INIT_FIRST_TABLE);
        sqLiteDatabase.execSQL(Constants.DATABASE_INIT_FOURTH_TABLE);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(Constants.DROP_FOURTH_TABLE);
        sqLiteDatabase.execSQL(Constants.DROP_FIRST_TABLE);

        Log.d("score","initDatabase");


        sqLiteDatabase.execSQL(Constants.DATABASE_CREATE_FIRST_TABLE);
        sqLiteDatabase.execSQL(Constants.DATABASE_CREATE_FOURTH_TABLE);

        Log.d("score","create table");

        Log.d("score",Constants.DATABASE_INIT_FIRST_TABLE);
        sqLiteDatabase.execSQL(Constants.DATABASE_INIT_FIRST_TABLE);
        sqLiteDatabase.execSQL(Constants.DATABASE_INIT_FOURTH_TABLE);
        Log.d("score","populateTable");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(Constants.DROP_FOURTH_TABLE);
        sqLiteDatabase.execSQL(Constants.DROP_FIRST_TABLE);
    }
}
