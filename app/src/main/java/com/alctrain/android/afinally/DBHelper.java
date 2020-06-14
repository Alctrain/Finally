package com.alctrain.android.afinally;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DB_NAME = "myfinal.db";
    public static final String TB_NAME_USERS = "users";
    public static final String TB_NAME_GOODS = "goods";
    public static final String TB_NAME_ALCTRAIN = "alctrain";


    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                    int version) {
        super(context, name, factory, version);
    }
    public DBHelper(Context context) {
        super(context,DB_NAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TB_NAME_USERS+"(USERSID INTEGER PRIMARY KEY AUTOINCREMENT,USERSNAME TEXT,LIVE TEXT)");
        db.execSQL("CREATE TABLE "+TB_NAME_GOODS+"(GOODSID INTEGER PRIMARY KEY AUTOINCREMENT,GOODSNAME TEXT,GOODSPAY INTEGER,GOODSLIVE TEXT)");
        db.execSQL("CREATE TABLE "+TB_NAME_ALCTRAIN+"(GOODSID INTEGER PRIMARY KEY AUTOINCREMENT,GOODSWHERE TEXT,GOODSWHEN TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub
    }
}
