package com.example.anaclaraannasophia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositorio {
    DBHelper helper;
    SQLiteDatabase database;
    ContentValues valores;

    public UsuarioRepositorio(Context contexto) {
        helper = new DBHelper(contexto);
    }

    public boolean cadastrar(Usuario usuario) {
        database = helper.getWritableDatabase();
        valores = new ContentValues();

        valores.put(DBHelper.nomeUsuario, usuario.getNomeUsuario());
        valores.put(DBHelper.email, usuario.getEmail());
        valores.put(DBHelper.senha, usuario.getSenha());

        long id = database.insert(DBHelper.tabela, null, valores);
        database.close();

        if(id != -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean atualizar(Usuario usuario) {
        database = helper.getWritableDatabase();
        valores = new ContentValues();

        valores.put(DBHelper.nomeUsuario, usuario.getNomeUsuario());
        valores.put(DBHelper.email, usuario.getEmail());
        valores.put(DBHelper.senha, usuario.getSenha());

        String valuesWhere[] = new String[1];
        valuesWhere[0] = String.valueOf(usuario.getId());

        long qtnd = database.update(DBHelper.tabela, valores, "id = ?", valuesWhere);
        database.close();

        if(qtnd > 1) {
            return true;
        }else {
            return false;
        }
    }

    public List<Usuario> buscarTodos() {
        List<Usuario> usuarios = new ArrayList<>();
        database = helper.getReadableDatabase();

        String sql = "SELECT " + DBHelper.id + ", " +
                DBHelper.nomeUsuario + ", " +
                DBHelper.email + ", " +
                DBHelper.senha + " FROM " + DBHelper.tabela;

        Cursor cursor = database.rawQuery(sql, null);
        while(cursor.moveToNext()) {
            long id = cursor.getLong(0);
            String nomeUsuario = cursor.getString(1);
            String email = cursor.getString(2);
            int senha = cursor.getInt(3);

            Usuario usuario = new Usuario(id, nomeUsuario, email, senha);
            usuarios.add(usuario);
        }

        return usuarios;
    }
}
