package com.example.le1questao7;

import androidx.appcompat.app.AppCompatActivity;

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

        editTextCodigo = findViewById(R.id.activity_cadastro_editText_codigo);
        editTextNome = findViewById(R.id.activity_cadastro_editText_Nome);
        radioGroupGenero = findViewById(R.id.radioGroup);
        editTextCargo = findViewById(R.id.activity_cadastro_editText_cargo);

        bntCadastrar = findViewById(R.id.activity_cadastro_button_cadastrar);
        bntCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Funcionario funcionario = new Funcionario();
                funcionario.setCodigo(Integer.parseInt(editTextCodigo.getText().toString()));
                funcionario.setNome(editTextNome.getText().toString());
                char sexo = (radioGroupGenero.getCheckedRadioButtonId()==R.id.activity_cadastro_rbMasculino)?'M': 'F';
                funcionario.setSexo(sexo);
                funcionario.setCargo(editTextCargo.getText().toString());
                MainActivity.funcionarios.add(funcionario);
                finish();
            }
        });
    }
}