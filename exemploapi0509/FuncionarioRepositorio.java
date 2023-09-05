package com.example.exemploapi0509;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FuncionarioRepositorio {

    private DBHelper helper;

    public FuncionarioRepositorio(Context context){
        helper = new DBHelper(context);
    }

    public long inserir(Funcionario funcionario){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put(DBHelper.COLUNA_NOME_FUNCIONARIO, funcionario.getNome());
        valores.put(DBHelper.COLUNA_CARGO_FUNCIONARIO, funcionario.getCargo());
        valores.put(DBHelper.COLUNA_SALARIO_FUNCIONARIO, funcionario.getSalario());
        valores.put(DBHelper.COLUNA_DATADENASCIMENTO_FUNCIONARIO, funcionario.getDataDeNascimento().getTime());
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        funcionario.getFoto().compress(Bitmap.CompressFormat.PNG, 100, stream);
        valores.put(DBHelper.COLUNA_FOTO_FUNCIONARIO, stream.toByteArray());
        long id = db.insert(DBHelper.TABELA_FUNCIONARIO, null, valores);
        db.close();
        return id;
    }

    public List<Funcionario> buscarTodosFuncionarios(){
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql ="SELECT * FROM " + DBHelper.TABELA_FUNCIONARIO + " ORDER BY " + DBHelper.COLUNA_NOME_FUNCIONARIO;
        Cursor cursor = db.rawQuery(sql, null);

        List<Funcionario> funcionarios = new ArrayList<>();
        while(cursor.moveToNext()){
            long id = cursor.getLong(0);
            String nome = cursor.getString(1);
            String cargo = cursor.getString(2);
            float salario = cursor.getFloat(3);
            Date dataDeNascimento = new Date(cursor.getLong(4));
            byte[] stream = cursor.getBlob(5);
            Bitmap foto = BitmapFactory.decodeByteArray(stream, 0, stream.length);
            Funcionario funcionario = new Funcionario(id, nome, cargo, salario, dataDeNascimento, foto);
            funcionarios.add(funcionario);
        }
        cursor.close();
        db.close();
        return funcionarios;
    }


}
