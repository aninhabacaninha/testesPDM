package com.example.atividadeprprova;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity {

    private EditText editTextNome;
    private EditText editTextIdade;
    private EditText editTextDataNasc;
    private Button buttonCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        editTextNome = findViewById(R.id.editText_nome);
        editTextIdade = findViewById(R.id.editText_idade);
        editTextDataNasc = findViewById(R.id.editText_datanascimento);

        buttonCadastrar = findViewById(R.id.btnCadastrar);

    }
}