package com.example.atividadeprprova;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class BDHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "DBGestaoPessoa";
    public static final int VERSAO = 1;

    public static final String tabela_Pessoa = "Pessoa";
    public static final String id_Pessoa = "id";
    public static final String nome_Pessoa = "nome";
    public static final String idade_Pessoa = "idade";
    public static final String dataNascimento_Pessoa = "dataNascimento";

    public BDHelper(Context context) {
        super(context, DB_NAME, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Pessoa (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome TEXT NOT NULL," +
                "idade INTEGER," +
                "dataNascimento NUMERIC" +
                ");";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
