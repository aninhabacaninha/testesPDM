package com.example.le1questao3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextAltura = findViewById(R.id.editText_altura);
        Spinner spinnerGenero = findViewById(R.id.spinner_genero);
        Button buttonCalcular = findViewById(R.id.button_calcular);
        TextView textViewResultado = findViewById(R.id.textView_resultadoPesoIdeal);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double h = Double.parseDouble(editTextAltura.getText().toString());
                double resultadoPesoIdeal = 0;
                if(spinnerGenero.getSelectedItemPosition() == 0) {
                    resultadoPesoIdeal = (72.7 * h) - 58;
                } else {
                    resultadoPesoIdeal = (62.1 * h) - 44.7;
                }
                DecimalFormat formato = new DecimalFormat("#0.00");
                String resultadoFormatado = "Peso ideal: " + formato.format(resultadoPesoIdeal);
                textViewResultado.setText(resultadoFormatado);
            }
        });
    }
}