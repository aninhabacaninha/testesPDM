package com.example.exemplobd01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Funcionario> funcionarios;
    private EditText editTextNome, editTextCargo;
    private Button btnCadastrar;
    private ListView listViewFuncionarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        funcionarios = new ArrayList<>();

        editTextNome = findViewById(R.id.editText_nome);
        editTextCargo = findViewById(R.id.editText_cargo);
        btnCadastrar = findViewById(R.id.button);

        listViewFuncionarios = findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter<> (
                this,
                android.R.layout.simple_list_item_1,
                funcionarios
            );
        listViewFuncionarios.setAdapter(adapter);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper helper = new DBHelper(MainActivity.this);
                SQLiteDatabase db = helper.getWritableDatabase();

                String nome = editTextNome.getText().toString();
                String cargo = editTextCargo.getText().toString();

                ContentValues cv = new ContentValues();
                cv.put("nome", nome);
                cv.put("cargo", cargo);
                long id = db.insert("Funcionario", null, cv);
                db.close();
            }
        });
    }
}