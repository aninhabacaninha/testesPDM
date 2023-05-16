package com.example.le1questao7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<Funcionario> funcionarios = new ArrayList<>();

    Button btnCadastrar;
    Button btnAtualizar;
    ListView listViewFuncionarios;

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
                Intent it = new Intent(MainActivity.this, CadastraFuncionarioActivity.class);
                startActivity(it);
            }
        });

        btnAtualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ListaFuncionariosAdapter listaFuncionariosAdapter = new ListaFuncionariosAdapter(
                        MainActivity.this,
                        funcionarios
                );

                listViewFuncionarios.setAdapter(listaFuncionariosAdapter);
            }
        });
    }
}