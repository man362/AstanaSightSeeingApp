package com.androidapp.astanasightseeing.astanasightseeing;


import android.content.Context;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteAssetHelper {
    public static final String DATABASE_NAME = "astana.db";
    private static final int DATABASE_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}