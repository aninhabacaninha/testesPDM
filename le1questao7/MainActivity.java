package com.example.le1questao7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Funcionario> funcionarios = new ArrayList<>();
    private EditText editTextCodigo;
    private EditText editTextNome;
    private Spinner spinnerGenero;
    private EditText editTextIdade;
    private EditText editTextCargo;
    private Button btnCadastrar, btnApresentar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCodigo = findViewById(R.id.editText_Codigo);
        editTextNome = findViewById(R.id.editText_Nome);
        spinnerGenero = findViewById(R.id.spinner_Genero);
        editTextIdade = findViewById(R.id.editText_Idade);
        editTextCargo = findViewById(R.id.editText_Cargo);
        btnCadastrar = findViewById(R.id.button_Salvar);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextCodigo.getText();
                editTextNome.getText();
                editTextIdade.getText();
                editTextCargo.getText();
                spinnerGenero.getSelectedItemPosition();

                funcionarios.add(new Funcionario());
            }
        });

        btnApresentar = findViewById(R.id.button_Apresentar);
        btnApresentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MostrarFuncionarios.class);
                startActivity(intent);
            }
        });
    }
}
