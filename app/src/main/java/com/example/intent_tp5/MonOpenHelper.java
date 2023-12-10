package com.example.intent_tp5;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MonOpenHelper extends SQLiteOpenHelper {

    public MonOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final String DATABASE_NAME = "users.db";

    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_TABLE_USERS =
            "CREATE TABLE USERS (" +
                    "EMAIL TEXT PRIMARY KEY," +
                    "FIRSTNAME TEXT," +
                    "LASTNAME TEXT," +
                    "USERNAME TEXT," +
                    "PASSWORD TEXT," +
                    "PHONE TEXT)";




    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
