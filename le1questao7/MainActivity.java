package com.example.le1questao7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Funcionario> funcionarios = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCadastrar = findViewById(R.id.button_Cadastrar);
        Button btnAtualizar = findViewById(R.id.button_Atualizar);
        ListView listViewFuncionarios = findViewById(R.id.listViewFunc);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Funcionario func1 = new Funcionario(1, "Walter", "M", "Cientista");
                funcionarios.add(func1);
            }
        });

        btnAtualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayAdapter<Funcionario> funcionarioArrayAdapter;
                funcionarioArrayAdapter = new ArrayAdapter<>(
                        MainActivity.this,
                        android.R.layout.simple_list_item_1,
                        funcionarios);

                    listViewFuncionarios.setAdapter(funcionarioArrayAdapter);
            }
        });
    }
}