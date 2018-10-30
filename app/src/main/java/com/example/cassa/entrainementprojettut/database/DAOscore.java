package com.example.cassa.entrainementprojettut.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.cassa.entrainementprojettut.database.DBOpenHelper.Constants;
import com.example.cassa.entrainementprojettut.playerUtils.Score;

/**
 * Created by clement on 07/02/18.
 */

public class DAOscore extends DAOconnection {

    private static DAOscore instance;


    private DAOscore(Context context) {
        super(context);
    }

    public static DAOscore getInstance(Context context){
        if(instance==null){
            instance=new DAOscore(context);
        }
        return instance;
    }

    public Score findScoreForAGame(String gameName,int difficulty){
        open();
        Score res=null;
        String query="select player, score "+
                " from "+Constants.FOURTH_TABLE+" score "+
                " JOIN "+Constants.FIRST_TABLE+" game on game.idGame=score.idGame "+
                " WHERE "+Constants.COL_GAME_NAME_TABLE_1 +" =? and "+Constants.COL_DIFFICULTY_TABLE_1+"=?";
        Log.d("score",query);
        Cursor c=sqLiteDatabase.rawQuery(query,new String[]{gameName,String.valueOf(difficulty)});
        while (c.moveToNext()){
            String playerName=c.getString(0);
            long score=c.getLong(1);
            res=new Score(gameName,playerName,score,difficulty);
            for (int i = 0; i<c.getColumnCount(); i++) {
                Log.d("score_db_col", c.getColumnName(i));
            }
        }
        c.close();
        return res;
    }

    public void updateScore(Score score){
        int gameId=getGameIdFromGameName(score.getGameName(),score.getDifficulty());
        ContentValues value = new ContentValues();

         value.put(Constants.COL_SCORE_TABLE_4, score.getValue());
         value.put(Constants.COL_PLAYER_TABLE_4,score.getPlayerName());
         sqLiteDatabase.update(Constants.FOURTH_TABLE,
                 value,
                 Constants.COL_GAME_TABLE_4 + " = ?",
                 new String[] {String.valueOf(gameId)});
    }

    public boolean timeScoreBreaked(Score score){
        Score actualScore=findScoreForAGame(score.getGameName(),score.getDifficulty());
        return (actualScore.getValue()>score.getValue() || actualScore.getValue()==0);
    }

    public boolean pointScoreBreaked(Score score){
        Score actualScore=findScoreForAGame(score.getGameName(),score.getDifficulty());
        return (actualScore.getValue()<score.getValue() || actualScore.getValue()==0);
    }

    public int getGameIdFromGameName(String gameName,int difficulty){
        open();
        int gameId=0;
        String query="select idGame "+
                " from "+Constants.FIRST_TABLE +
                " WHERE "+Constants.COL_GAME_NAME_TABLE_1 +" =? and "+Constants.COL_DIFFICULTY_TABLE_1+" =?";
        Log.d("score",query);
        Cursor c=sqLiteDatabase.rawQuery(query,new String[]{gameName,String.valueOf(difficulty)});
        while (c.moveToNext()){
            gameId=c.getInt(0);


        }
        c.close();
        return gameId;
    }
}
