package com.example.cassa.entrainementprojettut.database;

import android.content.Context;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Score.class, Infinitif.class, VerbeConjugue.class,EnglishWord.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;
    public abstract ScoreDao getScoreDao();
    public abstract InfinitifDao getInfinitifDao();
    public abstract VerbeConjugueDao getVerbeConjugueDao();
    public abstract EnglishwordDao getEnglishWordDao();
    private static final String DB_NAME="gameDatabase";

    public static AppDatabase getInstanceOfAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DB_NAME).fallbackToDestructiveMigration().allowMainThreadQueries().build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}

