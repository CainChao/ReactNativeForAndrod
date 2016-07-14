package com.nativedemo;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.util.Log;

/**
 * Author YC
 * 2016/7/13 0013.
 */
public class CreateDataBase extends SQLiteOpenHelper{
    private String tableName;

    /**
     *
     * @param context
     * @param tableName 表名
     */
    public CreateDataBase(Context context,String tableName){
        this(context, "Preson.db", null, 1);
        this.tableName = tableName;
    }
    public CreateDataBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public CreateDataBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e("SUCCESS","DBSUCCESS");
        if(!TextUtils.isEmpty(tableName)){
            String schema = "create table"+tableName+"(_id integer primary key autoincrement, name, age)";
            db.execSQL(schema);

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
