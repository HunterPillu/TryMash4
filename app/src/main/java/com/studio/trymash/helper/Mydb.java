package com.studio.trymash.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import com.studio.trymash.utils.Constant;

public class Mydb extends SQLiteOpenHelper {

    private static Mydb db;

    public static Mydb getDB(Context context) {
        if (null == db) {
            db = new Mydb(context, Constant.DB, null, 1);
        }
        return db;
    }

    private Mydb(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, Constant.DB_VERSION);
        Mydb.db = this;
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase arg0) {
        // TODO Auto-generated method stub
        arg0.execSQL(Constant.CREATE_TABLE_QUERY);
        for (int i = 1; i <= 1; i++) {
            arg0.execSQL("insert into rscore(id,name,score) values('" + i + "','kajal',30)");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub
    }
}
