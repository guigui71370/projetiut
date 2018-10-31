package com.example.cassa.entrainementprojettut.database;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

public class DAOconjugaison extends DAOconnection{

    private static DAOconjugaison instance;


    private DAOconjugaison(Context context) {
        super(context);
    }

    public static DAOconjugaison getInstance(Context context){
        if(instance==null){
            instance=new DAOconjugaison(context);
        }
        return instance;
    }

    public  String findSentents(int id){
        open();
        String res=null;
        String query="select phrase."+DBOpenHelper.Constants.SENTENCE_GLOBAL+",bv."+DBOpenHelper.Constants.VERB_INFINITIF +
                " from "+DBOpenHelper.Constants.SENTENCE_TABLE +" phrase " +
                " join "+DBOpenHelper.Constants.CONJUGATE_TABLE+" vbconj on phrase."+DBOpenHelper.Constants.SENTENCE_verb+"= vbconj."+DBOpenHelper.Constants.CONJUGATE_ID +
                " join "+DBOpenHelper.Constants.VERB_TABLE+" bv on vbconj."+DBOpenHelper.Constants.CONJUGATE_infinitif+"= bv."+DBOpenHelper.Constants.VERB_ID+
                " WHERE phrase."+DBOpenHelper.Constants.SENTENCE_ID +"=? ;";
        Log.d("score",query);
        Cursor c=sqLiteDatabase.rawQuery(query,new String[]{String.valueOf(id)});
        while (c.moveToNext()){


            res= c.getString(0)+"(" +c.getString(1)+")";
            for (int i = 0; i<c.getColumnCount(); i++) {
                Log.d("score_db_col", c.getColumnName(i));
            }
        }

        close();
        return res;

    }




    public  String findtemp(int id ){
        open();
        String res=null;
        String query="select tmp."+DBOpenHelper.Constants.TEMPS_name +
                " from "+DBOpenHelper.Constants.SENTENCE_TABLE +" phrase " +
                " join "+DBOpenHelper.Constants.CONJUGATE_TABLE+" vbconj on phrase."+DBOpenHelper.Constants.SENTENCE_verb+"= vbconj."+DBOpenHelper.Constants.CONJUGATE_ID +
                " join "+DBOpenHelper.Constants.TEMPS_TABLE+" tmp on vbconj."+DBOpenHelper.Constants.CONJUGATE_temps+"= tmp."+DBOpenHelper.Constants.TEMPS_ID+
                " WHERE phrase."+DBOpenHelper.Constants.SENTENCE_ID +"=? ;";
        Log.d("score",query);
        Cursor c=sqLiteDatabase.rawQuery(query,new String[]{String.valueOf(id)});
        while (c.moveToNext()){


            res= c.getString(0);
            for (int i = 0; i<c.getColumnCount(); i++) {
                Log.d("score_db_col", c.getColumnName(i));
            }
        }

        close();
        return res;

    }
}
