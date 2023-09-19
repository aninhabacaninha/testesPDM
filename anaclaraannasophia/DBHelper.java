package com.example.anaclaraannasophia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String db_name = "DBUsuario";

    public static final String tabela = "Usuario";
    public static final String id = "id";
    public static final String nomeUsuario = "nomeUsuario";
    public static final String email = "email";
    public static final String senha = "senha";

    public DBHelper(Context context) {
        super(context, db_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Usuario (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nomeUsuario TEXT NOT NULL," +
                "email TEXT NOT NULL," +
                "senha INTEGER NOT NULL" +
                ");";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}