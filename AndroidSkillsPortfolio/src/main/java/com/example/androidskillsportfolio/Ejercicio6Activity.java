package com.example.androidskillsportfolio;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Ejercicio6Activity extends AppCompatActivity {

    private EditText txtPrimerTrimestre, txtSegundoTrimestre, txtTercerTrimestre;
    private TextView lblNotaFinal, lblResultado, tvDescripcion5;
    private Button btnCalcular, btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio6);

        txtPrimerTrimestre = findViewById(R.id.txtPrimerTrimestre);
        txtSegundoTrimestre = findViewById(R.id.txtSegundoTrimestre);
        txtTercerTrimestre = findViewById(R.id.txtTercerTrimestre);
        lblNotaFinal = findViewById(R.id.lblNotaFinal);
        lblResultado = findViewById(R.id.lblResultado);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnVolver = findViewById(R.id.btnVolver);
        tvDescripcion5 = findViewById(R.id.tvDescripcion5);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularNota();
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // Vuelve al menú anterior
            }
        });
    }

    private void calcularNota() {
        String n1 = txtPrimerTrimestre.getText().toString().trim();
        String n2 = txtSegundoTrimestre.getText().toString().trim();
        String n3 = txtTercerTrimestre.getText().toString().trim();

        if (n1.isEmpty() || n2.isEmpty() || n3.isEmpty()) {
            lblNotaFinal.setText("Introduce todas las notas.");
            lblResultado.setText("");
            lblNotaFinal.setTextColor(Color.RED);
            lblResultado.setTextColor(Color.RED);
            return;
        }

        try {
            double nota1 = Double.parseDouble(n1);
            double nota2 = Double.parseDouble(n2);
            double nota3 = Double.parseDouble(n3);

            double media = (nota1 + nota2 + nota3) / 3.0;
            lblNotaFinal.setText(String.format("Nota final: %.2f", media));

            if (media < 5) {
                lblResultado.setText("NO APROBADO");
                lblNotaFinal.setTextColor(Color.RED);
                lblResultado.setTextColor(Color.RED);
            } else {
                lblResultado.setText("APROBADO");
                lblNotaFinal.setTextColor(Color.BLACK);
                lblResultado.setTextColor(Color.BLACK);
            }
        } catch (NumberFormatException e) {
            lblNotaFinal.setText("Valor no válido.");
            lblResultado.setText("");
            lblNotaFinal.setTextColor(Color.RED);
            lblResultado.setTextColor(Color.RED);
        }
    }
}