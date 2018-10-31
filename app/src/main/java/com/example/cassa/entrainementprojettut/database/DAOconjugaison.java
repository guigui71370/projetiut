package com.example.cassa.entrainementprojettut.database;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;

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


    public  int findidvbinf(int id){
        open();
        int res=0;
        String query="select "+"bv."+DBOpenHelper.Constants.VERB_ID +
                " from "+DBOpenHelper.Constants.SENTENCE_TABLE +" phrase " +
                " join "+DBOpenHelper.Constants.CONJUGATE_TABLE+" vbconj on phrase."+DBOpenHelper.Constants.SENTENCE_verb+"= vbconj."+DBOpenHelper.Constants.CONJUGATE_ID +
                " join "+DBOpenHelper.Constants.VERB_TABLE+" bv on vbconj."+DBOpenHelper.Constants.CONJUGATE_infinitif+"= bv."+DBOpenHelper.Constants.VERB_ID+
                " WHERE phrase."+DBOpenHelper.Constants.SENTENCE_ID +"=? ;";
        Log.d("score",query);
        Cursor c=sqLiteDatabase.rawQuery(query,new String[]{String.valueOf(id)});
        while (c.moveToNext()){


            res= Integer.parseInt(c.getString(0));
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

    public  String findvbc(int id){
        open();
        String res=null;
        String query="select vbconj."+DBOpenHelper.Constants.CONJUGATE_verb+
                " from "+DBOpenHelper.Constants.SENTENCE_TABLE +" phrase " +
                " join "+DBOpenHelper.Constants.CONJUGATE_TABLE+" vbconj on phrase."+DBOpenHelper.Constants.SENTENCE_verb+"= vbconj."+DBOpenHelper.Constants.CONJUGATE_ID +
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

    public  int findvbcid(int id){
        open();
        int res=0;
        String query="select vbconj."+DBOpenHelper.Constants.CONJUGATE_ID+
                " from "+DBOpenHelper.Constants.SENTENCE_TABLE +" phrase " +
                " join "+DBOpenHelper.Constants.CONJUGATE_TABLE+" vbconj on phrase."+DBOpenHelper.Constants.SENTENCE_verb+"= vbconj."+DBOpenHelper.Constants.CONJUGATE_ID +
                " WHERE phrase."+DBOpenHelper.Constants.SENTENCE_ID +"=? ;";
        Log.d("score",query);
        Cursor c=sqLiteDatabase.rawQuery(query,new String[]{String.valueOf(id)});
        while (c.moveToNext()){


            res=Integer.parseInt( c.getString(0));
            for (int i = 0; i<c.getColumnCount(); i++) {
                Log.d("score_db_col", c.getColumnName(i));
            }
        }

        close();
        return res;

    }



    public ArrayList<String> listfindvbc(int idvb, int  idconj){
        open();
        ArrayList<String> res=new ArrayList<String>();
        String query="select vbconj."+DBOpenHelper.Constants.CONJUGATE_verb+
                " from "+DBOpenHelper.Constants.CONJUGATE_TABLE+" vbconj"+
                " WHERE vbconj."+DBOpenHelper.Constants.CONJUGATE_ID +"!=? and "+DBOpenHelper.Constants.CONJUGATE_infinitif+"=?;";
        Log.d("score",query);
        Cursor c=sqLiteDatabase.rawQuery(query,new String[]{String.valueOf(idconj),String.valueOf(idvb)});
        while (c.moveToNext()){


            res.add( c.getString(0));
            for (int i = 0; i<c.getColumnCount(); i++) {
                Log.d("score_db_col", c.getColumnName(i));
            }
        }

        close();
        return res;

    }

}
