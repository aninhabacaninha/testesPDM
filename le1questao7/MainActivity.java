package com.example.le1questao7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnCadastrar;
    Button btnAtualizar;
    ListView listViewFuncionarios;
    private FuncionarioController funcionarioController;
    private ListaFuncionariosAdapter listaFuncionariosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCadastrar = findViewById(R.id.button_Cadastrar);
        btnAtualizar = findViewById(R.id.button_Atualizar);
        listViewFuncionarios = findViewById(R.id.listViewFunc);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarCadastro();
            }
        });

        btnAtualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                atualizarLista();
            }
        });

        listViewFuncionarios.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Funcionario funcionario = funcionarioController.buscarPorPosicao(position);
                funcionarioController.remover(funcionario);
                return true;
            }
        });

        listViewFuncionarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(MainActivity.this, CadastraFuncionarioActivity.class);
                Funcionario funcionario = funcionarioController.buscarPorPosicao(position);
                it.putExtra("funcionario", funcionario);
                startActivity(it);
            }
        });
    }

    private void atualizarLista() {
        funcionarioController = FuncionarioController.getInstancia();
        listaFuncionariosAdapter = new ListaFuncionariosAdapter(MainActivity.this);
        listViewFuncionarios.setAdapter(listaFuncionariosAdapter);
    }

    private void iniciarCadastro() {
        Intent it = new Intent(MainActivity.this, CadastraFuncionarioActivity.class);
        startActivity(it);
    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizarLista();
    }
}