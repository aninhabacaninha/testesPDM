package com.example.anaclaraannasophia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CadastroActivity extends AppCompatActivity {
    UsuarioRepositorio usuRep;
    private EditText nomeUsuario;
    private EditText ETemail;
    private EditText ETsenha;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        nomeUsuario = findViewById(R.id.editTextNomeUsuario);
        ETemail = findViewById(R.id.editTextEmail);
        ETsenha = findViewById(R.id.editTextSenha);

        button = findViewById(R.id.btnCadastrar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = nomeUsuario.getText().toString();
                String email = ETemail.getText().toString();
                int senha = Integer.parseInt(ETsenha.getText().toString());

                Usuario usuario = new Usuario(nome, email, senha);
                usuRep.cadastrar(usuario);
            }
        });
    }
}