package com.example.atividadeprprova;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PessoaRepositorio {
    BDHelper helper;
    List<Pessoa> pessoas = new ArrayList<>();

    public PessoaRepositorio(Context contexto) {
        helper = new BDHelper(contexto);
    }

    public boolean inserir(Pessoa pessoa) {
        SQLiteDatabase database = helper.getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put(helper.nome_Pessoa, pessoa.getNome());
        valores.put(helper.idade_Pessoa, pessoa.getIdade());
        valores.put(helper.dataNascimento_Pessoa, pessoa.getDataNasc().getTime());

        long id = database.insert(helper.tabela_Pessoa, null, valores);
        database.close();

        if (id != -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean atualizar(Pessoa pessoa) {
        SQLiteDatabase database = helper.getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put(helper.nome_Pessoa, pessoa.getNome());
        valores.put(helper.idade_Pessoa, pessoa.getIdade());
        valores.put(helper.dataNascimento_Pessoa, pessoa.getDataNasc().getTime());

        String valoresWhere[] = new String[1];
        valoresWhere[0] = String.valueOf(pessoa.getId());

        long qtde = database.update(helper.tabela_Pessoa, valores, "id = ?", valoresWhere);
        database.close();

        if(qtde>1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean excluir(Pessoa pessoa) {
        SQLiteDatabase database = helper.getWritableDatabase();
        String[] valores = {String.valueOf(pessoa.getId())};

        long qtde = database.delete(helper.tabela_Pessoa, "id = ?", valores);
        database.close();

        if(qtde>0) {
            return true;
        } else {
            return false;
        }
    }

    public List<Pessoa> buscar() {
        List<Pessoa> pessoas = new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "SELECT "+ helper.id_Pessoa + "," +
                helper.nome_Pessoa + "," +
                helper.idade_Pessoa + "," +
                helper.dataNascimento_Pessoa + " FROM " + helper.tabela_Pessoa;

        Cursor cursor = db.rawQuery(sql, null);
        while(cursor.moveToNext()) {
            long id = cursor.getLong(0);
            String nome = cursor.getString(1);
            int idade = cursor.getInt(2);
            Date dataNascimento = new Date(cursor.getLong(3));

            Pessoa pessoa = new Pessoa(id, nome, idade, dataNascimento);
            pessoas.add(pessoa);
        }
            return pessoas;
    }

    public List<Pessoa> buscarPorNome(String nome) {
        List<Pessoa> pessoas = new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "SELECT "+ helper.nome_Pessoa + " FROM " + helper.tabela_Pessoa + "LIKE ";


        return pessoas;
    }
}
