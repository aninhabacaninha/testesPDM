package com.example.le1questao7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class CadastraFuncionarioActivity extends AppCompatActivity {

    EditText editTextCodigo;
    EditText editTextNome;
    RadioGroup radioGroupGenero;
    EditText editTextCargo;
    Button bntCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_funcionario);

        initCadastro();
    }

    private void initCadastro() {
        editTextCodigo = findViewById(R.id.activity_cadastro_editText_codigo);
        editTextNome = findViewById(R.id.activity_cadastro_editText_Nome);
        radioGroupGenero = findViewById(R.id.radioGroup);
        editTextCargo = findViewById(R.id.activity_cadastro_editText_cargo);
        bntCadastrar = findViewById(R.id.activity_cadastro_button_cadastrar);

        Intent intent = getIntent();
        if (intent.hasExtra("funcionario")) {
            Funcionario funcionario = (Funcionario) intent.getSerializableExtra("funcionario");
        } else {
            
        }

        bntCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastroFuncionario();
            }
        });
    }

    private void cadastroFuncionario() {
        Funcionario funcionario = new Funcionario();
        funcionario.setCodigo(Integer.parseInt(editTextCodigo.getText().toString()));
        funcionario.setNome(editTextNome.getText().toString());
        char sexo = (radioGroupGenero.getCheckedRadioButtonId()==R.id.activity_cadastro_rbMasculino)?'M': 'F';
        funcionario.setSexo(sexo);
        funcionario.setCargo(editTextCargo.getText().toString());
        FuncionarioController funcionarioController = FuncionarioController.getInstancia();
        funcionarioController.cadastrar(funcionario);
        finish();
    }
}