package com.example.atividadeprprova;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class ConsultaActivity extends AppCompatActivity {

    private ListView listinha;
    private Button buttonFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        listinha = findViewById(R.id.listView_listarpessoa);

        buttonFinalizar = findViewById(R.id.btn_finalizar);
        buttonFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(ConsultaActivity.this, MainActivity.class);
                startActivity(it);
            }
        });
    }
}