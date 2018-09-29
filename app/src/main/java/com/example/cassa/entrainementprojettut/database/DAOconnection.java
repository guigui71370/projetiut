package com.example.cassa.entrainementprojettut.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.example.cassa.entrainementprojettut.database.DBOpenHelper.Constants;

/**
 * Created by clement on 07/02/18.
 */

public abstract class DAOconnection {

    protected SQLiteDatabase sqLiteDatabase=null;
    protected DBOpenHelper dbOpenHelper=null;

    public DAOconnection(Context context) {
        this.dbOpenHelper=new DBOpenHelper(context,Constants.DATABASE_NAME,null, Constants.DATABASE_VERSION);
    }

    public SQLiteDatabase open(){
        try {
            sqLiteDatabase=dbOpenHelper.getWritableDatabase();
        }catch (SQLiteException e){
            e.printStackTrace();
        }
        return sqLiteDatabase;
    }

    public void close(){
        sqLiteDatabase.close();
    }

    public SQLiteDatabase getSqLiteDatabase() {
        return sqLiteDatabase;
    }
}
