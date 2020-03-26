package com.example.priyecto;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import androidx.annotation.Nullable;

public class MySQLiteHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DB_NAME = "oaxaca.sqlite";
    private static final String USUARIOS_TABLE_CREATE = "CREATE TABLE usuarios(_id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, paterno TEXT, materno TEXT, usuario TEXT, password TEXT)";

    public MySQLiteHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(USUARIOS_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
