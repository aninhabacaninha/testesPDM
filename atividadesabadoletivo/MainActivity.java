package com.example.atividadesabadoletivo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    private EditText addtexto;
    private TextView mostrartexto;
    private Button salvar, apresentar;
    private String filename = "textinho.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addtexto = findViewById(R.id.editTextAddArquivo);
        mostrartexto = findViewById(R.id.textViewMostrarTexto);

        salvar = findViewById(R.id.buttonSalvar);
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream fos = openFileOutput(filename, Context.MODE_PRIVATE);
                    String data = addtexto.getText().toString();
                    fos.write(data.getBytes());
                    fos.flush();
                    fos.close();
                    addtexto.setText("");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        apresentar = findViewById(R.id.buttonApresentar);
        apresentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream fin = openFileInput(filename);
                    int a;
                    StringBuilder temp = new StringBuilder();
                    while((a = fin.read()) != -1) {
                        temp.append((char) a);
                    }

                    mostrartexto.setText(temp.toString());
                    fin.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}