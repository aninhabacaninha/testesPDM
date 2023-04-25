    package com.example.quest1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

    public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText valor = findViewById(R.id.addValor);
        EditText quant = findViewById(R.id.addQuant);
        Button calcular = findViewById(R.id.btnCalcVT);
        TextView textviewresultado = findViewById(R.id.valorTotal);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double valorcalc = Double.parseDouble(valor.getText().toString());
                double quantcalc = Double.parseDouble(quant.getText().toString());
                double valortotal = valorcalc * quantcalc;
            }
        });

    }
}